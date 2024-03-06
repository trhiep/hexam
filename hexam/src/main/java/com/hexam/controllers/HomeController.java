package com.hexam.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author trhiep
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            for (GrantedAuthority authority : auth.getAuthorities()) {
                if (authority.getAuthority().equals("ROLE_ADMIN")) {
                    return "redirect:/admin/";
                }
            }
        }
        model.addAttribute("pageTitle", "HExam");
        return "guest/index";
    }
}
