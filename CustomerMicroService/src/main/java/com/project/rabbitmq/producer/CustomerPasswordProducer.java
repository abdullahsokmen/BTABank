package com.project.rabbitmq.producer;

import com.project.rabbitmq.model.CustomerPasswordSenderModel;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerPasswordProducer {
    private final RabbitTemplate rabbitTemplate;
    private String customerDirectExchange = "customer-direct-exchange";
    private String customerPasswordBindingKey = "customer-password-binding-key";

    public void sendCustomerPassword(CustomerPasswordSenderModel model){
        rabbitTemplate.convertAndSend(customerDirectExchange,customerPasswordBindingKey,model);
    }
}
