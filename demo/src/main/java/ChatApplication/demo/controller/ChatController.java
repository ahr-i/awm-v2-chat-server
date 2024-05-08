package ChatApplication.demo.controller;

import ChatApplication.demo.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;

    // MessageMapping 을 통해 webSocket 로 들어오는 메시지를 발신 처리한다.
    // 여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에서 적용한건 앞에 생략
    // "/pub/chat/message"
    @MessageMapping(value = "/chat/message")
    public void enter(@Payload ChatMessage chatMessage) {
        log.info("chat message log : " +
                chatMessage.getNickName() + " " +
                chatMessage.getMessage() + " " +
                chatMessage.getTimestamp());
        messagingTemplate.convertAndSend("/sub/chat/room", chatMessage);
    }
}
