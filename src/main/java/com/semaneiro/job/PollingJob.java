package com.semaneiro.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.semaneiro.service.RaceDataFetchingService;

@Component
public class PollingJob {

	private static final Logger log = LoggerFactory.getLogger(PollingJob.class);

	@Autowired
	private RaceDataFetchingService service;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy.MM. dd");

	@Scheduled(fixedDelay = 3000)
	public void fetchRaceData() throws Exception {

		log.info("Last fetched event: " + dateFormat.format(new Date()));
		
		service.fetchDataService();

	}

}
