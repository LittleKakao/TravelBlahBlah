package com.littlekakao.travelblahblah.journey.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public class Journey {

    @Schema(description = "여정 pk", example = "0")
    private int journeyId;
    @Schema(description = "유저 pk", example = "0")
    private int userId;
    @Schema(description = "여정 제목", example = "미국 여행")
    private String journeyName;
    @Schema(description = "여정 목적지", example = "미국")
    private String journeyDestination;
    @Schema(description = "여정 시작 날짜", example = "2024-01-01 00:00:00")
    private String journeyStartDate;
    @Schema(description = "여정 종료 날짜", example = "2024-01-01 00:00:00")
    private String journeyEndDate;
    @Schema(description = "여정 데이터 생성 시각", example = "2024-01-01 00:00:00")
    private String journeyCreateDate;
    @Schema(description = "여정 데이터 수정 시각", example = "2024-01-01 00:00:00")
    private String journeyUpdateDate;
    @Schema(description = "여정 삭제 여부", example = "N")
    private String journeyDeleteYn;

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getJourneyName() {
        return journeyName;
    }

    public void setJourneyName(String journeyName) {
        this.journeyName = journeyName;
    }

    public String getJourneyDestination() {
        return journeyDestination;
    }

    public void setJourneyDestination(String journeyDestination) {
        this.journeyDestination = journeyDestination;
    }

    public String getJourneyStartDate() {
        return journeyStartDate;
    }

    public void setJourneyStartDate(String journeyStartDate) {
        this.journeyStartDate = journeyStartDate;
    }

    public String getJourneyEndDate() {
        return journeyEndDate;
    }

    public void setJourneyEndDate(String journeyEndDate) {
        this.journeyEndDate = journeyEndDate;
    }

    public String getJourneyCreateDate() {
        return journeyCreateDate;
    }

    public void setJourneyCreateDate(String journeyCreateDate) {
        this.journeyCreateDate = journeyCreateDate;
    }

    public String getJourneyUpdateDate() {
        return journeyUpdateDate;
    }

    public void setJourneyUpdateDate(String journeyUpdateDate) {
        this.journeyUpdateDate = journeyUpdateDate;
    }

    public String getJourneyDeleteYn() {
        return journeyDeleteYn;
    }

    public void setJourneyDeleteYn(String journeyDeleteYn) {
        this.journeyDeleteYn = journeyDeleteYn;
    }
}

