package com.example.lab2comp367;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model) {
        LocalTime currentTime = LocalTime.now();
        String timeSpecificGreeting;

        if (currentTime.isBefore(LocalTime.NOON)) {
            timeSpecificGreeting = "Good morning Josh Welcome to COMP367";
        } else {
            timeSpecificGreeting = "Good afternoon Josh Welcome to COMP367";
        }

        model.addAttribute("message", timeSpecificGreeting);
        return "welcome";
    }
}
