package com.reservation.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/mypage")
public class MypageController {

    @GetMapping()
    public String myPageTest() {
        return "mypage/mypage";
    }
}
