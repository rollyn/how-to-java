package com.wisphil.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {
//
    @Autowired
    DataSource dataSource;
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
////
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER");
//
        auth.jdbcAuthentication().dataSource(dataSource);
//        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer =
//                auth.jdbcAuthentication().dataSource(dataSource);
////
//        if (!dataSource.getConnection().getMetaData().getTables(null, "", "USERS", null).first()) {
//            configurer = configurer.withDefaultSchema();
//        }
    }
//
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}