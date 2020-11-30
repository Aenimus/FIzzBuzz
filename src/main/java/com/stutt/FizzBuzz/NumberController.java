package com.stutt.FizzBuzz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/response")
@Controller
@RequiredArgsConstructor
public class NumberController {
    @Autowired
    private final NumberService numberService;
    @GetMapping()
    public String response() {
        return "response.html";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{number}")
    public String evaluateNumber(@PathVariable final int number, Model model) {
        String log = numberService.evaluateNumber(number);
        model.addAttribute("num", number);
        model.addAttribute("log", log);
        return "number.html";
    }
}
