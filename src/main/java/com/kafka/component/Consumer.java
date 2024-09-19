package com.kafka.component;

import com.kafka.service.AgeService;
import com.kafka.service.KafkaService;
import com.kafka.service.impl.KafkaServiceImpl;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
  private static final Logger log = LoggerFactory.getLogger(Consumer.class);

  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate;
  @Autowired
  private AgeService ageService;
  @Autowired
  private KafkaService kafkaService;

  @KafkaListener(topics = "test-topic", group = "test-group")
  public void consumer(ConsumerRecords<String,String> records, Acknowledgment ack)
      throws Exception {
    for (ConsumerRecord<String,String> record : records){
      String value = record.value();
      JSONObject jsonObject = new JSONObject(value);
      String birthdayStr = jsonObject.getString("birthday");
      int age = ageService.getAgeByBirthday(birthdayStr);
      if( age%2 == 0){
        kafkaService.producer("CustomerEVEN", value);
      }else{
        kafkaService.producer("CustomerODD", value);
      }
      log.info("Received message: key = %s, value = %s, partition = %d%n", record.key(), record.value(), record.partition());
    }
    ack.acknowledge();
  }
}
