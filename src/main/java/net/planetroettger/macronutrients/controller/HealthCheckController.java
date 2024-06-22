package net.planetroettger.macronutrients.controller;

import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {


    @GetMapping("/health")
    public Map<String, String> getHealth() {
        Map<String, String> healthDetails = new HashMap<>();
        healthDetails.put("name", "Macro Nutrients");
        return healthDetails;
    }
}