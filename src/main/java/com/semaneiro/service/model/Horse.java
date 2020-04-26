package com.semaneiro.service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Horse {

	private int id;

	private String horse;

	@JsonCreator
	public Horse(@JsonProperty("id") int id, @JsonProperty("horse") String horse) {

		this.id = id;
		this.horse = horse;
	}

	public int getId() {
		return id;
	}

	public String getHorse() {
		return horse;
	}

}
