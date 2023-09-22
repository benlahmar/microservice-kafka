package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@Component
public class ListnerKafka {

	@Autowired
	KafkaTemplate<String, String> producer;
	
    private static final Logger LOG = LoggerFactory.getLogger(ListnerKafka.class);

    @KafkaListener(topics = "rma-events",groupId = "group-2")
    //@SendTo("rma1")
    public String  listenerrma(String data) {
      LOG.info(data);
      return "from sentdo";
    }
}
