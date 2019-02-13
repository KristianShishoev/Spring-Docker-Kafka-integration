package com.example.springkafka.consumer;

import java.net.UnknownHostException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  @KafkaListener(topics = "kafka-topic", groupId = "boot")
  public void receive(ConsumerRecord<?, ?> consumerRecord) throws UnknownHostException {
    LOGGER.info("received data='{}'", consumerRecord.toString());
  }
  
  @KafkaListener(topics = "second-kafka-topic", groupId = "boot")
  public void receiveSecond(ConsumerRecord<?, ?> consumerRecord) throws UnknownHostException {
    LOGGER.info("received data='{}'", consumerRecord.toString());
  }
}
