package ChatApplication.demo.controller;

import ChatApplication.demo.dto.ChatRoom;
import ChatApplication.demo.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class ChatRoomController {
    private final ChatService chatService;

    // 채팅 리스트
    @GetMapping("/chat/room")
    @ResponseBody
    public ResponseEntity rooms(Model model){
        log.info("채팅 리스트");
        return ResponseEntity.ok().body("채팅 리스트 화면");
    }

    // 모든 채팅방 목록
    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }

    // 채팅방 생성
    @PostMapping("/chat/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam int locationId){
        return chatService.createRoom(locationId);
    }

    // 채팅방 입장
    @GetMapping("/chat/room/enter/{roomId}")
    @ResponseBody
    public ResponseEntity<?> roomDetail(Model model, @PathVariable int locationId) {
        ChatRoom findChatRoom = chatService.findRoomById(locationId);

        if (findChatRoom == null) {
            return ResponseEntity.badRequest().body("채팅방이 존재하지 않음");
        }

        model.addAttribute("roomId", locationId);
        return ResponseEntity.ok().body("채팅방 입장");
    }


    //특정 채팅방 조회
    @GetMapping("/chat/room/{locationId}")
    @ResponseBody
    public ResponseEntity roomInfo(@PathVariable int locationId){
        ChatRoom findChatRoom = chatService.findRoomById(locationId);
        if(findChatRoom == null)
            return ResponseEntity.badRequest().body("해당 채팅방을 찾을수 없음");
        return ResponseEntity.ok(findChatRoom);
    }
}
