package com.spring.plt.message.dao;

import java.util.List;
import java.util.Map;

import com.spring.plt.message.vo.MessageVO;

public interface MessageDAO {
	public int sendMessage(MessageVO message) throws Exception;
	public List<MessageVO> messageList(String id) throws Exception;
	public int deleteSendMessage(int messageNO) throws Exception;
	public int deleteReceiveMessage(int messageNO) throws Exception;
	public MessageVO readMessage(int messageNO) throws Exception;
	public void updateSeRead(int messageNO) throws Exception;
	public void updateReRead(int messageNO) throws Exception;
	public List<MessageVO> searchMessage(Map<String, String> searchMap) throws Exception;
	public int unReadCount(String id) throws Exception;
}
