package com.littlekakao.travelblahblah.journey.domain;

import java.util.Date;

public class Journey {
    private int journeyId;
    private String journeyNm;
    private String journeyDest;
    private int userId;
    private Date createDt;
    private Date updateDt;
    private Date journeyStartDt;
    private Date journeyEndDt;
    private boolean journeyDelYn;

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public String getJourneyNm() {
        return journeyNm;
    }

    public void setJourneyNm(String journeyNm) {
        this.journeyNm = journeyNm;
    }

    public String getJourneyDest() {
        return journeyDest;
    }

    public void setJourneyDest(String journeyDest) {
        this.journeyDest = journeyDest;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public Date getJourneyStartDt() {
        return journeyStartDt;
    }

    public void setJourneyStartDt(Date journeyStartDt) {
        this.journeyStartDt = journeyStartDt;
    }

    public Date getJourneyEndDt() {
        return journeyEndDt;
    }

    public void setJourneyEndDt(Date journeyEndDt) {
        this.journeyEndDt = journeyEndDt;
    }

    public boolean isJourneyDelYn() {
        return journeyDelYn;
    }

    public void setJourneyDelYn(boolean journeyDelYn) {
        this.journeyDelYn = journeyDelYn;
    }
}
