package com.project.rabbitmq.consumer;

import com.project.rabbitmq.model.CustomerPasswordSenderModel;
import com.project.rabbitmq.model.PersonalPasswordSenderModel;
import com.project.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerPasswordConsumer {
    private final MailSenderService mailSenderService;

    @RabbitListener(queues = "customer-password-queue")
    public void sendCustomerPassword(CustomerPasswordSenderModel model){
        mailSenderService.sendCustomerPassword(model);
    }
}
