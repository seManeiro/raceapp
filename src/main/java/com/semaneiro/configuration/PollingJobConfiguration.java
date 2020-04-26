package com.semaneiro.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.semaneiro.dal.RaceStatsRepository;
import com.semaneiro.service.RaceDataFetchingService;

@Configuration
public class PollingJobConfiguration {

	@Autowired
	private HttpClientConfig httpClientConfiguration;

	@Autowired
	private RaceStatsRepository raceStatsRepo;

	@Value("${race.event.url}")
	private String url;

	@Bean
	public RaceDataFetchingService getRaceDataService() throws Exception {

		return new RaceDataFetchingService(raceStatsRepo, url,
				new RestTemplate(httpClientConfiguration.createClientHttpRequestFactory()));
	}

}
