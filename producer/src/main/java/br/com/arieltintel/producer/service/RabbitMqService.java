package br.com.arieltintel.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensagem(String routingKey, Object mensagem){
            rabbitTemplate.convertAndSend(routingKey, mensagem);
    }

}
