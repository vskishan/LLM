package com.example.llm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.llm.model.PersonInfo;
import com.example.llm.model.UserInput;
import com.example.llm.service.AIAssistant;

@RestController
public class ChatController {

    @Autowired
    private AIAssistant assistant;
    
    @PostMapping("/api/chat")
    public String getChat(@RequestBody UserInput userInput) {
        PersonInfo info = assistant.chat(userInput.getMessage());
        return "Giving info related to " + info;
    }

}
