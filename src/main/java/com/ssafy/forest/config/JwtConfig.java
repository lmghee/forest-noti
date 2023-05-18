package com.ssafy.forest.config;

import com.ssafy.forest.jwt.JwtDecoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class JwtConfig {

    @Bean
    @ConditionalOnMissingBean
    public JwtDecoder jwtDecoder() {
        return new JwtDecoder();
    }

}