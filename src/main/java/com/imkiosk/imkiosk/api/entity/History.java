package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long historyId;

    @Column(name = "dept_id", nullable = false)
    private Long deptId; // 부서 ID

    @Column(name = "dept_name", length = 20)
    private String deptName; // 부서 이름

    @Column(name = "member_code", length = 20)
    private String memberCode; // 회원 코드

    @Column(name = "member_name", length = 10)
    private String memberName; // 회원 이름

    @Column(name = "wd_id")
    private Byte wdId;

    @Column(name = "wd_name", length = 20)
    private String wdName;

    @Column(name = "current_date_time") // 현재 날짜 (연,월,일)
    private LocalDateTime currentDateTime;

    @Column(name = "ticket_number") // 티켓 번호
    private Integer ticketNumber;

    @Column(name = "ticket_stime") // 티켓 발급 시간
    private LocalDateTime ticketStime;

    @Column(name = "csnl_state") // 상담 상태 (false: 상담 X, true: 상담 O)
    private Boolean csnlState;

    @Column(name = "csnl_start_date_time") // 상담 시작 시간
    private LocalDateTime csnlStartDateTime;

    @Column(name = "csnl_end_date_time") // 상담 종료 시간
    private LocalDateTime csnlEndDateTime;

    @Column(name = "csnl_time") // 상담 시간 = 상담 종료 시간 - 상담 시작 시간
    private Integer csnlTime;

    @Column(name = "wait_time") // 대기 시간 = 상담 시작 시간 - 티켓 발급 시간
    private Integer waitTime;

    @Column(name = "is_alone") // 혼자 여부
    private Boolean isAlone;

    @Column(name = "customer_age") // 고객 연령대
    private Integer customerAge; // 고객 나이 (0:10,1:20,2:30,3:40,4:50,5:60)

}
