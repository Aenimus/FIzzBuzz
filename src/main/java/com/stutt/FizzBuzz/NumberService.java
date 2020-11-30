package com.stutt.FizzBuzz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Service
public class NumberService {
    @Autowired
    private Logger logger;

    @GetMapping("/{number}")
    public String evaluateNumber(@PathVariable final int number) {
        logger.evaluate(number);
        return logger.getLastLog();
    }
}
