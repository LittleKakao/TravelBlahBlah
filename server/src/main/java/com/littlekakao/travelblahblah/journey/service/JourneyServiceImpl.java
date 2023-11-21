package com.littlekakao.travelblahblah.journey.service;

import com.littlekakao.travelblahblah.journey.domain.Journey;
import com.littlekakao.travelblahblah.journey.mapper.JourneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int modifyJourneyByJourneyId(int journeyId, Journey journey) {
        return journeyMapper.updateJourneyByJourneyId(journeyId, journey);
    }

    @Override
    public int removeJourneyByJourneyId(int journeyId) {
        return journeyMapper.deleteJourneyByJourneyId(journeyId);
    }
}
