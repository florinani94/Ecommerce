package com.evozon.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dianamohanu on 18/07/2016.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerNewBackofficeUser() {
        return "registerUser";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String messageNewBackofficeUser(Model model) {
        model.addAttribute("message1", "Information submitted.");
        model.addAttribute("message2", "Please verify your email to confirm your account!");
        return "registerUser";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginBackofficeUser() {
        return "loginBackoffice";
    }
}
