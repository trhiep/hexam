package com.hexam.controllers;

import com.hexam.constants.WebErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author trhiep
 */
@Controller
public class LoginController {
    @RequestMapping("/dang-nhap")
    public String login(HttpServletRequest request, Model model) {
        if (request.getParameter("error") != null) {
            model.addAttribute("errorMessage", WebErrorMessage.LoginError.INVALID_USERNAME_OR_PASSWORD);
        }
        model.addAttribute("pageTitle", "Đăng nhập");
        return "pages/guest/login";
    }

}
