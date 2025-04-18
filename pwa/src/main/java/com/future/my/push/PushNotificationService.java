package com.future.my.push;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import nl.martijndwars.webpush.Notification;
import nl.martijndwars.webpush.PushService;
import nl.martijndwars.webpush.Subscription;

@Service
public class PushNotificationService {

    @Value("${vapid.publicKey}")
    private String publicKey;
    

    @Value("${vapid.privateKey}")
    private String privateKey;

    @Value("${vapid.subject}")
    private String subject;

    public PushNotificationService() {
        if (Security.getProvider("BC") == null) {
            // web push protocol 메세지를 암호화 복호화
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    // 구독자에게 메세지 전송
    public void sendPush(Subscription sub, String title, String body) {
        PushService pushService = new PushService();
        try {
            pushService.setPublicKey(publicKey);
            pushService.setPrivateKey(privateKey);
            pushService.setSubject(subject);

            String message = String.format("{\"title\":\"%s\",\"body\":\"%s\"}", title, body);
            Notification notification = new Notification(sub, message);
            pushService.send(notification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
