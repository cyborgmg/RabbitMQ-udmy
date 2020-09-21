package com.course.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmqproducer.entity.EventDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class EventDtoProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(EventDTO eventDto) throws JsonProcessingException {
		
		
		
		rabbitTemplate.convertAndSend("sales_data_exchange", "customer.order", eventDto);
		
		/*
		rabbitTemplate.convertAndSend("kestraa.exchange", "documents.shipment", eventDto, header -> {
            header.getMessageProperties().getHeaders().put("__TypeId__", "com.kestraa.apiproducer.dto.EventDTO");
            header.getMessageProperties().getHeaders().put("content_type", "application/json");
            header.getMessageProperties().getHeaders().put("content_encoding", "UTF-8");
            return header;
        });
		*/
	}
	
}
