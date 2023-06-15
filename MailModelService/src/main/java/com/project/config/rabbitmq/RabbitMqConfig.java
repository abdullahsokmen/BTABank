package com.project.config.rabbitmq;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMqConfig {
    private String personalPasswordQueue = "personal-password-queue";
    private String customerPasswordQueue="customer-password-queue";

    @Bean
    Queue personalPasswordQueue(){
        return new Queue(personalPasswordQueue);
    }
    @Bean
    Queue customerPasswordQueue(){
        return new Queue(customerPasswordQueue);
    }
}
