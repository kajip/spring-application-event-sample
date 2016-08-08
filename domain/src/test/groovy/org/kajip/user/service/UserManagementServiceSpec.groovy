package org.kajip.user.service

import org.kajip.user.UserConfigration
import org.kajip.user.domain.Account
import org.kajip.user.domain.Password
import org.kajip.user.domain.User
import org.kajip.user.event.CompleteUserRegistration
import org.kajip.user.event.CompleteUserRegistrationCancel
import org.kajip.user.event.RequestForUserRegistration
import org.kajip.user.event.RequestForUserRegistrationCancel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [UserConfigration.class])
class UserManagementServiceSpec extends Specification {

    @Autowired
    UserManagementService  userManagementService;

    def "ユーザを登録する"() {
        setup:
        def request = new RequestForUserRegistration(user)

        when:
        def result = userManagementService.registerUser(request)

        then:
        result instanceof CompleteUserRegistration
        result.user == user
        result.success

        where:
        user = new User(new Account("scott"), new Password("tiger"))
    }

    def "ユーザ登録を解除する"() {
        setup:
        def request = new RequestForUserRegistrationCancel(user)

        when:
        def result = userManagementService.cancelUserRegisteration(request)

        then:
        result instanceof CompleteUserRegistrationCancel
        result.user == user
        result.success

        where:
        user = new User(new Account("scott"), new Password("tiger"))
    }
}
