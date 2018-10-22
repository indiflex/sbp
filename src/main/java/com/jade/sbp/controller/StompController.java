package com.jade.sbp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.jade.sbp.domain.Message;

@Controller
public class StompController {
	@MessageMapping("/TTTx")
	@SendTo("/topic/message")
	public String tttx(String message) throws Exception {
		System.out.println("TTT>>" + message);
		return message;
	}
	
	@MessageMapping("/TTT")
	@SendTo("/topic/message")
	public Message ttt(Message message) throws Exception {
		System.out.println("TTT>>" + message);
		System.out.println("ID=" + message.getId());
		return message;
	}
}
