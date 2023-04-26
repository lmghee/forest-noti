package com.ssafy.forest.config;

import com.ssafy.forest.controller.ControllerAdvice;
import com.ssafy.forest.mattermost.MattermostProperties;
import com.ssafy.forest.mattermost.MattermostSender;
import com.ssafy.forest.mattermost.NotificationManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(MattermostProperties.class)
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public MattermostSender mattermostSender(MattermostProperties mattermostProperties) {
//        return new MattermostSender(restTemplate(), mattermostProperties);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public NotificationManager notificationManager(MattermostProperties mattermostProperties) {
//        return new NotificationManager(mattermostSender(mattermostProperties));
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public ControllerAdvice controllerAdvice(MattermostProperties mattermostProperties) {
//        return new ControllerAdvice(notificationManager(mattermostProperties));
//    }

}