package com.imkiosk.imkiosk.api.service;


import com.imkiosk.imkiosk.api.dto.TicketRequestDto;
import com.imkiosk.imkiosk.api.dto.TicketResponseDto;

public interface TicketService {
    public TicketResponseDto getTicketItems(Long deptId, Long wdId);
    void updateTickets(TicketRequestDto ticketRequestDto);
}
