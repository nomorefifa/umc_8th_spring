package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			ReviewQueryService reviewService = context.getBean(ReviewQueryService.class);

			Long storeId = 1L;
			System.out.println("=== [리뷰 목록: storeId = " + storeId + "] ===");

			reviewService.getReviewsByStoreId(storeId).forEach(review -> {
				System.out.println("평점: " + review.getScore());
				System.out.println("내용: " + review.getBody());
				System.out.println("작성일: " + review.getCreatedAt());
				System.out.println("-----------");
			});
		};
}}
