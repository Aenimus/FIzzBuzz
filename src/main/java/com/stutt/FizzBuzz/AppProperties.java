package com.stutt.FizzBuzz;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "app")
@Getter @Setter
public class AppProperties {
    private String prefix;
    private String allNums;
    private String allWords;

    private int[] nums;
    private String[] words;

    public void setNums() {
        String[] numArray = allNums.split(",");
        nums = new int[numArray.length];
        int a;
        for (int i = 0; i < numArray.length; i++) {
            try {
                a = Integer.parseInt(numArray[i]);
                nums[i] = a;
            } catch (Exception e) {
                log.error("{} is not an integer.", numArray[i]);
            }
        }
    }

    public void setWords() {
        words = allWords.split(",");
        if (nums.length != words.length) {
            log.error("The list of integers and words were not equal.");
        }
    }
}
