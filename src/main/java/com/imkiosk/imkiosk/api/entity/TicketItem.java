package com.imkiosk.imkiosk.api.entity;

import lombok.Getter;

@Getter
public enum TicketItem {
    DEPT(1, "창구"),
    NUMBER(2, "대기번호"),
    WTIME(3, "예상 대기시간"),
    PERSON(4, "대기인수"),
    STIME(5, "발급시간"),
    CONTENT(6, "삽입문구");

    private final int code;
    private final String description;

    TicketItem(int code, String description) {
        this.code = code;
        this.description = description;
    }



    public static TicketItem fromCode(int code) {
        for (TicketItem item : TicketItem.values()) {
            if (item.getCode() == code) {
                return item;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
