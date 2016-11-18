package com.community;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This is a Spring Security configuration.
 * This class defines users, roles, and protected URLs.
 * For information on how it works see:
 * http://websystique.com/spring-security/spring-security-4-hello-world-annotation-xml-example/
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        // TODO: read credentials from a config file.
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO: create an access denied page
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .and().formLogin();
                // The Access Denied page is only displayed if the login is valid but the login role is not valid.
                // We only have an admin role at this point so it may not be needed.
                //.and().exceptionHandling().accessDeniedPage("/index/accessDenied.html");

    }
}