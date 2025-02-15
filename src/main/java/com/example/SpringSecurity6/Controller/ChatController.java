package com.example.SpringSecurity6.Controller;

import com.example.SpringSecurity6.Model.ChatMessage;
import com.example.SpringSecurity6.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.*;

import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat/{recipient}")
    @SendToUser("/queue/{recipient}")
    public ChatMessage sendPrivateMessage(@DestinationVariable String recipient, ChatMessage message) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        message.setSender(auth.getName());
        message.setRecipient(recipient);
        return message;
    }

}

