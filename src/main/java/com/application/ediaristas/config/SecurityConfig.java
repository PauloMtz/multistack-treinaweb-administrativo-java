package com.application.ediaristas.config;

import com.application.ediaristas.core.models.TipoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ---- configuração para a API ----
    // esse @Order é para informar a preferência na hora de subir a aplicação
    @Order(1)
    @Configuration
    public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .requestMatchers(requestMatcherCustomizer ->
                    requestMatcherCustomizer
                        .antMatchers("/api/**", "/auth/**")
                )
                .authorizeRequests(authorizeRequestsCustomizer ->
                    authorizeRequestsCustomizer
                        .anyRequest()
                        .permitAll()
                )
                .csrf(csrfCustomizer ->
                    csrfCustomizer
                        .disable()
                )
                .sessionManagement(sessionManagementCustomizer->
                    sessionManagementCustomizer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .cors();
        }

        @Bean
        @Override
        protected AuthenticationManager authenticationManager() throws Exception {
            return super.authenticationManager();
        }
    }

    // ----- configuração para a aplicação web -----
    @Order(2)
    @Configuration
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
            http
                .requestMatchers(requestMatcherCustomizer -> 
                    requestMatcherCustomizer
                        .antMatchers("/admin/**")
            )
            .authorizeRequests(authorizeRequestsCustomizer -> 
                authorizeRequestsCustomizer
                    .anyRequest()
                    .hasAnyAuthority(TipoUsuario.ADMIN.name())
            )
            .formLogin(formLoginCustomizer -> 
                formLoginCustomizer
                    .loginPage("/admin/auth/login")
                    .usernameParameter("email")
                    .passwordParameter("senha")
                    .defaultSuccessUrl("/admin/servicos")
                    .permitAll()
            )
            .logout(logoutCustomizer ->
                logoutCustomizer
                    .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout", "GET"))
                    .logoutSuccessUrl("/admin/login")
            )
            .rememberMe(rememberMeCustomizer -> 
                rememberMeCustomizer
                    .rememberMeParameter("lembrar-me")
                    .tokenValiditySeconds(rememberMeValiditySeconds)
                    .key(rememberMeKey)
            )
            .exceptionHandling(exceptionHandlingCustomizer -> 
                exceptionHandlingCustomizer
                    .accessDeniedPage("/admin/login")
            );
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                .antMatchers("/webjars/**");
        }
    }

    /**
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/uploads").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/auth/**").permitAll()
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

        http.cors();
        http.csrf()
            .ignoringAntMatchers("/api/**")
            .ignoringAntMatchers("/auth/**");
    }*/
}