package com.ssafy.forest.mattermost;

import com.ssafy.forest.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    private Logger log = LoggerFactory.getLogger(NotificationManager.class);

    @Autowired
    private MattermostSender mmSender;

//    public NotificationManager(MattermostSender mmSender) {
//        this.mmSender = mmSender;
//    }

    public void sendNotification(CustomException e, String uri, String params) {
        log.info("#### SEND Notification");
        mmSender.sendMessage(e, uri, params);
    }
}