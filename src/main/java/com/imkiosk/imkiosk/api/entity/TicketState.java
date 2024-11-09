package com.imkiosk.imkiosk.api.entity;

import lombok.Getter;

@Getter
public enum TicketState {
    WAIT(0, "대기"),
    ONGOING(1, "상담중"),
    END(2, "상담종료"),
    CANCEL(3, "취소종료");

    private final int code;
    private final String description;

    TicketState(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TicketState fromCode(int code) {
        for (TicketState status : TicketState.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}