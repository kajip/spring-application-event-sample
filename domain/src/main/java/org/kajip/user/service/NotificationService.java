package org.kajip.user.service;

import org.kajip.user.event.CompleteUserRegistration;
import org.kajip.user.event.CompleteUserRegistrationCancel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 通知サービス
 */
@Service
public class NotificationService {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * ユーザが登録処理の結果を通知する
     * @param event
     */
    @EventListener
    @Async
    public void notifyOfUserRegistration(CompleteUserRegistration event) {
        if (event.isSuccess()) {
            logger.info("ユーザー登録が完了しました。 {}", event.getUser());
        } else {
            logger.info("ユーザー登録に失敗しました。 {}", event.getUser());
        }
    }


    /**
     * ユーザが登録解除処理の結果を通知する
     * @param event
     */
    @EventListener
    @Async
    public void notifyOfUserRegistrationCancel(CompleteUserRegistrationCancel event) {
        if (event.isSuccess()) {
            logger.info("ユーザー登録解除が完了しました。 {}", event.getUser());
        } else {
            logger.info("ユーザー登録解除に失敗しました。 {}", event.getUser());
        }
    }
}
