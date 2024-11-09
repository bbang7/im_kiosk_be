package com.imkiosk.imkiosk.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branch")
@Setter
@Getter
@NoArgsConstructor
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "dept_name", nullable = false, length = 20, unique = true)
    private String deptName;

    @Column(name = "stime")
    private String stime;

    @Column(name = "etime")
    private String etime;

    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;

    @OneToMany(mappedBy = "branch")
    private List<Kiosk> kiosks;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Counter> counters;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KioskLayout> kioskLayouts;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CounterMap> counterMaps;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommonButton> commonButtons;

    @PostPersist
    private void createDefaultCounterMap() {
        CounterMap counterMap = new CounterMap();
        counterMap.setBranch(this);
        counterMap.setLayer((byte) 1);
        counterMap.setWidth((byte) 9);
        counterMap.setHeight((byte) 6);

        if (this.counterMaps == null) {
            this.counterMaps = new ArrayList<>();
        }
        this.counterMaps.add(counterMap);
    }

}