package stackjava.com.springbootkafka.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StartupListener implements ApplicationRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("communication.send-email", msg);
    }

    @KafkaListener(topics = "communication.send-email", groupId = "communication.send-email-consumer-group")
    public void listen(String message) {
        System.out.println("Received Message in topic Test : " + message);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
