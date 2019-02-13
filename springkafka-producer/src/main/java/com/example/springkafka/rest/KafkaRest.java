package com.example.springkafka.rest;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springkafka.producer.Sender;

@RestController
@RequestMapping(value= "")
public class KafkaRest {
	
	@Autowired
	private Sender sender;
	
	@PostMapping(value="/publish")
	public void sendMessageToKafka(@RequestParam("message") String message) throws UnknownHostException {
		this.sender.send("kafka-topic", message);
		this.sender.send("second-kafka-topic", message);
	}
}
