package com.jade.sbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.jade.sbp.domain.Message;

@Controller
public class StompController {
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@MessageMapping("/TTTx")
	@SendTo("/topic/message")
	public String tttx(String message) throws Exception {
		System.out.println("TTT>>" + message);
		return message;
	}
	
	@MessageMapping("/TTT")
//	@SendTo("/topic/message")
	public Message ttt(Message message) throws Exception {
		System.out.println("TTT>>" + message);
		System.out.println("ID=" + message.getId());
		System.out.println("MSG=" + message.getMsg());
		
		messagingTemplate.convertAndSend("/topic/" + message.getRoomid(), message.getMsg());
//		messagingTemplate.convertAndSendToUser(message.getId(), "/topic/" + message.getRoomid(), message.getMsg());
		 
		 
		return message;
	}
}
