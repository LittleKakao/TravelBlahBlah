package com.littlekakao.travelblahblah.journey.service;

import com.littlekakao.travelblahblah.journey.domain.Journey;

import java.util.List;
import java.util.Map;

public interface JourneyService {
    public List<Journey> findJourneyAll(int userId);
    public Journey findJourneyByJourneyId(int journeyId);
    public void addJourney(Journey journey);
    public void modifyJourneyByJourneyId(Map<String, Object> paramMap);
    public void removeJourneyByJourneyId(Map<String, Object> paramMap);
}
