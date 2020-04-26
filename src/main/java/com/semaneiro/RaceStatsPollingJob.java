package com.semaneiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class RaceStatsPollingJob {

	public static void main(String[] args) {
		SpringApplication.run(RaceStatsPollingJob.class, args);
	}

}
