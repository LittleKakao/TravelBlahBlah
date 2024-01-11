package com.littlekakao.travelblahblah.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int userId;
    private String userName;
    private String userDeleteYn;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDeleteYn() {
        return userDeleteYn;
    }

    public void setUserDeleteYn(String userDeleteYn) {
        this.userDeleteYn = userDeleteYn;
    }
}
