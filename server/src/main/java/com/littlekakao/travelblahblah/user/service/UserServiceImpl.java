package com.littlekakao.travelblahblah.user.service;

import com.littlekakao.travelblahblah.user.domain.User;
import com.littlekakao.travelblahblah.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findUserAll() {
        return userMapper.selectUserAll();
    }

    @Override
    public User findUserByUserId(int userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int modifyUserByUserId(Map<String, Object> paramMap) {
        return userMapper.updateUserByUserId(paramMap);
    }

    @Override
    public int removeUserByUserId(int userId) {
        return userMapper.deleteUserByUserId(userId);
    }
}
