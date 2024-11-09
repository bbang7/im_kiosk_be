//package com.imkiosk.imkiosk.common.loader;//package com.kiosk.kiosk.common.loader;
//
//
//import com.imkiosk.imkiosk.api.entity.history.History;
//import com.imkiosk.imkiosk.api.repository.history.HistoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//@Component
//public class DataLoader implements CommandLineRunner {
//
//    @Autowired
//    private HistoryRepository historyRepository;
//
//    @Override
//    public void run(String... args) {
//        List<String> memberNames = Arrays.asList("홍길동", "김철수", "박영희", "이수진", "최민준");
//        List<String> memberCodes = Arrays.asList("M123", "M124", "M125", "M126", "M127");
//        List<Byte> wdIds = Arrays.asList((byte) 1, (byte) 2, (byte) 3, (byte) 4);
//        List<String> wdNames = Arrays.asList("일반", "대출", "공과금", "기타");
//
//        Random random = new Random();
//
//        for (int i = 0; i < 500; i++) {
//            History history = new History();
//            history.setDeptId(1L);
//            history.setDeptName("대구");
//
//            // 회원 코드 및 이름
//            history.setMemberCode(memberCodes.get(random.nextInt(memberCodes.size())));
//            history.setMemberName(memberNames.get(random.nextInt(memberNames.size())));
//
//            // wdId와 wdName
//            int wdIndex = random.nextInt(wdIds.size());
//            history.setWdId(wdIds.get(wdIndex));
//            history.setWdName(wdNames.get(wdIndex));
//
//            // 7일 범위 내에서 랜덤한 날짜로 currentDate 설정
//            LocalDate randomDate = LocalDate.now().minusDays(random.nextInt(7));
//            history.setCurrentDateTime(randomDate.atStartOfDay());  // 날짜만 필요하면 시간은 00:00:00으로 설정
//
//            // 티켓 번호, 티켓 발급 시간
//            history.setTicketNumber(i + 1);
//            history.setTicketStime(LocalDateTime.now().minusMinutes(random.nextInt(60)));
//
//            // 상담 상태, 상담 시작/종료 시간
//            history.setCsnlState(random.nextBoolean());
//            if (history.getCsnlState()) {
//                history.setCsnlStartDateTime(LocalDateTime.now().minusMinutes(random.nextInt(30)));
//                history.setCsnlEndDateTime(history.getCsnlStartDateTime().plusMinutes(random.nextInt(30)));
//                history.setCsnlTime((int) java.time.Duration.between(history.getCsnlStartDateTime(), history.getCsnlEndDateTime()).toMinutes());
//                history.setWaitTime((int) java.time.Duration.between(history.getTicketStime(), history.getCsnlStartDateTime()).toMinutes());
//            }
//
//            // 혼자 여부, 고객 연령대
//            history.setIsAlone(random.nextBoolean());
//            history.setCustomerAge(random.nextInt(6)); // 0~5 사이의 값으로 연령대 설정
//
//            // 더미 데이터 저장
//            historyRepository.save(history);
//        }
//
//        System.out.println("200개의 더미 데이터가 성공적으로 저장되었습니다.");
//    }
//}