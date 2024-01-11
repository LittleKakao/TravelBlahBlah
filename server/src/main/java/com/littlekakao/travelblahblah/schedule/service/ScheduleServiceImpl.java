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
    public List<Schedule> findAllScheduleByJourneyId(int journeyId) throws Exception {
        return scheduleMapper.findAllScheduleByJourneyId(journeyId);
    }

    @Override
    public Schedule findOneScheduleById(int scheduleId) throws Exception {
        return scheduleMapper.findOneScheduleById(scheduleId);
    }

    @Override
    public void addSchedule(Schedule schedule) throws Exception {
        int result = scheduleMapper.addSchedule(schedule);
        if (result != 1) {
            throw new Exception("Error [ScheduleService.addSchedule] add failed! scheduleId: " + schedule.toString());
        }
    }

    @Override
    public void deleteSchedule(int scheduleId) throws Exception {
        int result = scheduleMapper.deleteSchedule(scheduleId);
        if (result != 1) {
            throw new Exception ("Error [ScheduleService.deleteSchedule] delete Failed scheduleId: " + scheduleId);
        }
    }

    @Override
    public void updateSchedule(Schedule schedule) throws Exception {
        int result = scheduleMapper.updateSchedule(schedule);
        if (result != 1) {
            throw new Exception ("Error [ScheduleService.updateSchedule] update failed ");
        }
    }
}
