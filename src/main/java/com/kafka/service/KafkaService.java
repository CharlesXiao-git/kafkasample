package com.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


public interface KafkaService {

  public void producer(String topicName,String message) throws Exception ;

}
