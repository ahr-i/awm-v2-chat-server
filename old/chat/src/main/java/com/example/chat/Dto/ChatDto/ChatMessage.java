package com.example.chat.Dto.ChatDto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private String roomId;
    private String nickName;
    private String message;
    private LocalDateTime timestamp;
}
