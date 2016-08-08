package org.kajip.user.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"account"})
@ToString
public class User {
    private final Account account;
    private final Password password;
}
