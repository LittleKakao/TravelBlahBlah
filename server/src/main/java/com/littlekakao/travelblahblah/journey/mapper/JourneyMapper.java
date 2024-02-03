package com.littlekakao.travelblahblah.journey.mapper;

import com.littlekakao.travelblahblah.journey.domain.Journey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JourneyMapper {
    public List<Journey> findJourneyAll(int userId);
    public Journey findJourneyByJourneyId(int journeyId);
    public void addJourney(Journey journey);
    public void modifyJourneyByJourneyId(Map<String, Object> paramMap);
    public void removeJourneyByJourneyId(Map<String, Object> paramMap);
}
