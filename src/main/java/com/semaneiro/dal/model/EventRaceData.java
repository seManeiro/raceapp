package com.semaneiro.dal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.semaneiro.service.model.Horse;

@Document(collection = "eventdata")
public class EventRaceData {
	
	

	@Id
	private String id;
	
	private String event;
	
	private Horse horse;
	
	private String time;

	
	public EventRaceData(String id, String event, Horse horse, String time) {

		this.id = id;
		this.event = event;
		this.horse = horse;
		this.time = time;
	}

	public String getEvent() {
		return event;
	}

	public Horse getHorse() {
		return horse;
	}

	public String getTime() {
		return time;
	}
	

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}


}
