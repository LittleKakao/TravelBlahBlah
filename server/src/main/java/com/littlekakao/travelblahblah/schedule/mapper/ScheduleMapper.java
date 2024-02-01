package com.littlekakao.travelblahblah.schedule.mapper;

import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    public List<Schedule> findScheduleAllByJourneyId(int journeyId);

    public Schedule findScheduleByScheduleId(int scheduleId);

    public int addSchedule(Schedule schedule);

    public int removeScheduleByScheduleId(int scheduleId);

    public int modifyScheduleByScheduleId(Schedule schedule);
}
