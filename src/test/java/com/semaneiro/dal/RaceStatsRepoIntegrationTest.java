package com.semaneiro.dal;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.semaneiro.dal.model.EventRaceData;
import com.semaneiro.service.model.Horse;

@SpringBootTest()
public class RaceStatsRepoIntegrationTest {

	@Autowired
	private RaceStatsRepository raceRepo;

	private static EventRaceData eventRaceData;

	private static Horse horse;

	private static String id;

	@BeforeAll
	public static void init() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy.MM.dd");
		id = dateFormat.format(new Date());
		horse = new Horse(1, "testHorse");
		eventRaceData = new EventRaceData(id, "start", horse, "12345");
	}

	@Test
	public void given_ValidInputData_Save_To_DB_and_Then_Verify_It_Is_Saved() {

		raceRepo.saveEventRace(eventRaceData);
		EventRaceData raceDataSaved = raceRepo.findRaceByID(id);

		Assertions.assertNotNull(raceDataSaved);
		Assertions.assertEquals(raceDataSaved.getHorse().getHorse(), eventRaceData.getHorse().getHorse());

		raceRepo.deleteEventRace(eventRaceData);

		raceDataSaved = raceRepo.findRaceByID(id);
		Assertions.assertNull(raceDataSaved);

	}

}
