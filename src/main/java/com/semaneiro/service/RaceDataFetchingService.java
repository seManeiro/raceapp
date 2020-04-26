package com.semaneiro.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.semaneiro.dal.RaceStatsRepository;
import com.semaneiro.dal.model.EventRaceData;
import com.semaneiro.service.model.EventsResponse;

public class RaceDataFetchingService {

	private static final Logger log = LoggerFactory.getLogger(RaceDataFetchingService.class);

	private RestTemplate restTemplate;
	private RaceStatsRepository raceStatsRepo;

	private String url;

	public RaceDataFetchingService(RaceStatsRepository raceStatsRepo, final String url, RestTemplate restTemplate) {
		this.url = url;
		this.restTemplate = restTemplate;
		this.raceStatsRepo = raceStatsRepo;
	}

	public void fetchDataService() throws Exception {

		ResponseEntity<EventsResponse> response;

		try {

			response = restTemplate.exchange(url, HttpMethod.GET, null, EventsResponse.class);

			if (response.getStatusCode().equals(HttpStatus.OK)) {

				EventsResponse responseData = response.getBody();

				raceStatsRepo.saveEventRace(parseInputData(responseData));

				log.info("ResponseData was saved to DB:" + responseData);

			} else if (response.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
				log.info("The request returned a response code 204 :" + response.getStatusCode().name());
			}

		} catch (Exception e) {
			log.error("Something when wrong: " + e.getStackTrace());
			throw e;
		}

	}

	private EventRaceData parseInputData(EventsResponse responseData) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");

		return new EventRaceData(dateFormat.format(new Date()), responseData.getEvent(), responseData.getHorse(),
				responseData.getTime());

	}

}
