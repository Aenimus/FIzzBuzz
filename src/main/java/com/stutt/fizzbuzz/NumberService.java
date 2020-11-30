package com.stutt.fizzbuzz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class NumberService {

    private final String prefix;
    private final Map<Integer, String> numberMap;

    public NumberService(@Autowired AppProperties app) {
        this.prefix = app.getPrefix();
        this.numberMap = app.getNumberMap();
    }

    public String evaluateNumber(final int number) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> entry : numberMap.entrySet()) {
            final int key = entry.getKey();
            if (number % key == 0) {
                if (!stringBuilder.toString().equals("")) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(entry.getValue());
            }
        }
        String mapResult = stringBuilder.toString();
        if (mapResult.equals("")) {
            mapResult = String.valueOf(number);
        }
        log.info("{} {}", this.prefix, mapResult);
        return mapResult;
    }
}
