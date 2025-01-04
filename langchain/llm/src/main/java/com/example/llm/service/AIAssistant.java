package com.example.llm.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService(chatModel="openAiChatModel")
public interface AIAssistant {

    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
    
}
