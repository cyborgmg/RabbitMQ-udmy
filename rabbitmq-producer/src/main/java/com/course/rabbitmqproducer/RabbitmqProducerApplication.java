package com.course.rabbitmqproducer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.course.rabbitmqproducer.entity.EventDTO;
import com.course.rabbitmqproducer.producer.EventDtoProducer;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProducerApplication implements CommandLineRunner {
	
	@Autowired
	private EventDtoProducer eventDtoProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
			EventDTO event = new EventDTO(); 
			
			event.setId(1L);
			event.setEventDate(new Date());
			event.setUserId(1L);
			event.setCorporationId(1L);
			event.setProducer("producer");
			event.setRoutingKey("documents.shipment");
			event.setEntityId(1L);
			event.setEntityType("EntityType");
			event.setEntityVersion("1.0");
			event.setAction("create");
			event.setPayload("");
		
			eventDtoProducer.sendMessage(event);
			
			
			System.exit(0);
	}

}

