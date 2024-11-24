package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producer.service.ProducerService;

@RestController
@RequestMapping("/api")
public class ProducerController {

	@Autowired
	ProducerService producerService;

    @GetMapping("/publish/common")
    public String sendMessageToCommonTopic(@RequestParam("message") String message) {
        producerService.sendMessageToCommonTopic(message);
        return "Message sent to common topic: "+message;
    }

    @GetMapping("/publish/number")
    public String sendMessageToOddOrEvenTopic(@RequestParam("message") String message) {
        try {
            int number = Integer.parseInt(message);
            if (number % 2 == 0) {
                producerService.sendMessageToEvenTopic(message);
                return "Message sent to even topic: "+message;
            } else {
                producerService.sendMessageToOddTopic(message);
                return "Message sent to odd topic: "+message;
            }
        } catch (NumberFormatException e) {
            return "Invalid input: please provide a valid integer";
        }
    }
}
