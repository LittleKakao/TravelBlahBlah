package com.littlekakao.travelblahblah.user.service;


import com.littlekakao.travelblahblah.journey.domain.Journey;
import com.littlekakao.travelblahblah.user.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findUserAll();
    public User findUserByUserId(int userId);
    public int addUser(User user);
    public int modifyUserByUserId(Map<String, Object> paramMap);
    public int removeUserByUserId(int userId);
}
