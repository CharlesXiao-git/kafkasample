package com.kafka.service.impl;

import com.kafka.service.AgeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class AgeServiceImpl implements AgeService {

  /**
   *
   * @param birthdayStr
   */
  public int getAgeByBirthday(String birthdayStr) {
    int age = 0;
    if(!StringUtils.isEmpty(birthdayStr)){
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate birthday = LocalDate.parse(birthdayStr, formatter);
      LocalDate today = LocalDate.now();
      age = today.getYear() - birthday.getYear();
      if (today.isBefore(birthday.plusYears(age))) {
        age--;
      }
    }
    return age;
  }

}
