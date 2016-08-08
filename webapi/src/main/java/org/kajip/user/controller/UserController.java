package org.kajip.user.controller;

import org.kajip.user.domain.Account;
import org.kajip.user.domain.Password;
import org.kajip.user.domain.User;
import org.kajip.user.event.RequestForUserRegistration;
import org.kajip.user.event.RequestForUserRegistrationCancel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ユーザ管理API
 */
@RestController
public class UserController {

    @Autowired
    ApplicationEventPublisher  publisher;

    @RequestMapping("/register")
    @ResponseBody
    public void register() {

        User user = new User(new Account("hogehoge"), new Password("hogehoge"));
        publisher.publishEvent(new RequestForUserRegistration(user));
    }

    @RequestMapping("/cancelRegistration")
    @ResponseBody
    public void cancelRegistration() {

        User user = new User(new Account("hogehoge"), new Password("hogehoge"));
        publisher.publishEvent(new RequestForUserRegistrationCancel(user));
    }
}
