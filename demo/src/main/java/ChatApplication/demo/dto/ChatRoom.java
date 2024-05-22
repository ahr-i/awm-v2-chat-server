package ChatApplication.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChatRoom {
    private int roomId; // 채팅방 고유 식별자

    @Builder
    public static ChatRoom create(int locationId){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = locationId;

        return chatRoom;
    }
}
