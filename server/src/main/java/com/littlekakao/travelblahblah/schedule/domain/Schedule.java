package com.littlekakao.travelblahblah.schedule.domain;

public class Schedule {
    private int scheduleId;
    private int journeyId;
    private String scheduleName;
    private String scheduleDestination;
    private String scheduleStartDate;
    private String scheduleEndDate;
    private String scheduleMemo;
    private String categoryName;
    private String categoryColor;
    private String scheduleCreateDate;
    private String scheduleUpdateDate;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
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
