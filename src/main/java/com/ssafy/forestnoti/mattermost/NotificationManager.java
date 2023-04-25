package com.ssafy.forestnoti.mattermost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationManager {

    private Logger log = LoggerFactory.getLogger(NotificationManager.class);

    private MattermostSender mmSender;

    public void sendNotification(Exception e, String uri, String params) {
        log.info("#### SEND Notification");
        mmSender.sendMessage(e, uri, params);
    }
}
