package com.littlekakao.travelblahblah.journey.controller;

import com.littlekakao.travelblahblah.journey.domain.Journey;
import com.littlekakao.travelblahblah.journey.service.JourneyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journey")
public class JourneyController {

    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Journey>> findJourneyAll() throws Exception {
        List<Journey> journeys = journeyService.findJourneyAll();
        return new ResponseEntity<>(journeys, HttpStatus.OK);
    }

    @GetMapping("/{journeyId}")
    public ResponseEntity<Journey> findJourneyByJourneyId(@PathVariable int journeyId) throws Exception {
        Journey journey = journeyService.findJourneyByJourneyId(journeyId);
        if (journey != null) {
            return new ResponseEntity<>(journey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Void> addJourney(@RequestBody Journey journey) throws Exception {
        int isJourneyAdded = journeyService.addJourney(journey);
        if (isJourneyAdded == 1) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{journeyId}")
    public ResponseEntity<Void> modifyJourneyByJourneyId(@PathVariable int journeyId, @RequestBody Journey journey) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("journeyId", journeyId);
        paramMap.put("journey", journey);
        int isJourneyModified = journeyService.modifyJourneyByJourneyId(paramMap);
        if (isJourneyModified == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{journeyId}")
    public ResponseEntity<Void> removeJourneyByJourneyId(@PathVariable int journeyId) throws Exception {
        int isJourneyRemoved = journeyService.removeJourneyByJourneyId(journeyId);
        if (isJourneyRemoved == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
