//package com.imkiosk.imkiosk.common.loader;
//
//import com.imkiosk.imkiosk.api.entity.history.History;
//import com.imkiosk.imkiosk.api.repository.history.HistoryRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.ZoneOffset;
//import java.time.temporal.ChronoUnit;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;
//
//@Component
//public class HistoryDataLoader implements CommandLineRunner {
//
//    private final HistoryRepository historyRepository;
//
//    public HistoryDataLoader(HistoryRepository historyRepository) {
//        this.historyRepository = historyRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//        Random random = new Random();
//
//        // memberCode와 memberName 매핑 설정
//        Map<String, String> memberMap = new HashMap<>();
//        memberMap.put("IM001", "김감자");
//        memberMap.put("IM002", "김가지");
//        memberMap.put("IM003", "김고구마");
//        memberMap.put("IM004", "김김치");
//
//        List<String> wdNames = List.of("일반금융", "대출", "기타업무", "외환업무");
//
//        for (int i = 0; i < 10000; i++) {
//            // memberCode와 memberName 매핑에서 임의로 선택
//            String memberCode = memberMap.keySet().stream().toList().get(random.nextInt(memberMap.size()));
//            String memberName = memberMap.get(memberCode);
//
//            Byte wdId = (byte) (random.nextInt(4) + 1);
//            String wdName = wdNames.get(wdId - 1);
//            boolean csnlState = random.nextBoolean();
//
//            LocalDateTime currentDateTime = generateRandomDateTime(LocalDate.now().minusYears(10), LocalDate.now());
//
//            // 09:00 ~ 16:00 사이의 ticketStime 생성
//            LocalDateTime ticketStime = generateRandomTimeInRange(currentDateTime, LocalTime.of(9, 0), LocalTime.of(16, 0));
//
//            // 상담 시작 시간과 종료 시간 범위 설정
//            LocalDateTime csnlStartDateTime = csnlState ? ticketStime.plusMinutes(random.nextInt(60)) : null;
//            LocalDateTime csnlEndDateTime = (csnlStartDateTime != null) ? csnlStartDateTime.plusMinutes(random.nextInt(60)) : null;
//
//            // 상담 시간 및 대기 시간 계산 (최대 60분 이내로 보장)
//            Integer csnlTime = (csnlEndDateTime != null && csnlStartDateTime != null) ?
//                    (int) ChronoUnit.MINUTES.between(csnlStartDateTime, csnlEndDateTime) : null;
//            Integer waitTime = (csnlStartDateTime != null) ?
//                    (int) ChronoUnit.MINUTES.between(ticketStime, csnlStartDateTime) : null;
//
//            History history = new History();
//            history.setDeptId(1L);
//            history.setDeptName("대구");
//            history.setMemberCode(memberCode);
//            history.setMemberName(memberName);
//            history.setWdId(wdId);
//            history.setWdName(wdName);
//            history.setCurrentDateTime(currentDateTime);
//            history.setTicketNumber(random.nextInt(1000) + 1);
//            history.setTicketStime(ticketStime);
//            history.setCsnlState(csnlState);
//            history.setCsnlStartDateTime(csnlStartDateTime);
//            history.setCsnlEndDateTime(csnlEndDateTime);
//            history.setCsnlTime(csnlTime);
//            history.setWaitTime(waitTime);
//            history.setIsAlone(random.nextBoolean());
//            history.setCustomerAge(random.nextInt(6));
//
//            historyRepository.save(history);
//        }
//    }
//
//    // 주어진 날짜의 09:00 ~ 16:00 사이 임의의 LocalDateTime 생성
//    private LocalDateTime generateRandomTimeInRange(LocalDateTime baseDate, LocalTime startTime, LocalTime endTime) {
//        long start = baseDate.with(startTime).toEpochSecond(ZoneOffset.UTC);
//        long end = baseDate.with(endTime).toEpochSecond(ZoneOffset.UTC);
//        long randomEpochSecond = ThreadLocalRandom.current().nextLong(start, end);
//        return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, ZoneOffset.UTC);
//    }
//
//    // 주어진 범위 내에서 임의의 LocalDateTime 생성
//    private LocalDateTime generateRandomDateTime(LocalDate startDate, LocalDate endDate) {
//        long start = startDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
//        long end = endDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
//        long randomEpochSecond = ThreadLocalRandom.current().nextLong(start, end);
//        return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, ZoneOffset.UTC);
//    }
//}
