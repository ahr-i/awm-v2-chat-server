package com.example.chat.Repository.ChatRepository;

import com.example.chat.JpaClass.ChatTable.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<Chat, Integer> {
}
