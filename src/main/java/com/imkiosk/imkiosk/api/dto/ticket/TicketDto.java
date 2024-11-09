package com.imkiosk.imkiosk.api.dto.ticket;

import com.imkiosk.imkiosk.api.entity.ticket.Ticket;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Long ticketId;
    private Byte itemCode;
    private String itemName;
    private Long deptId;
    private Byte itemIndex;
    private String content;
    private Boolean isPlaced;

    public static TicketDto toDto(Ticket ticket){
        return TicketDto.builder()
                .ticketId(ticket.getTicketId())
                .itemCode(ticket.getItemCode())
                .itemName(ticket.getItemName())
                .deptId(ticket.getDeptId())
                .itemIndex(ticket.getItemIndex())
                .content(ticket.getContent())
                .isPlaced(ticket.getIsPlaced())
                .build();
    }
}
