package com.example.chat.Dto.ChatDto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRoom {
    private String roomId;
    private String name;

    @Builder
    public static ChatRoom create(String locationId){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = locationId;
        chatRoom.name = "NONE";

        return chatRoom;
    }
}
