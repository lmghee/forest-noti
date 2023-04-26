package com.ssafy.forest.mattermost;

import com.google.gson.Gson;
import com.ssafy.forest.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ssafy.forest.mattermost.MattermostMessageDto.Attachment;
import com.ssafy.forest.mattermost.MattermostMessageDto.Attachments;

@Component
public class MattermostSender {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${notification.mattermost.enabled}")
    private boolean mmEnabled;
    @Value("${notification.mattermost.webhook-url}")
    private String webhookUrl;

    private final RestTemplate restTemplate;
    private final MattermostProperties mattermostProperties;

    public MattermostSender(RestTemplate restTemplate, MattermostProperties mattermostProperties) {
        this.restTemplate = restTemplate;
        this.mattermostProperties = mattermostProperties;
    }

    public void sendMessage(CustomException exception, String uri, String params) {
        if(!mmEnabled) return;

        try {
            Attachment attachment = Attachment.builder()
                    .channel(mattermostProperties.getChannel())
                    .authorIcon(mattermostProperties.getAuthorIcon())
                    .authorName(mattermostProperties.getAuthorName())
                    .color(mattermostProperties.getColor())
                    .pretext(mattermostProperties.getPretext())
                    .title(mattermostProperties.getTitle())
                    .text(mattermostProperties.getText())
                    .footer(mattermostProperties.getFooter())
                    .build();

            attachment.addExceptionInfo(exception, uri, params);
            Attachments attachments = new Attachments(attachment);
            attachments.addProps(exception);
            String payload = new Gson().toJson(attachments);

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-type", MediaType.APPLICATION_JSON_VALUE);

            HttpEntity<String> entity = new HttpEntity<>(payload, headers);
            restTemplate.postForEntity(webhookUrl, entity, String.class);
        } catch (Exception e) {
            log.error("#### ERROR!! Notification Manager : {}", e.getMessage());
        }
    }
}
