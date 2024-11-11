package com.imkiosk.imkiosk.api.entity.kiosk;

import com.imkiosk.imkiosk.api.entity.branch.Branch;
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




    @Column(name = "item_name")
    private String itemName;

}