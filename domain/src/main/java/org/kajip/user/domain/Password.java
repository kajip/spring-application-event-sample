package org.kajip.user.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Password {
    private final String value;

    @Override
    public String toString() {
        return "****";
    }
}
