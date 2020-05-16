package com.livefox.clientui.configuration;

import com.livefox.clientui.exception.CustomErrorDecoder;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public CustomErrorDecoder customErrorDecoder(){
        return new CustomErrorDecoder();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthenticationInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }
}
