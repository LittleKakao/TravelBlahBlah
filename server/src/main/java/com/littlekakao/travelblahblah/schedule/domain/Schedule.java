package com.littlekakao.travelblahblah.schedule.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class Schedule {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int scheduleId;
    @Schema(description = "소속 여정 아이디", nullable = false, example = "1")
    private int journeyId;
    @Schema(description = "일정명", nullable = false, example = "쇼츠 촬영", maxLength = 20)
    private String scheduleName;
    @Schema(description = "일정 장소", nullable = true, example = "보성 녹차밭", maxLength = 20)
    private String scheduleDestination;
    @Schema(description = "일정 시작 일시", nullable= false, example = "2024-01-01 18:00:00")
    private String scheduleStartDate;
    @Schema(description = "일정 종료 일시", nullable= false, example = "2024-01-01 19:00:00")
    private String scheduleEndDate;
    @Schema(description = "일정메모", nullable = true, example = "보성의 푸르른 녹차밭에서 멋진 쇼츠를 찍는다.", maxLength = 200)
    private String scheduleMemo;
    @Schema(description = "카테고리 아이디", nullable = false, example = "122")
    private int categoryId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String scheduleCreateDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String scheduleUpdateDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "일정 삭제 여부", example = "N")
    private String scheduleDeleteYn;

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public String getScheduleDestination() {
        return scheduleDestination;
    }

    public void setScheduleDestination(String scheduleDestination) {
        this.scheduleDestination = scheduleDestination;
    }

    public String getScheduleStartDate() {
        return scheduleStartDate;
    }

    public void setScheduleStartDate(String scheduleStartDate) {
        this.scheduleStartDate = scheduleStartDate;
    }

    public String getScheduleEndDate() {
        return scheduleEndDate;
    }

    public void setScheduleEndDate(String scheduleEndDate) {
        this.scheduleEndDate = scheduleEndDate;
    }

    public String getScheduleMemo() {
        return scheduleMemo;
    }

    public void setScheduleMemo(String scheduleMemo) {
        this.scheduleMemo = scheduleMemo;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getScheduleCreateDate() {
        return scheduleCreateDate;
    }

    public void setScheduleCreateDate(String scheduleCreateDate) {
        this.scheduleCreateDate = scheduleCreateDate;
    }

    public String getScheduleUpdateDate() {
        return scheduleUpdateDate;
    }

    public void setScheduleUpdateDate(String scheduleUpdateDate) {
        this.scheduleUpdateDate = scheduleUpdateDate;
    }

    public String getScheduleDeleteYn() {
        return scheduleDeleteYn;
    }

    public void setScheduleDeleteYn(String scheduleDeleteYn) {
        this.scheduleDeleteYn = scheduleDeleteYn;
    }
}
