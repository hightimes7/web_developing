package com.spring.plt.message.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.message.dao.MessageDAO;
import com.spring.plt.message.vo.MessageVO;

@Service("messageService")
public class MessageServiceImpl implements MessageService{
	@Autowired
	private MessageDAO messageDAO;
	
	public int sendMessage(MessageVO message) throws Exception{
		return messageDAO.sendMessage(message);
	}
	
	public List<MessageVO> messageList(String id) throws Exception{
		List<MessageVO> list = messageDAO.messageList(id);
		return list;
	}
	
	public int deleteSendMessage(int messageNO) throws Exception{
		return messageDAO.deleteSendMessage(messageNO);
	}
	
	public int deleteReceiveMessage(int messageNO) throws Exception{
		return messageDAO.deleteReceiveMessage(messageNO);
	}
	
	public MessageVO readSendMessage(int messageNO) throws Exception{
		messageDAO.updateSeRead(messageNO);
		return messageDAO.readMessage(messageNO);
	}
	
	public MessageVO readReceiveMessage(int messageNO) throws Exception{
		messageDAO.updateReRead(messageNO);
		return messageDAO.readMessage(messageNO);
	}
	
	public List<MessageVO> searchMessage(Map<String, String> searchMap) throws Exception{
		return messageDAO.searchMessage(searchMap);
	}
	
	public int unReadCount(String id) throws Exception{
		return messageDAO.unReadCount(id);
	}
}
