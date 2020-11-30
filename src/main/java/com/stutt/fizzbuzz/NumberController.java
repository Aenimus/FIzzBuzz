package com.stutt.fizzbuzz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@RequestMapping("/response")
@Controller
public class NumberController {

    private final NumberService numberService;

    public NumberController(@Autowired final NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping
    public String response() {
        return "response";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{number}")
    public String evaluateNumber(@PathVariable final int number, Model model) {
        String log = numberService.evaluateNumber(number);
        model.addAttribute("num", number);
        model.addAttribute("log", log);
        return "number";
    }
}
