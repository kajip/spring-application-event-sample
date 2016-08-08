package org.kajip.user.service;

import org.kajip.user.event.CompleteUserRegistration;
import org.kajip.user.event.CompleteUserRegistrationCancel;
import org.kajip.user.event.RequestForUserRegistration;
import org.kajip.user.event.RequestForUserRegistrationCancel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * ユーザ管理サービス
 */
@Service
public class UserManagementService {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * ユーザ登録のイベントリスナー
     */
    @EventListener
    public CompleteUserRegistration registerUser(RequestForUserRegistration request) {
        logger.info("Register user: {}", request.getUser());

        return new CompleteUserRegistration(request.getUser(), true);
    }

    /**
     * ユーザ登録解除のイベントリスナー
     */
    @EventListener
    public CompleteUserRegistrationCancel cancelUserRegisteration(RequestForUserRegistrationCancel request) {
        logger.info("Cancel user registration: {}", request.getUser());

        return new CompleteUserRegistrationCancel(request.getUser(), true);
    }
}
