package com.littlekakao.travelblahblah.user.mapper;

import com.littlekakao.travelblahblah.journey.domain.Journey;
import com.littlekakao.travelblahblah.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    public List<User> selectUserAll();
    public User selectUserByUserId(int userId);
    public int insertUser(User user);
    public int updateUserByUserId(Map<String, Object> paramMap);
    public int deleteUserByUserId(int userId);
}
