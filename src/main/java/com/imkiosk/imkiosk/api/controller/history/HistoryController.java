package com.imkiosk.imkiosk.api.controller.history;


import com.imkiosk.imkiosk.api.entity.history.History;
import com.imkiosk.imkiosk.api.service.hisotry.HistoryService;
import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @GetMapping("/history")
    public BaseResponse<List<History>> getHistoriesByDeptAndDateRange(
            @RequestParam(name = "deptId") Long deptId,
            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate) {

        LocalDateTime startDateTime = LocalDate.parse(startDate).atStartOfDay();
        LocalDateTime endDateTime = LocalDate.parse(endDate).atTime(23, 59, 59);

        List<History> histories = historyService.getHistoriesByDeptAndDateRange(deptId, startDateTime, endDateTime);

        return new BaseResponse<>(histories); // 일치하는 데이터가 없으면 빈 배열 반환
    }

}
