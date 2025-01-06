package com.example.llm.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService(tools = {"ScrapingTools"})
public interface AIAssistant {

    @SystemMessage("Give responses after scraping the information")
    String chat(@UserMessage String userMessage);
    
}
