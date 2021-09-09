package com.revature.ghiblihub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    public HomeController() {

    }

    @RequestMapping(value={"", "/", "/home"})
    public String homePage() {
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
