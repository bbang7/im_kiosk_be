package com.imkiosk.imkiosk.api.service.ticket;


import com.imkiosk.imkiosk.api.dto.ticket.TicketRequestDto;
import com.imkiosk.imkiosk.api.dto.ticket.TicketResponseDto;

public interface TicketService {
    public TicketResponseDto getTicketItems(Long deptId, Long wdId);
    void updateTickets(TicketRequestDto ticketRequestDto);
}
