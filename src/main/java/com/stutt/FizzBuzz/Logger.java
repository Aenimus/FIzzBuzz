package com.stutt.FizzBuzz;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Logger {
    @Autowired
    private AppProperties app;

    @Getter
    private String lastLog = "";

    public void evaluate(int number) {
        int[] nums = app.getNums();
        String[] words = app.getWords();
        String result = "";

        for (int i = 0; i < nums.length; i++) {
            if (number % nums[i] == 0) {
                result = result == "" ? result : result + " ";
                result = result + words[i];
            }
        }

        result = result == "" ? Integer.toString(number) : result;

        log.info("{} {}", app.getPrefix(), result);
        lastLog = result;
    }
}
