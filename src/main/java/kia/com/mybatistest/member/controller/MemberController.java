package kia.com.mybatistest.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @GetMapping("/join")
    public String visitJoin() {
        return "/member/join";
    }

    @PostMapping("/join")
    public String doJoin() {
        return "/member/join";
    }
}
