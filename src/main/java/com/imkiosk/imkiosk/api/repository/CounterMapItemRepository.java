package com.imkiosk.imkiosk.api.repository;

import com.imkiosk.imkiosk.api.entity.CounterMapItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterMapItemRepository extends JpaRepository<CounterMapItem, Long> {
    List<CounterMapItem> findByCounterMapWdMapId(Long wdMapId);
}
