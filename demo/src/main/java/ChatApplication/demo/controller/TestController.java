package ChatApplication.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test/chat")
    public String testChat(){
        return "forward:/chat.html"; // HTML 파일의 경로를 반환
    }
}
