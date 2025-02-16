package com.example.SpringSecurity6.Repo;


import com.example.SpringSecurity6.Model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findBySenderAndRecipientOrRecipientAndSenderOrderByTimestamp(
            String senderId, String receiverId, String receiverId2, String senderId2);
}
