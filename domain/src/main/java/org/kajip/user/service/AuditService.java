package org.kajip.user.service;

import org.kajip.user.event.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 監査サービス
 */
@Service
public class AuditService {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * ユーザイベントの監査ログを残す
     * @param event
     */
    @EventListener
    @Async
    public void loggingUserEvent(UserEvent event) {
        logger.info("event : {}", event);
    }
}
