package com.littlekakao.travelblahblah.user.controller;

import com.littlekakao.travelblahblah.common.BodyContent;
import com.littlekakao.travelblahblah.user.domain.User;
import com.littlekakao.travelblahblah.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<BodyContent> findUserAll() throws Exception {
        List<User> users = userService.findUserAll();
        BodyContent bodyContent = new BodyContent();
        bodyContent.setStatus("OK");
        bodyContent.setMessage("서버가 요청을 성공적으로 처리하였습니다.");
        bodyContent.setData(users);
        return new ResponseEntity<>(bodyContent, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BodyContent> findUserByUserId(@PathVariable int userId) throws Exception {
        User user = userService.findUserByUserId(userId);
        BodyContent bodyContent = new BodyContent();
        if (user != null) {
            bodyContent.setStatus("OK");
            bodyContent.setMessage("서버가 요청을 성공적으로 처리하였습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } else {
            bodyContent.setStatus("NOT_FOUND");
            bodyContent.setMessage("서버가 요청한 리소스를 찾을 수 없습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<BodyContent> addUser(@RequestBody User user) throws Exception {
        int isUserAdded = userService.addUser(user);
        BodyContent bodyContent = new BodyContent();
        if (isUserAdded == 1) {
            bodyContent.setStatus("CREATED");
            bodyContent.setMessage("리소스가 성공적으로 생성되었습니다.");
            bodyContent.setData(userService.findUserByUserId(user.getUserId()));
            return new ResponseEntity<>(bodyContent, HttpStatus.CREATED);
        } else {
            bodyContent.setStatus("BAD_REQUEST");
            bodyContent.setMessage("요청이 잘못되었습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<BodyContent> modifyUserByUserId(@PathVariable int userId, @RequestBody User user) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("user", user);
        int isUserModified = userService.modifyUserByUserId(paramMap);
        BodyContent bodyContent = new BodyContent();
        if (isUserModified == 1) {
            bodyContent.setStatus("OK");
            bodyContent.setMessage("리소스가 성공적으로 생성되었습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } else {
            bodyContent.setStatus("NOT_FOUND");
            bodyContent.setMessage("서버가 요청한 리소스를 찾을 수 없습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<BodyContent> removeUserByUserId(@PathVariable int userId) throws Exception {
        int isUserRemoved = userService.removeUserByUserId(userId);
        BodyContent bodyContent = new BodyContent();
        if (isUserRemoved == 1) {
            bodyContent.setStatus("OK");
            bodyContent.setMessage("리소스가 성공적으로 생성되었습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.OK);
        } else {
            bodyContent.setStatus("NOT_FOUND");
            bodyContent.setMessage("서버가 요청한 리소스를 찾을 수 없습니다.");
            return new ResponseEntity<>(bodyContent, HttpStatus.NOT_FOUND);
        }
    }
}
