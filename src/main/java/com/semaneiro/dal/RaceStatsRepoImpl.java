package com.semaneiro.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.semaneiro.dal.model.EventRaceData;

@Repository
public class RaceStatsRepoImpl implements RaceStatsRepository {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public RaceStatsRepoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<EventRaceData> getAllEventRace() {
		return mongoTemplate.findAll(EventRaceData.class);

	}

	@Override
	public EventRaceData saveEventRace(EventRaceData raceData) {

		mongoTemplate.save(raceData);
		return raceData;

	}

	@Override
	public EventRaceData updateEventRace(EventRaceData raceData) {
		mongoTemplate.save(raceData);
		return raceData;
	}

	@Override
	public void deleteEventRace(EventRaceData raceData) {
		mongoTemplate.remove(raceData);

	}

	@Override
	public EventRaceData findRaceByID(String id) {

		return mongoTemplate.findById(id, EventRaceData.class);

	}

}
