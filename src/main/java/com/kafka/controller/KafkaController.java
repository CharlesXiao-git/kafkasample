package com.kafka.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

  @RequestMapping(value="/start",method = RequestMethod.GET)
  @ResponseBody
  public String start(){
    return "start kafka applcation.";
  }

}
