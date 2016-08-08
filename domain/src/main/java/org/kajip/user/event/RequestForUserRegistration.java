package org.kajip.user.event;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.kajip.user.domain.User;

/**
 * ユーザー登録申請
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class RequestForUserRegistration implements UserEvent {
    private final User user;
}
