package com.example.chat.monitor;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class Setting {
    private final String monitor;
    private final String serverPort;
    private final String serviceName;

    public Setting() {
        monitor = "http://127.0.0.1:9080/service/register";
        serverPort = "9005";
        serviceName = "chat_server";
    }
}
