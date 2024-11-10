package com.imkiosk.imkiosk.api.dto.history;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HistoryRequestDto {
    private LocalDate startDate;
    private LocalDate endDate;
}
