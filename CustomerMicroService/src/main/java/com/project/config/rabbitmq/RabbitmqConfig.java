package com.project.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitmqConfig {
    private String customerDirectExchange = "customer-direct-exchange";
    private String customerPasswordBindingKey = "customer-password-binding-key";
    private String customerPasswordQueue = "customer-password-queue";

    @Bean
    DirectExchange customerDirectExchange(){
        return new DirectExchange(customerDirectExchange);
    }
    @Bean
    Queue customerPasswordQueue(){
        return new Queue(customerPasswordQueue);
    }
    @Bean
    public Binding registerMailBindingKey(final Queue customerPasswordQueue, final DirectExchange customerDirectExchange){
        return BindingBuilder.bind(customerPasswordQueue).to(customerDirectExchange).with(customerPasswordBindingKey);
    }
}
