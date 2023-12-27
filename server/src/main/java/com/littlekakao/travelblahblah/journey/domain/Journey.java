package com.littlekakao.travelblahblah.journey.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Journey {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int journeyId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int userId;
    private String journeyName;
    private String journeyDestination;
    private Date journeyStartDate;
    private Date journeyEndDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date journeyCreateDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date journeyUpdateDate;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
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

    public Date getJourneyStartDate() {
        return journeyStartDate;
    }

    public void setJourneyStartDate(Date journeyStartDate) {
        this.journeyStartDate = journeyStartDate;
    }

    public Date getJourneyEndDate() {
        return journeyEndDate;
    }

    public void setJourneyEndDate(Date journeyEndDate) {
        this.journeyEndDate = journeyEndDate;
    }

    public Date getJourneyCreateDate() {
        return journeyCreateDate;
    }

    public void setJourneyCreateDate(Date journeyCreateDate) {
        this.journeyCreateDate = journeyCreateDate;
    }

    public Date getJourneyUpdateDate() {
        return journeyUpdateDate;
    }

    public void setJourneyUpdateDate(Date journeyUpdateDate) {
        this.journeyUpdateDate = journeyUpdateDate;
    }

    public String getJourneyDeleteYn() {
        return journeyDeleteYn;
    }

    public void setJourneyDeleteYn(String journeyDeleteYn) {
        this.journeyDeleteYn = journeyDeleteYn;
    }
}

