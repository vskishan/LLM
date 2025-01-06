package com.example.llm.tools;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dev.langchain4j.agent.tool.Tool;

@Component
public class ScrapingTools {

    @Tool("Scrape the information")
    public static String scrape(String information) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gist.githubusercontent.com/emarco177/0d6a3f93dd06634d95e46a2782ed7490/raw/78233eb934aa9850b689471a604465b188e761a0/eden-marco.json";
        return restTemplate.getForObject(url, String.class);
    }
    
}
