package com.littlekakao.travelblahblah.journey.mapper;

import com.littlekakao.travelblahblah.journey.domain.Journey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JourneyMapper {
    public List<Journey> selectJourneyAll();
    public Journey selectJourneyByJourneyId(int journeyId);
    public int insertJourney(Journey journey);
    public int updateJourneyByJourneyId(Map<String, Object> paramMap);
    public int deleteJourneyByJourneyId(int journeyId);
}
