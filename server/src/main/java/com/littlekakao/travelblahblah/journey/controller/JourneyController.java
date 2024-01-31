package com.littlekakao.travelblahblah.journey.controller;

import com.littlekakao.travelblahblah.common.BodyContent;
import com.littlekakao.travelblahblah.journey.domain.Journey;
import com.littlekakao.travelblahblah.journey.service.JourneyService;
import com.littlekakao.travelblahblah.schedule.domain.Schedule;
import jdk.jshell.spi.ExecutionControlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journey")
public class JourneyController {

    private final JourneyService journeyService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/all")
    public ResponseEntity<BodyContent> findJourneyAll() throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            List<Journey> journeys = journeyService.findJourneyAll();
            if (journeys.isEmpty()) {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("여정 데이터가 존재하지 않습니다.");
            } else {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("여정 데이터 조회 성공");
                bodyContent.setData(journeys);
            }
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: findJourneyAll] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{journeyId}")
    public ResponseEntity<BodyContent> findJourneyByJourneyId(@PathVariable int journeyId) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            Journey journey = journeyService.findJourneyByJourneyId(journeyId);
            if (ObjectUtils.isEmpty(journey)) {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("여정 데이터가 존재하지 않습니다.");
            } else {
                bodyContent.setStatus("OK");
                bodyContent.setMessage("여정 데이터 조회 성공");
                bodyContent.setData(journey);
            }
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            logger.error("[Exception: findJourneyByJourneyId] ", e);
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<BodyContent> addJourney(@RequestBody Journey journey) throws Exception {
        BodyContent bodyContent = new BodyContent();
        try {
            journeyService.addJourney(journey);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("여정 데이터 등록 성공");
            bodyContent.setData(journeyService.findJourneyByJourneyId(journey.getJourneyId()));
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{journeyId}")
    public ResponseEntity<BodyContent> modifyJourneyByJourneyId(@PathVariable int journeyId, @RequestBody Journey journey) throws Exception {
        BodyContent bodyContent = new BodyContent();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("journeyId", journeyId);
        paramMap.put("journey", journey);
        try {
            journeyService.modifyJourneyByJourneyId(paramMap);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("여정 데이터 수정 성공");
            bodyContent.setData(journeyService.findJourneyByJourneyId(journeyId));
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{journeyId}")
    public ResponseEntity<BodyContent> removeJourneyByJourneyId(@PathVariable int journeyId, @RequestBody Journey journey) throws Exception {
        BodyContent bodyContent = new BodyContent();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("journeyId", journeyId);
        paramMap.put("journey", journey);
        try {
            journeyService.removeJourneyByJourneyId(paramMap);
            bodyContent.setStatus("OK");
            bodyContent.setMessage("여정 데이터 삭제 성공");
            bodyContent.setData(journeyService.findJourneyByJourneyId(journeyId));
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } catch (Exception e) {
            bodyContent.setStatus("FAIL");
            bodyContent.setMessage(e.getMessage());
            return new ResponseEntity<>(bodyContent, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
