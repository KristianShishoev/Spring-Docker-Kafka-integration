package com.example.springkafka.producer;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topic, String data) throws UnknownHostException {
    LOGGER.info("sending data='{}' to topic='{}'", data, topic);
    for(int i=0; i<20; i++) {
    	kafkaTemplate.send(topic, data);
    }
  }
}
