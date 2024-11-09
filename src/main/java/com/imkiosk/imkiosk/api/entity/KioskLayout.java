package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "kiosk_layout")
@Setter
@Getter
@NoArgsConstructor
public class KioskLayout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kiosk_layout_id")
    private Long kioskLayoutId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Branch branch;

    @Column(name = "button_index")
    private Byte buttonIndex;

    @Column(name = "is_common")
    private Boolean isCommon;

    @Column(name = "common_item_id")
    private Byte commonItemId;

    @Column(name = "wd_id")
    private Byte wdId;

    @Column(name = "name")
    private String name;

    @Column(name = "is_placed" ,nullable = false)
    private Boolean isPlaced = false;


}