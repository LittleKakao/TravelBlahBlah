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
        return journeyMapper.selectJourneyAll();
    }

    @Override
    public Journey findJourneyByJourneyId(int journeyId) {
        return journeyMapper.selectJourneyByJourneyId(journeyId);
    }

    @Override
    public int addJourney(Journey journey) {
        return journeyMapper.insertJourney(journey);
    }

    @Override
    public int modifyJourneyByJourneyId(Map<String, Object> paramMap) {
        return journeyMapper.updateJourneyByJourneyId(paramMap);
    }

    @Override
    public int removeJourneyByJourneyId(int journeyId) {
        return journeyMapper.deleteJourneyByJourneyId(journeyId);
    }
}
