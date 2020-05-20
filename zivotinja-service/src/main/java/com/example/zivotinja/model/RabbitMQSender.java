package com.example.zivotinja.RabbitMQ;

import com.example.zivotinja.RabbitMQ.ConfigurationRabbitMQ;
import com.example.zivotinja.model.Vakcina;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

   /* @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Vakcina vakcina) {
        rabbitTemplate.convertAndSend(ConfigurationRabbitMQ.EXCHANGE_NAME, ConfigurationRabbitMQ.ROUTING_KEY, vakcina);
        System.out.println("Tip vakcine: " + vakcina.getTip() + ", revakcinacija: " + vakcina.getRevakcinacija());
    }*/
}
