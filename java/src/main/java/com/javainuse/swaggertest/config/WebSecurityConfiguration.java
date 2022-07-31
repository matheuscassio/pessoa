package com.javainuse.swaggertest.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {

    /*@Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring()
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html**",
                        "/webjars/**");
    }*/
}