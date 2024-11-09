package com.imkiosk.imkiosk;

import com.imkiosk.imkiosk.common.entity.BaseResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ImkioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImkioskApplication.class, args);

	}
	@RestController
	static class HealthCheckController {

		@GetMapping("/")
		public BaseResponse<Void> healthCheck() {
			return new BaseResponse<>();
		}
	}
}
