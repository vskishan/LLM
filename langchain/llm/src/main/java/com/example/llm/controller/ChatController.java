package com.example.llm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.llm.model.UserInput;
import com.example.llm.service.AIAssistant;

@RestController
public class ChatController {

    @Autowired
    private AIAssistant assistant;
    
    @GetMapping("/chat")
    public String getChat(@RequestBody UserInput userInput) {
        return assistant.chat(userInput.getMessage(), userInput.getInformation());
    }
}
