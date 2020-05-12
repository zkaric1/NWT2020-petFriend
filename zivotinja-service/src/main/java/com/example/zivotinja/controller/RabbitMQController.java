package com.example.zivotinja.controller;

import com.example.zivotinja.model.Vakcina;
import com.example.zivotinja.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @PostMapping("/send")
    public String sendMessage(@RequestBody Vakcina vakcina){
        rabbitMQSender.send(vakcina);
        return "Tip vakcine: " + vakcina.getTip() + ", revakcinacija: " + vakcina.getRevakcinacija();
    }
}
