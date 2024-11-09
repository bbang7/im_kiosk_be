package com.imkiosk.imkiosk.api.entity.employee;

import lombok.Getter;

@Getter
public enum RuleType {
    NORMAL(0, "일반"),
    BRANCH(1, "영업점"),
    CENTRAL(2, "본부");

    private final int code;
    private final String displayName;

    RuleType(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public static RuleType fromCode(int code) {
        for (RuleType rule : RuleType.values()) {
            if (rule.getCode() == code) {
                return rule;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}