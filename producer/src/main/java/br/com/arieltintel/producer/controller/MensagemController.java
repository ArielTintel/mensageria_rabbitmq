package br.com.arieltintel.producer.controller;

import br.com.arieltintel.producer.dto.MensagemDTO;
import br.com.arieltintel.producer.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class MensagemController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private void enviarMensagem(@RequestBody MensagemDTO mensagem){
        System.out.println(mensagem);
        rabbitMqService.enviaMensagem("MENSAGEM", mensagem);
    }
}
