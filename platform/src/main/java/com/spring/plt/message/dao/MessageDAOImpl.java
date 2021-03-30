package com.spring.plt.message.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.message.vo.MessageVO;

@Repository("messageDAO")
public class MessageDAOImpl implements MessageDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public int sendMessage(MessageVO message) throws Exception{
		int result = sqlSession.insert("mapper.message.sendMessage", message);
		return result;
	}
	
	public List<MessageVO> messageList(String id) throws Exception{
		List<MessageVO> list = sqlSession.selectList("mapper.message.messageList", id);
		return list;
	}
	
	public int deleteSendMessage(int messageNO) throws Exception{
		int result = sqlSession.update("mapper.message.deleteSendMessage", messageNO);
		return result;
	}
	
	public int deleteReceiveMessage(int messageNO) throws Exception{
		int result = sqlSession.update("mapper.message.deleteReceiveMessage", messageNO);
		return result;
	}
	
	public MessageVO readMessage(int messageNO) throws Exception{
		return sqlSession.selectOne("mapper.message.readMessage", messageNO);
	}
	
	public void updateSeRead(int messageNO) throws Exception{
		sqlSession.update("mapper.message.updateSeRead", messageNO);
	}
	
	public void updateReRead(int messageNO) throws Exception{
		sqlSession.update("mapper.message.updateReRead", messageNO);
	}
	
	public List<MessageVO> searchMessage(Map<String, String> searchMap) throws Exception{
		return sqlSession.selectList("mapper.message.searchMessage", searchMap);
	}
	
	public int unReadCount(String id) throws Exception{
		return sqlSession.selectOne("mapper.message.unReadCount", id);
	}
}
