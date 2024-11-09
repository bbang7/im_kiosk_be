package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "counter_map_item")
@Setter
@Getter
@NoArgsConstructor
public class CounterMapItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wd_map_item_id")
    private Long wdMapItemId;

    @ManyToOne
    @JoinColumn(name = "wd_map_id", nullable = false)
    private CounterMap counterMap;

    @Column(name = "wd_id")
    private Long wdId;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "color", length = 10)
    private String color;

    @Column(name = "x")
    private Byte x;

    @Column(name = "y")
    private Byte y;
}
