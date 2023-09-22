package com.example.demo;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

	@Autowired
	KafkaTemplate<String, String> producer;
	
	@GetMapping("test/{topic}/{s}")
	public String prod(@PathVariable String topic,@PathVariable String s)
	{
		 producer.send(topic, s);
		return "ok";
	}
}
