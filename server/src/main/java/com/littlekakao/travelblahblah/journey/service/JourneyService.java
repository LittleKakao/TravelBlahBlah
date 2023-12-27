package com.littlekakao.travelblahblah.journey.service;

import com.littlekakao.travelblahblah.journey.domain.Journey;

import java.util.List;
import java.util.Map;

public interface JourneyService {
    public List<Journey> findJourneyAll();
    public Journey findJourneyByJourneyId(int journeyId);
    public int addJourney(Journey journey);
    public int modifyJourneyByJourneyId(Map<String, Object> paramMap);
    public int removeJourneyByJourneyId(int journeyId);
}
