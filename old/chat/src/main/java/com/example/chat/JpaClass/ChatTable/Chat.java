package com.example.chat.JpaClass.ChatTable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatId;
    @Column
    private String sender;
    @Column
    private String receiver;
    @Column
    private String comment;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
