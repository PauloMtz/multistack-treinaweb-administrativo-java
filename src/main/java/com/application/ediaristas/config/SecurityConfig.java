package com.application.ediaristas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.application.ediaristas.core.enums.TipoUsuario;
import com.application.ediaristas.core.filters.AccessTokenRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private AccessTokenRequestFilter accessTokenFilter;

    // em /api/handlers --> TokenAuthenticationEntryPoint
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    // idem
    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Value("${com.application.ediaristas.rememberMe.key}")
    private String rememberMeKey;

    @Value("${com.application.ediaristas.validitySeconds}")
    private int rememberMeValiditySeconds;

    @Bean
    @Order(1)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) 
        throws Exception {

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
            .addFilterBefore(accessTokenFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling(exceptionHandlingCustomizer ->
                exceptionHandlingCustomizer
                    .authenticationEntryPoint(authenticationEntryPoint)
                    .accessDeniedHandler(accessDeniedHandler)
            )
            .cors(); // essas exceções acontecem no filter - antes do controller

        return http.build();
    }
    
    @Bean
    @Order(2)
    public SecurityFilterChain webSecurityFilterChain(HttpSecurity http) 
        throws Exception {

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
                    .loginPage("/admin/login")
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

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
            .antMatchers("/webjars/**")
            .antMatchers("/img/**");
    }

    @Bean
    public AuthenticationManager manager(AuthenticationConfiguration configuration)
        throws Exception {

        return configuration.getAuthenticationManager();
    }
}
