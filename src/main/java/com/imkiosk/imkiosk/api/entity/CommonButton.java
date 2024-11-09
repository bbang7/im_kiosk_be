package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "common_button")
@Setter
@Getter
public class CommonButton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "common_item_id")
    private Byte commonItemId;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Branch branch;

//    @Enumerated(EnumType.ORDINAL) // 정수형으로 저장
//    @Column(name = "type", nullable = false)
//    private CommonButtonType type = CommonButtonType.UTIL; // 열거형으로 설정



    @Column(name = "item_name")
    private String itemName;

}