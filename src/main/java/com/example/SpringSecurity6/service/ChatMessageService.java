package com.example.SpringSecurity6.service;

import com.example.SpringSecurity6.Model.ChatMessage;
import com.example.SpringSecurity6.Repo.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;


    public ChatMessage saveMessage(String senderId, String receiverId, String content) {
        ChatMessage message = ChatMessage.builder()
                .sender(senderId)
                .recipient(receiverId)
                .content(content)
                .timestamp(LocalDateTime.now())
                .build();
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getChatHistory(String senderId, String receiverId) {
        return chatMessageRepository.findBySenderAndRecipientOrRecipientAndSenderOrderByTimestamp(
                senderId, receiverId, senderId, receiverId);
    }
}
