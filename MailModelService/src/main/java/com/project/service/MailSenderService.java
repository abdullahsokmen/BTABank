package com.project.service;


import com.project.rabbitmq.model.PersonalPasswordSenderModel;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailSenderService {

    private final JavaMailSender javaMailSender;

    public void sendPersonalPassword(PersonalPasswordSenderModel model){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${mailUsername}");
        mailMessage.setTo(model.getEmail());
        mailMessage.setSubject("Password");
        mailMessage.setText("Your password : "+model.getPassword());
        javaMailSender.send(mailMessage);
    }

}
