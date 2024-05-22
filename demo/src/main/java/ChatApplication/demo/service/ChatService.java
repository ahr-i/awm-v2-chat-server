package ChatApplication.demo.service;

import ChatApplication.demo.dto.ChatRoom;
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
    // 채팅방 정보를 담은 맵
    private Map<Integer, ChatRoom> chatRooms;

    // 초기화 메소드
    @PostConstruct
    private void init(){chatRooms = new LinkedHashMap<>();}

    // 모든 채팅방 조회
    public List<ChatRoom> findAllRoom(){
        return new ArrayList<>(chatRooms.values());
    }

    // 특정 채팅방 ID로 채팅방 조회
    public ChatRoom findRoomById(int roomId){
        return chatRooms.get(roomId);
    }

    // 채팅방 생성
    public ChatRoom createRoom(int locationId){
        ChatRoom chatRoom = new ChatRoom().create(locationId);
        chatRooms.put(locationId, chatRoom);
        return chatRoom;
    }
}
