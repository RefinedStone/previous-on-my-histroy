package com.sparta.submitHomwork.controller;

import com.sparta.submitHomwork.dto.PostRequestDto;
import com.sparta.submitHomwork.dto.SignupRequestDto;
import com.sparta.submitHomwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 회원 가입 API
    @PostMapping("/dev/user/signup")
    public String registerUser(@RequestBody SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "sign-up success";
    }

}