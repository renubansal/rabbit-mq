package com.rabbitmq.basic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication implements CommandLineRunner {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Override
    public void run(String... args) {
        rabbitTemplate.convertAndSend("TestExchange", "testRouting",
				"some message from rabbit MQ");
    }
}
