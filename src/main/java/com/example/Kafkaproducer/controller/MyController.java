package com.example.Kafkaproducer.controller;

import com.example.Kafkaproducer.service.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    int n = 0;

    @Autowired
    TopicProducer topicProducer;

    @GetMapping(value = "/produce")
    public String send(){
        int i = 0;
        while(i<20){
            topicProducer.send("message number : " + n);
            i++;
            n++;
        }

        int start = n - 20;
        int end = n-1;
        return "20 message sent to topic from : " + start + " to : " + end  ;
    }

}