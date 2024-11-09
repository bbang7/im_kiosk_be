package com.imkiosk.imkiosk.api.entity.counter;

import com.imkiosk.imkiosk.api.entity.ticket.Ticket;
import com.imkiosk.imkiosk.api.entity.branch.Branch;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "counter")
@Setter
@Getter
@NoArgsConstructor
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wd_id")
    private Long wdId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Branch branch;

    @Column(name="wd_name", nullable = false)
    private String wdName;

    @Column(name = "wd_count")
    private Integer wdCount=0;

    @Column(name = "color", length = 10)
    private String color="#00C7A9";

    @OneToMany(mappedBy = "counter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    @PostPersist
    public void createTickets() {
        for (int i = 1; i <= 6; i++) {
            Ticket ticket = new Ticket();
            ticket.setItemCode((byte) i);
            ticket.setItemIndex((byte) i);
            ticket.setCounter(this);
            ticket.setDeptId(branch.getDeptId());
            ticket.setContent("");
            tickets.add(ticket);
        }
    }

}