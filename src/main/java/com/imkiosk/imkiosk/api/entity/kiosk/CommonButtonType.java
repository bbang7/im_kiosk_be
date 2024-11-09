package com.imkiosk.imkiosk.api.entity.kiosk;

import lombok.Getter;

@Getter
public enum CommonButtonType {
    ESSENTIAL(0, "필수"),
    UTIL(1, "편의");

    private final int code;
    private final String description;

    CommonButtonType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static CommonButtonType fromCode(int code) {
        for (CommonButtonType type : CommonButtonType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}