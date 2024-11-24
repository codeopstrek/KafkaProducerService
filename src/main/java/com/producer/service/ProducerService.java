package com.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessageToCommonTopic(String message) {
		kafkaTemplate.send("common-topic", message);
	}

	public void sendMessageToEvenTopic(String message) {
		kafkaTemplate.send("even-topic", message);
	}

	public void sendMessageToOddTopic(String message) {
		kafkaTemplate.send("odd-topic", message);
	}
}