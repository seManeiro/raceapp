package com.semaneiro.service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventsResponse {

	private String event;
	private Horse horse;
	private String time;

	@JsonCreator
	public EventsResponse(@JsonProperty("event")String event, @JsonProperty("horse") Horse horse, @JsonProperty("time")String time) {

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
