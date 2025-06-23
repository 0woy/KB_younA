package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.GreetingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
public class ChatController {
    @MessageMapping("/hello")   // 클라이언트가 보낸 메세지의 경로 (/app/hello)와 일치하는 경우 메서드 호출
    @SendTo("/topic/greetings") // 해당 메서드의 리턴 값 (message)를 지정 토픽으로 전송
    public GreetingMessage greeting(GreetingMessage message) throws Exception {
        log.info("greeting: "+message);
        return message;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public ChatMessage chat(ChatMessage message) throws Exception {
        log.info("chat received "+message);
        return message;
    }
}
