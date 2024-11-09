package com.imkiosk.imkiosk.api.entity.history;

import lombok.Getter;

@Getter
public enum CustomerAge {
    AGE_10(10),
    AGE_20(20),
    AGE_30(30),
    AGE_40(40),
    AGE_50(50),
    AGE_60(60);

    private final int value;

    CustomerAge(int value) {
        this.value = value;
    }

    public static CustomerAge fromValue(int value) {
        for (CustomerAge age : CustomerAge.values()) {
            if (age.value == value) {
                return age;
            }
        }
        throw new IllegalArgumentException("No enum constant for value " + value);
    }
}