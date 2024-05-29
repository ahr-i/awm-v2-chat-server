package com.example.chat.Controller;

import com.example.chat.Dto.ChatDto.ChatRoom;
import com.example.chat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;

    @GetMapping("/room")
    @ResponseBody
    public ResponseEntity rooms(Model model){
        log.info("Chat List");
        return ResponseEntity.ok().body("Chat List Screen");
    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }

    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String roomId){
        return chatService.createRoom(roomId);
    }

    @GetMapping("/room/enter/{roomId}")
    @ResponseBody
    public ResponseEntity<?> roomDetail(Model model, @PathVariable String roomId) {
        ChatRoom findChatRoom = chatService.findRoomById(roomId);

        if (findChatRoom == null) {
            return ResponseEntity.badRequest().body("Chat room does not exist");
        }

        model.addAttribute("roomId", roomId);
        return ResponseEntity.ok().body("Enter Chat Room");
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ResponseEntity roomInfo(@PathVariable String roomId){
        ChatRoom findChatRoom = chatService.findRoomById(roomId);
        if(findChatRoom == null)
            return ResponseEntity.badRequest().body("Cannot find the chat room");
        return ResponseEntity.ok(findChatRoom);
    }
}
