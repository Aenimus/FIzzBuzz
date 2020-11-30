package com.stutt.fizzbuzz;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {
    private String prefix;
    @Value("#{${app.mappings}}")
    private Map<Integer, String> numberMap;
}
