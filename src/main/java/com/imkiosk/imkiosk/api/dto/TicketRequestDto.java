package com.imkiosk.imkiosk.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketRequestDto {
    private Long deptId;
    private Long wdId;
    private List<TicketDto> ticketItems;
}
