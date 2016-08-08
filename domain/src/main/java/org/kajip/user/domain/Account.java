package org.kajip.user.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Account {
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
