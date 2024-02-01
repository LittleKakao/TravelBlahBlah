package com.littlekakao.travelblahblah.schedule.controller;

import com.littlekakao.travelblahblah.common.BodyContent;
import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import com.littlekakao.travelblahblah.schedule.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value="/schedule")
public class ScheduleController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ScheduleService scheduleService;

    @Operation(summary = "여정별 일정 조회", description = "journeyId를 사용하여 해당 여정에 속하는 모든 일정을 조회한다.")
    @Parameters({
        @Parameter(name = "journeyId", description = "조회 대상 journeyId", required = true, in = ParameterIn.PATH)
    })
    @GetMapping("/all/{journeyId}")
    public ResponseEntity<BodyContent> findScheduleAll(@PathVariable int journeyId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            List<Schedule> scheduleLists = scheduleService.findScheduleAllByJourneyId(journeyId);
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
            logger.error("[Exception: findScheduleAll] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "일정 조회", description = "대상 scheduleId를 사용하여 일정 상세 데이터를 조회한다.")
    @Parameters({
        @Parameter(name = "scheduleId", description = "조회 대상 scheduleId", required = true, in = ParameterIn.PATH)
    })
    @GetMapping(value="/{scheduleId}")
    public ResponseEntity<BodyContent> findScheduleByScheduleId(@PathVariable int scheduleId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            Schedule schedule = scheduleService.findScheduleByScheduleId(scheduleId);
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
            logger.error("[Exception: findScheduleByScheduleId] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "일정 추가", description = "RequestBody에 일정 상세 파라미터를 담아 호출하여 신규 일정을 등록한다.")
    @PostMapping("")
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

    @Operation(summary = "일정 삭제", description = "scheduleId를 사용하여 해당 일정을 삭제한다.")
    @Parameters({
        @Parameter(name = "scheduleId", description = "삭제 대상 scheduleId", required = true, in = ParameterIn.PATH)
    })
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<BodyContent> removeScheduleByScheduleId(@PathVariable int scheduleId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            scheduleService.removeScheduleByScheduleId(scheduleId);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("삭제 성공");
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);

        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: removeScheduleByScheduleId] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "일정 수정", description = "scheduleId를 사용하여 해당 일정을 수정한다. 호출 시 RequestBody에는 수정할 파라미터만 전달해도 됨")
    @Parameters({
        @Parameter(name = "scheduleId", description = "수정 대상 scheduleId", required = true, in = ParameterIn.PATH),
            @Parameter(name = "scheduleId", description = "수정 대상 scheduleId", required = true, in = ParameterIn.PATH)
    })
    @PutMapping("/{scheduleId}")
    public ResponseEntity<BodyContent> modifyScheduleByScheduleId(@PathVariable int scheduleId, @RequestBody Schedule schedule) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            schedule.setScheduleId(scheduleId);

            scheduleService.modifyScheduleByScheduleId(schedule);
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
