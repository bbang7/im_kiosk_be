package com.imkiosk.imkiosk.api.service.ticket;


import com.imkiosk.imkiosk.api.dto.ticket.TicketDto;
import com.imkiosk.imkiosk.api.dto.ticket.TicketRequestDto;
import com.imkiosk.imkiosk.api.dto.ticket.TicketResponseDto;
import com.imkiosk.imkiosk.api.entity.ticket.Ticket;
import com.imkiosk.imkiosk.api.repository.ticket.TicketRepository;
import com.imkiosk.imkiosk.common.entity.BaseResponseStatus;
import com.imkiosk.imkiosk.common.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    @Transactional
    public TicketResponseDto getTicketItems(Long deptId, Long wdId) {
        List<Ticket> ticketItems = ticketRepository.findByWdIdAndDeptId(deptId, wdId);
        TicketResponseDto responseDto = TicketResponseDto.toDto(ticketItems);

        if (responseDto == null) {
            throw new BaseException(BaseResponseStatus.NOT_EXIST_CONTENT);
        }

        return responseDto;
    }

    @Override
    @Transactional
    public void updateTickets(TicketRequestDto ticketRequestDto) {
        List<TicketDto> ticketItems = ticketRequestDto.getTicketItems();
        for (TicketDto ticketDto : ticketItems) {
            Ticket ticket = ticketRepository.findById(ticketDto.getTicketId())
                    .orElseThrow(() -> new RuntimeException("Ticket not found: " + ticketDto.getTicketId())); // 예외 처리

            ticket.setContent(ticketDto.getContent());
            ticket.setItemIndex(ticketDto.getItemIndex());
            ticket.setIsPlaced(ticketDto.getIsPlaced());

            ticketRepository.save(ticket);
        }
    }
}
