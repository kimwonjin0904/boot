package com.future.my.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// Subscription → 커스텀 클래스로 바꾸는 것이 원칙
import nl.martijndwars.webpush.Subscription;

@Component
public class PushScheduler {          //알림창뜨는거
	@Autowired
	private PushNotificationService service;

	@Autowired
	private SubscriptionRepo repo;

	@Scheduled(fixedRate = 30000) // 30초마다 실행
	public void sendPushPush() {
		System.out.println("send start");
		String title = "정기 알림";
		String body = "30초 마다 보내는 정기 메시지"; 
		for (Subscription sub : repo.getSubList()) {
			System.out.println("구독자: " + sub);
			service.sendPush(sub, title, body);
		}
	}
}
