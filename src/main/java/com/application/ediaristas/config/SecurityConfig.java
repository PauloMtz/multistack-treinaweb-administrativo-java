package com.application.ediaristas.config;

import com.application.ediaristas.core.models.TipoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${com.application.ediaristas.rememberMe.key}")
    private String rememberMeKey;

    @Value("${com.application.ediaristas.validitySeconds}")
    private int rememberMeValiditySeconds;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasAuthority(TipoUsuario.ADMIN.toString())
            .antMatchers("/img/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .anyRequest().authenticated();

        http.formLogin()
            .loginPage("/admin/login")
            .usernameParameter("email")
            .passwordParameter("senha")
            .defaultSuccessUrl("/admin/servicos")
            .permitAll();

        http.logout()
            //.logoutUrl("/admin/logout");
            .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
            .logoutSuccessUrl("/admin/login");

        http.rememberMe()
            .rememberMeParameter("lembrar-me")
            .tokenValiditySeconds(rememberMeValiditySeconds)
            .key(rememberMeKey);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/webjars/**");
    }
}