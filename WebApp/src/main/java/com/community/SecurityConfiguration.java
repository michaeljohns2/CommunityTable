package com.community;

import com.community.utils.ConfigManager;
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

        auth.inMemoryAuthentication()
                .withUser(ConfigManager.getInstance().getSetting(ConfigManager.AUTH_ADMIN_USER_KEY))
                .password(ConfigManager.getInstance().getSetting(ConfigManager.AUTH_ADMIN_PASSWORD_KEY))
                .roles(ConfigManager.getInstance().getSetting(ConfigManager.AUTH_ADMIN_ROLE_KEY));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .access(String.format("hasRole('%s')",ConfigManager.getInstance().getSetting(ConfigManager.AUTH_ADMIN_ROLE_KEY)))
                .and().formLogin()
                .loginPage("/login.html")
                .usernameParameter("username").passwordParameter("password");
                // The Access Denied page is only displayed if the login is valid but the login role is not valid.
                // We only have an admin role at this point so it may not be needed.
                //.and().exceptionHandling().accessDeniedPage("/index/accessDenied.html");

    }
}