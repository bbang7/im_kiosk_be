package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "counter_map")
@Setter
@Getter
@NoArgsConstructor
public class CounterMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wd_map_id")
    private Long wdMapId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Branch branch;

    @Column(name = "layer")
    private Byte layer;

    @Column(name = "width")
    private Byte width;

    @Column(name = "height")
    private Byte height;

    @OneToMany(mappedBy = "counterMap", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CounterMapItem> counterMapItems= new ArrayList<>();

}