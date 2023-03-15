package art.chunlei.boot.controller;


import art.chunlei.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class PageController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index_")
    public String index_(HttpSession session) {
        System.out.println(session.getAttribute("loginUser"));
        return "index_";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/account")
    public String account() {
        return "account";
    }

    @RequestMapping("/hall")
    public String hall() {
        return "hall";
    }

    @RequestMapping("/help")
    public String help() {
        return "help";
    }

    @RequestMapping("/project_details")
    public String project_details() {
        return "project_details";
    }

    @RequestMapping("/project_details_1")
    public String project_details_1() {
        return "project_details_1";
    }

    @RequestMapping("/project_details_2")
    public String project_details_2() {
        return "project_details_2";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }

    @RequestMapping("/release")
    public String release() {
        return "release";
    }

    @RequestMapping("/reset_password")
    public String reset_password() {
        return "reset_password";
    }
}