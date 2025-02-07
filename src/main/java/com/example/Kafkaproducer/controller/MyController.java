package com.example.Kafkaproducer.controller;

import com.example.Kafkaproducer.service.TopicProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    int n = 0;

    @Autowired
    TopicProducer topicProducer;

    @GetMapping(value = "/produce")
    public String send() throws InterruptedException {
        int i = 0;
        while(i<20){
            topicProducer.send("message number : " + n, n);
//            Thread.sleep(1000);
            log.info("message number : " + n + " sent to topic");
            i++;
            n++;
        }

        int start = n - 200;
        int end = n-1;
        return "20 message sent to topic from : " + start + " to : " + end  ;
    }

}