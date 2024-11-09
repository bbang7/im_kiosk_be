package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_code", nullable = false, length = 36, unique = true)
    private String memberCode;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = true)
    private Branch branch;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_dvcd", nullable = true)
    private String memberDvcd;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "rule", nullable = false)
    private RuleType rule = RuleType.NORMAL;
}
