package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signup(){
        return "signup";
    }

    @PostMapping
    public String signUpUser(Model model, @ModelAttribute User user) {
        String signUpError =null;

        if (!userService.isUsernameAvailable(user.getUsername()))
            signUpError = "The Username Already Exists.";

        if (signUpError == null) {
            int newUserRow = userService.createUser(user);
            if (newUserRow < 0)
                signUpError = "There was an error signing up, Please try again.";
        }

        if (signUpError == null)
            model.addAttribute("signUpSuccess", true);
        else
            model.addAttribute("signUpError", signUpError);

        return "signup";
    }
}
