package com.example.chat.Service;

import com.example.chat.Dto.ChatDto.ChatRoom;
import com.example.chat.JpaClass.ChatTable.Chat;
import com.example.chat.Repository.ChatRepository.ChatMessageRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {
    private Map<String, ChatRoom> chatRooms;
    private ChatMessageRepository chatMessageRepository;

    @PostConstruct
    private void init(){chatRooms = new LinkedHashMap<>();}

    public List<ChatRoom> findAllRoom(){
        return new ArrayList<>(chatRooms.values());
    }

    public ChatRoom findRoomById(String roomId){
        return chatRooms.get(roomId);
    }

    public ChatRoom createRoom(String locationId){
        ChatRoom chatRoom = new ChatRoom().create(locationId);
        chatRooms.put(locationId, chatRoom);
        return chatRoom;
    }

    public List<Chat> getAllMessages(){
        return chatMessageRepository.findAll();
    }

    public void saveMessage(Chat message){
        chatMessageRepository.save(message);
    }
}
