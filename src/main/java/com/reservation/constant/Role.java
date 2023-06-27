package com.reservation.constant;

import lombok.Getter;

@Getter
public enum Role {
    USER("ROLE_USER"), OWNER("ROLE_OWNER"), ADMIN("ROLE_ADMIN");

    Role(String value) {
        this.value = value;
    }

    private String value;
}
