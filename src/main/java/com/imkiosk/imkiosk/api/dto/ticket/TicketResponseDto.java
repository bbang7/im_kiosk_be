package com.imkiosk.imkiosk.api.dto.ticket;

import com.imkiosk.imkiosk.api.entity.ticket.Ticket;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {
    private Long deptId;
    private Long wdId;
    private List<TicketDto> ticketItems;

    public static TicketResponseDto toDto(List<Ticket> ticketItems){
        if(ticketItems.isEmpty()){
            return null;
        }

        Ticket firstTicketItem = ticketItems.get(0);

        Long deptId = firstTicketItem.getCounter().getBranch() != null ?
                firstTicketItem.getCounter().getBranch().getDeptId() : null;
        Long wdId = firstTicketItem.getCounter().getWdId();

        return TicketResponseDto.builder()
                .deptId(deptId)
                .wdId(wdId)
                .ticketItems(ticketItems.stream()
                        .map(TicketDto::toDto)
                        .collect(Collectors.toList()))
                .build();
    }

}
