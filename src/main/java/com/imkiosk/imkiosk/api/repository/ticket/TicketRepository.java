package com.imkiosk.imkiosk.api.repository.ticket;

import com.imkiosk.imkiosk.api.entity.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {


    @Query("SELECT t FROM Ticket t JOIN t.counter c WHERE c.branch.deptId = :deptId AND t.counter.wdId = :wdId")
    List<Ticket> findByWdIdAndDeptId(@Param("deptId") Long deptId, @Param("wdId") Long wdId);

}