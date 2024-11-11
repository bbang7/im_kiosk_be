package com.imkiosk.imkiosk.api.entity.ticket;

import com.imkiosk.imkiosk.api.entity.counter.Counter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Setter
@Getter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @ManyToOne
    @JoinColumn(name = "wd_id", nullable = false)
    private Counter counter;

    @Column(name = "deptId")
    private Long deptId;

    @Column(name = "item_code")
    private Byte itemCode;

    @Column(name = "item_name")
    private String itemName;

    @PrePersist
    @PreUpdate
    public void setItemNameFromCode() {
        if (itemCode != null) {
            this.itemName = TicketItem.fromCode(itemCode).getDescription();
        }
    }

    @Column(name = "item_index")
    private Byte itemIndex;

    @Column(name = "content")
    private String content;

    @Column(name = "is_placed")
    private Boolean isPlaced = true;


}