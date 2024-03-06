package com.hexam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author trhiep
 */
@Controller
public class LoginController {
    @RequestMapping("/dang-nhap")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Đăng nhập");
        return "guest/login";
    }
}
