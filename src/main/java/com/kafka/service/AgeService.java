package com.kafka.service;

import org.springframework.stereotype.Service;


public interface AgeService {

  public int getAgeByBirthday(String birthdayStr);

}
