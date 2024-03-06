package com.hexam.controllers;

import com.hexam.constants.EntityConstants;
import com.hexam.constants.ProgramRegex;
import com.hexam.constants.WebErrorMessage;
import com.hexam.models.Person;
import com.hexam.models.UserRole;
import com.hexam.repositories.PersonRepository;
import com.hexam.services.user.UserServiceImpl;
import com.hexam.utils.validator.RegexValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.http.HttpRequest;

/**
 * @author trhiep
 */
@Controller
public class SignupController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dang-ky")
    public String getSignupPage(Model model) {
        model.addAttribute("pageTitle", "Đăng ký");
        return "guest/signup";
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public String submitSignup(HttpServletRequest request, Model model) {
        String fullName = request.getParameter("fullName");
        boolean isValidFullName = isValidFullName(fullName, model);

        String userName = request.getParameter("userName");
        boolean isValidUserName = isValidUserName(userName, model);

        String email = request.getParameter("email");
        boolean isValidEmail = isValidEmailAddress(email, model);

        String password = request.getParameter("password");
        boolean isValidPassword = isValidPassword(password, model);

        String rePassword = request.getParameter("rePassword");
        boolean isValidRePassword = isValidRePassword(password, rePassword, model);

        String acceptTerm = request.getParameter("acceptTerm");
        boolean isAcceptedTerm = isAcceptedTerm(acceptTerm, model);

        String role = request.getParameter("role");
        boolean isValidRole = isValidRole(role, model);

        if (isValidFullName
                && isValidUserName
                && isValidEmail
                && isValidPassword
                && isValidRePassword
                && isAcceptedTerm
                && isValidRole) {
            Person person = Person.builder()
                    .fullName(fullName)
                    .userName(userName)
                    .emailAddress(email)
                    .password(new BCryptPasswordEncoder().encode(password))
                    .userRole(UserRole.builder().roleCode(role).build())
                    .build();
            personRepository.save(person);
            return "redirect:/dang-nhap";
        } else {
            model.addAttribute("fullName", fullName);
            model.addAttribute("userName", userName);
            model.addAttribute("email", email);
        }
        model.addAttribute("pageTitle", "Đăng ký");
        return "guest/signup";
    }

    private boolean isValidFullName(String fullName, Model model) {
        if (fullName.isEmpty()
                || fullName.length() < EntityConstants.Person.FULL_NAME_MIN_LENGTH
                || fullName.length() > EntityConstants.Person.FULL_NAME_MAX_LENGTH) {
            model.addAttribute("INVALID_FULL_NAME_LENGTH",
                    WebErrorMessage.RegisterError.INVALID_FULL_NAME_LENGTH);
            return false;
        }
        return true;
    }

    private boolean isValidUserName(String userName, Model model) {
        boolean isValid = true;
        if (userName.isEmpty()
                || userName.length() < EntityConstants.Person.USER_NAME_MIN_LENGTH
                || userName.length() > EntityConstants.Person.USER_NAME_MAX_LENGTH) {
            model.addAttribute("INVALID_USERNAME_LENGTH",
                    WebErrorMessage.RegisterError.INVALID_USERNAME_LENGTH);
            isValid = false;
        }
        if (!RegexValidator.isMatches(ProgramRegex.UserInformationRegex.USERNAME_REGEX, userName)) {
            model.addAttribute("INVALID_USERNAME_FORMAT",
                    WebErrorMessage.RegisterError.INVALID_USERNAME_FORMAT);
            isValid = false;
        }
        if (!userService.isExistedUserName(userName)) {
            model.addAttribute("EXISTED_USERNAME",
                    WebErrorMessage.RegisterError.EXISTED_USERNAME);
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidEmailAddress(String email, Model model) {
        boolean isValid = true;
        if (email.isEmpty()
                || email.length() > EntityConstants.Person.EMAIL_MAX_LENGTH) {
            model.addAttribute("INVALID_EMAIL_LENGTH",
                    WebErrorMessage.RegisterError.INVALID_EMAIL_LENGTH);
            isValid = false;
        }
        if (!RegexValidator.isMatches(ProgramRegex.UserInformationRegex.EMAIL_REGEX, email)) {
            model.addAttribute("INVALID_EMAIL_FORMAT",
                    WebErrorMessage.RegisterError.INVALID_EMAIL_FORMAT);
            isValid = false;
        }
        if (!userService.isExistedEmail(email)) {
            model.addAttribute("EXISTED_EMAIL",
                    WebErrorMessage.RegisterError.EXISTED_EMAIL);
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidPassword(String password, Model model) {
        boolean isValid = true;
        if (password.isEmpty()
                || password.length() < EntityConstants.Person.PASSWORD_MIN_LENGTH
                || password.length() > EntityConstants.Person.PASSWORD_MAX_LENGTH) {
            model.addAttribute("INVALID_PASSWORD_LENGTH",
                    WebErrorMessage.RegisterError.INVALID_PASSWORD_LENGTH);
            isValid = false;
        }

        if (!RegexValidator.isMatches(ProgramRegex.UserInformationRegex.PASSWORD_REGEX, password)) {
            model.addAttribute("INVALID_PASSWORD_FORMAT",
                    WebErrorMessage.RegisterError.INVALID_PASSWORD_FORMAT);
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidRePassword(String password, String rePassword, Model model) {
        boolean isValid = true;
        if (rePassword.isEmpty()
                || password.length() < EntityConstants.Person.PASSWORD_MIN_LENGTH
                || password.length() > EntityConstants.Person.PASSWORD_MAX_LENGTH) {
            model.addAttribute("INVALID_RE_PASSWORD_LENGTH",
                    WebErrorMessage.RegisterError.INVALID_PASSWORD_LENGTH);
            isValid = false;
        }

        if (!rePassword.equals(password)) {
            model.addAttribute("RE_PASSWORD_DOES_NOT_MATCHES",
                    WebErrorMessage.RegisterError.RE_PASSWORD_DOES_NOT_MATCHES);
            isValid = false;
        }
        return isValid;
    }

    private boolean isAcceptedTerm(String acceptTerm, Model model) {
        if (acceptTerm == null) {
            model.addAttribute("NOT_ACCEPT_TERM",
                    WebErrorMessage.RegisterError.NOT_ACCEPT_TERM);
            return false;
        }
        return true;
    }

    private boolean isValidRole(String role, Model model) {
        if (!role.equals("TEACH") && !role.equals("STUDN")) {
            model.addAttribute("INVALID_REQUEST_PARAMETER",
                    WebErrorMessage.RegisterError.INVALID_REQUEST_PARAMETER);
            return false;
        }
        return true;
    }

}
