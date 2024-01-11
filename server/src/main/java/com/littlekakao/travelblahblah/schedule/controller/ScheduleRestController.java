package com.littlekakao.travelblahblah.schedule.controller;

import com.littlekakao.travelblahblah.common.BodyContent;
import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import com.littlekakao.travelblahblah.schedule.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value="/schedule")
public class ScheduleRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ScheduleService scheduleService;

    @Operation(description = "특정 여정의 모든 일정을 반환한다." )
    @Parameters({
        @Parameter(name = "journeyId", description = "조회 대상 journeyId", required = true)
    })
    @GetMapping("/findAllSchedule/{journeyId}")
    public ResponseEntity<BodyContent> findAllSchedule(@PathVariable int journeyId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            List<Schedule> scheduleLists = scheduleService.findAllScheduleByJourneyId(journeyId);
            if (scheduleLists.isEmpty()) {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("존재하지 않는 여정"); // to do : message property 생성하여 정리
            } else {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("조회 성공");
                bodyContent.setData(scheduleLists);
            }
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: findAllSchedule] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "특정 일정을 반환한다." )
    @Parameters({
        @Parameter(name = "scheduleId", description = "조회 대상 scheduleId", required = true)
    })
    @GetMapping(value="/findOneSchedule/{scheduleId}")
    public ResponseEntity<BodyContent> findOneSchedule(@PathVariable int scheduleId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            Schedule schedule = scheduleService.findOneScheduleById(scheduleId);
            if (ObjectUtils.isEmpty(schedule)) {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("존재하지 않는 일정"); // to do : message property 생성하여 정리
            } else {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("조회 성공");
                bodyContent.setData(schedule);
            }
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e){
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: findOneSchedule] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(description = "일정을 추가한다.")
    @Parameters({
        @Parameter(name = "journeyId", description = "추가할 schedule의 소속 journeyId", required = true)
        ,@Parameter(name = "scheduleName", required = false)
        ,@Parameter(name = "scheduleDestination", required = false)
        ,@Parameter(name = "scheduleStartDate", required = false)
        ,@Parameter(name = "scheduleEndDate", required = false)
        ,@Parameter(name = "categoryName", required = false)
        ,@Parameter(name = "categoryColor", required = false)
    })
    @PostMapping("/addSchedule")
    public ResponseEntity<BodyContent> addSchedule(@RequestBody Schedule schedule) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            scheduleService.addSchedule(schedule);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("등록 성공");
            bodyContent.setData(schedule);
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: addSchedule] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete
    @Operation(description = "특정 일정을 삭제한다." )
    @Parameters({
        @Parameter(name = "scheduleId", description = "삭제 대상 scheduleId", required = true)
    })
    @PutMapping("/deleteSchedule/{scheduleId}")
    public ResponseEntity<BodyContent> deleteSchedule(@PathVariable int scheduleId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            scheduleService.deleteSchedule(scheduleId);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("삭제 성공");
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);

        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: deleteSchedule] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update
    @Operation(description = "특정 일정을 수정한다." )
    @Parameters({
        @Parameter(name = "scheduleId", description = "수정 대상 scheduleId", required = true)
    })
    @PutMapping("/updateSchedule/{scheduleId}")
    public ResponseEntity<BodyContent> updateSchedule(@PathVariable int scheduleId, @RequestBody Schedule schedule) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            logger.error(schedule.toString());
            scheduleService.updateSchedule(schedule);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("수정 성공");
            bodyContent.setData(schedule);
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: updateSchedule] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
