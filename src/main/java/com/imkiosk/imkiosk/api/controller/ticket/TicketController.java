package com.imkiosk.imkiosk.api.controller.ticket;


import com.imkiosk.imkiosk.api.dto.ticket.TicketRequestDto;
import com.imkiosk.imkiosk.api.dto.ticket.TicketResponseDto;
import com.imkiosk.imkiosk.api.service.ticket.TicketServiceImpl;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    TicketServiceImpl ticketServiceImpl;

    @GetMapping("/ticket")
    public BaseResponse<TicketResponseDto> getTicketItems(
            @RequestParam(name = "deptId") Long deptId,
            @RequestParam(name = "wdId") Long wdId)    {
        return new BaseResponse<>(ticketServiceImpl.getTicketItems(deptId,wdId));
    }

    @PutMapping("/ticket")
    public BaseResponse<Void> updateTickets(@RequestBody TicketRequestDto ticketRequestDto) {
        ticketServiceImpl.updateTickets(ticketRequestDto);
        return new BaseResponse<>();
    }

}
