package com.yang.order.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FeignConfig {


    @Bean
    @Profile("dev")
    public Logger.Level feignDevLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    @Profile("prod")
    public Logger.Level feignProdLoggerLevel(){
        return Logger.Level.BASIC;
    }

    @Bean
    public ErrorDecoder feignErrorDecoder() {
        return new FeignErrorDecode();
    }

    @Bean
    public Decoder feignDecoder() {
        return new ResultDecode();
    }
}
