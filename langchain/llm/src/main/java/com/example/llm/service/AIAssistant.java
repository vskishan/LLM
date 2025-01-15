package com.example.llm.service;

import com.example.llm.model.PersonInfo;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService(
//tools = {"ScrapingTools"}, 
contentRetriever = "SimpleContentRetriever")
public interface AIAssistant {

    //@SystemMessage("Give responses after scraping the information")
    @SystemMessage("You are a polite agent")
    PersonInfo chat(@UserMessage String userMessage);
    
}
