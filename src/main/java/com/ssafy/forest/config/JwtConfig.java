package com.ssafy.forest.config;

import com.ssafy.forest.controller.ControllerAdvice;
import com.ssafy.forest.mattermost.MattermostProperties;
import com.ssafy.forest.mattermost.MattermostSender;
import com.ssafy.forest.mattermost.NotificationManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties
public class JwtConfig {

}