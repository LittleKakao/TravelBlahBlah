package com.littlekakao.travelblahblah.schedule.service;

import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import java.util.List;

public interface ScheduleService {

    public List<Schedule> findAllScheduleByJourneyId(int journeyId) throws Exception;

    public Schedule findOneScheduleById(int scheduleId) throws Exception;

    public void addSchedule(Schedule schedule) throws Exception;

    public void updateSchedule(Schedule schedule) throws Exception;

    public void deleteSchedule(int scheduleId) throws Exception;
}
