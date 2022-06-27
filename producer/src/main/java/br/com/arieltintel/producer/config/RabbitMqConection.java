package br.com.arieltintel.producer.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMqConection {

    private AmqpAdmin amqpAdmin;

    public RabbitMqConection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila) {
        return new Queue(nomeFila, true, false, false);
    }

    private DirectExchange directExchange(String exchange) {
        return new DirectExchange(exchange);
    }

    private Binding relacionamento(Queue fila, DirectExchange exchange) {
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, exchange.getName(), fila.getName(), null );
    }

    @PostConstruct
    public void envia() {
        Queue filaMensagem = fila("MENSAGEM");
        DirectExchange directExchange = directExchange("amq.direct");
        Binding bindingMensagem = relacionamento(filaMensagem, directExchange);

        amqpAdmin.declareQueue(filaMensagem);
        amqpAdmin.declareExchange(directExchange);
        amqpAdmin.declareBinding(bindingMensagem);
    }

}
