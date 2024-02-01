package com.littlekakao.travelblahblah.schedule.service;

import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import java.util.List;

public interface ScheduleService {

    public List<Schedule> findScheduleAllByJourneyId(int journeyId) throws Exception;

    public Schedule findScheduleByScheduleId(int scheduleId) throws Exception;

    public void addSchedule(Schedule schedule) throws Exception;

    public void modifyScheduleByScheduleId(Schedule schedule) throws Exception;

    public void removeScheduleByScheduleId(int scheduleId) throws Exception;
}
