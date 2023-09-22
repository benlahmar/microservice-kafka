package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;



@SpringBootApplication
@EnableKafka
public class BrokenrmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrokenrmaApplication.class, args);
	}

	
	
	@Bean
	public Map<String, Object> producerConfigs3() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    // See https://kafka.apache.org/documentation/#producerconfigs for more properties
	    return props;
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
	    return new KafkaTemplate<String, String>(producerFactory3());
	}
	 @Bean
		public ProducerFactory<String, String> producerFactory3() {
		    return new DefaultKafkaProducerFactory<>(producerConfigs3());
		}
}
