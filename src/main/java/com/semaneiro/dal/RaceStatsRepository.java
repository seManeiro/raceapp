package com.semaneiro.dal;

import java.util.List;

import com.semaneiro.dal.model.EventRaceData;


public interface RaceStatsRepository {
	

	EventRaceData saveEventRace(EventRaceData eventRaceData);

	EventRaceData updateEventRace(EventRaceData eventRaceData);

	void deleteEventRace(EventRaceData eventRaceData);

	List<EventRaceData> getAllEventRace();

	EventRaceData findRaceByID(String id);

	

}
