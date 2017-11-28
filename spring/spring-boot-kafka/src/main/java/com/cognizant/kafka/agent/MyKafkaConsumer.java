package com.cognizant.kafka.agent;

import java.util.concurrent.CountDownLatch;

import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.cognizant.kafka.config.Greeting;

public class MyKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = "${kakfa.topic.json}")
	public void receive(Greeting car) {
		LOGGER.info("received car='{}'", car.toString());
		latch.countDown();
	}
}
