package com.littlekakao.travelblahblah.journey.service;

import com.littlekakao.travelblahblah.journey.domain.Journey;
import com.littlekakao.travelblahblah.journey.mapper.JourneyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JourneyServiceImpl implements JourneyService{

    private final JourneyMapper journeyMapper;


    public JourneyServiceImpl(JourneyMapper journeyMapper) {
        this.journeyMapper = journeyMapper;
    }


    @Override
    public List<Journey> findJourneyAll() {
        return journeyMapper.findJourneyAll();
    }

    @Override
    public Journey findJourneyByJourneyId(int journeyId) {
        return journeyMapper.findJourneyByJourneyId(journeyId);
    }

    @Override
    public void addJourney(Journey journey) {
        journeyMapper.addJourney(journey);
    }

    @Override
    public void modifyJourneyByJourneyId(Map<String, Object> paramMap) {
        journeyMapper.modifyJourneyByJourneyId(paramMap);
    }

    @Override
    public void removeJourneyByJourneyId(Map<String, Object> paramMap) {
        journeyMapper.removeJourneyByJourneyId(paramMap);
    }
}
