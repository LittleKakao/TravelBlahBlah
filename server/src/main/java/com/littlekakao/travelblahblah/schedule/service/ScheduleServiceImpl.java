package com.littlekakao.travelblahblah.schedule.service;

import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import com.littlekakao.travelblahblah.schedule.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public List<Schedule> findScheduleAllByJourneyId(int journeyId) throws Exception {
        return scheduleMapper.findScheduleAllByJourneyId(journeyId);
    }

    @Override
    public Schedule findScheduleByScheduleId(int scheduleId) throws Exception {
        return scheduleMapper.findScheduleByScheduleId(scheduleId);
    }

    @Override
    public void addSchedule(Schedule schedule) throws Exception {
        int result = scheduleMapper.addSchedule(schedule);
        if (result != 1) {
            throw new Exception("Error [ScheduleService.addSchedule] add failed! scheduleId: " + schedule.toString());
        }
    }

    @Override
    public void removeScheduleByScheduleId(int scheduleId) throws Exception {
        int result = scheduleMapper.removeScheduleByScheduleId(scheduleId);
        if (result != 1) {
            throw new Exception ("Error [ScheduleService.removeScheduleByScheduleId] delete Failed scheduleId: " + scheduleId);
        }
    }

    @Override
    public void modifyScheduleByScheduleId(Schedule schedule) throws Exception {
        int result = scheduleMapper.modifyScheduleByScheduleId(schedule);
        if (result != 1) {
            throw new Exception ("Error [ScheduleService.modifyScheduleByScheduleId] update failed ");
        }
    }
}
