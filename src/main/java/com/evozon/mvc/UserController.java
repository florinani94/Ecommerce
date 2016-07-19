package com.evozon.mvc;

import com.evozon.domain.User;
import com.evozon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by dianamohanu on 18/07/2016.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerNewBackofficeUser() {
        return "registerUser";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String messageNewBackofficeUser(Model model, @RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("pass1") String pass1, @RequestParam("pass2") String pass2) {
        int errors = 0;
        if (! pass1.equals(pass2)) {
            model.addAttribute("passwordError", "Passwords don't match!");
            errors++;
        }

        if (userService.checkIfEmailExists(email) == true) {
            model.addAttribute("emailError", "Email already used!");
            errors++;
        }

        if (userService.checkIfUsernameExists(username) == true) {
            model.addAttribute("usernameError", "Username already used!");
            errors++;
        }

        if(errors == 0) {
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(pass1);
            user.setActive(false);

            userService.addUser(user);

            model.addAttribute("message1", "Information submitted successfully.");
            model.addAttribute("message2", "Please verify your email to confirm your account!");
        }
        else {
            model.addAttribute("message1", "Information NOT submitted.");
        }

        return "registerUser";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginBackofficeUser() {
        return "loginBackoffice";
    }
}
