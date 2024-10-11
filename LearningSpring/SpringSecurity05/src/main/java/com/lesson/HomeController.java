package com.lesson;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "home.jsp";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login.jsp";
    }

    @RequestMapping("/logout-success")
    public String logoutPage(){
        return "logout.jsp";
    }

    @RequestMapping("user")
    @ResponseBody
    public Principal user(Principal principal){
        return principal;
    }
}
