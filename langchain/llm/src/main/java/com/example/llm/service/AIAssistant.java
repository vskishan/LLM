package com.example.llm.service;

import com.example.llm.model.PersonInfo;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService(tools = {"ScrapingTools"})
public interface AIAssistant {

    @SystemMessage("Give responses after scraping the information")
    PersonInfo chat(@UserMessage String userMessage);
    
}
