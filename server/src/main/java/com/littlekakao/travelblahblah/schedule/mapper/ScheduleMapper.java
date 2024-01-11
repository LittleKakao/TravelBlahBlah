package com.littlekakao.travelblahblah.schedule.mapper;

import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    public List<Schedule> findAllScheduleByJourneyId(int journeyId);

    public Schedule findOneScheduleById(int scheduleId);

    public int addSchedule(Schedule schedule);

    public int deleteSchedule(int scheduleId);

    public int updateSchedule(Schedule schedule);
}
