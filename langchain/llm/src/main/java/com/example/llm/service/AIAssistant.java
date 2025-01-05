package com.example.llm.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface AIAssistant {

    @SystemMessage("Give responses based on the information : {{information}}")
    String chat(@UserMessage String userMessage, @V("information") String information);
    
}
