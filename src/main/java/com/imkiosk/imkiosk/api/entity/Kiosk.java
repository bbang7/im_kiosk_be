package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kiosk")
@Setter
@NoArgsConstructor
public class Kiosk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kiosk_id")
    private Integer kioskId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Branch branch;

}