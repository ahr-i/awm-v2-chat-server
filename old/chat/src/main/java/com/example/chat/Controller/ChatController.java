package com.example.chat.Controller;

import com.example.chat.Dto.ChatDto.ChatMessage;
import com.example.chat.JpaClass.ChatTable.Chat;
import com.example.chat.Service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequiredArgsConstructor
@Log4j2
public class ChatController {
    private final ChatService chatService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat/message")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        try {
            String roomId = chatMessage.getRoomId();
            Thread.sleep(500);

            messagingTemplate.convertAndSend("/topic/chat/room/" + roomId, chatMessage);
            log.info("Message [{}] send by member: {} to chatting room: {}", chatMessage.getMessage(),
                    chatMessage.getNickName(),
                    chatMessage.getRoomId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/messages")
    public List<Chat> getAllMessage(){return chatService.getAllMessages();}

    @PostMapping("/send")
    public void send(@RequestBody ChatMessage message){
        messagingTemplate.convertAndSend("/send/room", message);
    }
}
