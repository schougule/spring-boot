package com.cognizant.kafka.agent;

import org.apache.kafka.clients.producer.internals.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.cognizant.kafka.config.Greeting;

public class MyKafkaSender {
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Value("${kafka.topic.json}")
	private String jsonTopic;

	@Autowired
	private KafkaTemplate<String, Greeting> kafkaTemplate;

	public void send(Greeting car) {
		LOGGER.info("sending car='{}'", car.toString());
		kafkaTemplate.send(jsonTopic, car);
	}
}
