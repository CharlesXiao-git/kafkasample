package com.kafka.service.impl;

import com.kafka.service.AgeService;
import com.kafka.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

  private static final Logger log = LoggerFactory.getLogger(KafkaServiceImpl.class);

  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate;

  /**
   *
   * @param topicName
   * @param message
   * @throws Exception
   */
  public void producer(String topicName,String message)
      throws Exception {
    SendResult<String,String> sendResult = kafkaTemplate.send(topicName,0,"key",message).get();
    ProducerRecord<String,String> record = sendResult.getProducerRecord();
    RecordMetadata metadata = sendResult.getRecordMetadata();
    log.info("Sent message successfully!");
    log.info("Message key is " + record.key() + " Message value is " + record.value());
    log.info("Sent message to " + metadata.topic() + " partition: " + metadata.partition() + " with offset: " + metadata.offset());
  }

}
