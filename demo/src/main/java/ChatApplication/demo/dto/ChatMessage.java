package ChatApplication.demo.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChatMessage {
    private int roomId; // 채팅방 ID
    private String nickName; // 발신자 닉네임
    private String message; // 메시지
    private LocalDateTime timestamp; // 발신시간
}
