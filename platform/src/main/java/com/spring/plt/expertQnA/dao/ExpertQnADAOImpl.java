package com.spring.plt.expertQnA.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.expertQnA.vo.ExpertQnAVO;


@Repository("expertQnADAO")
public class ExpertQnADAOImpl implements ExpertQnADAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<ExpertQnAVO> getList(String expId) throws Exception{
		List<ExpertQnAVO> expertQnAList = sqlSession.selectList("mapper.expertQnA.getList", expId);
		return expertQnAList;
	}
	
	public int addQue(ExpertQnAVO expertQnAVO) throws Exception{
		return sqlSession.insert("mapper.expertQnA.addQnA", expertQnAVO);
	}
	
	public int addAnswer(ExpertQnAVO expertQnAVO) throws Exception{
		return sqlSession.insert("mapper.expertQnA.addQnA", expertQnAVO);
	}
	
	public int modExpertQnA(Map<String, Object> qnaMap) throws Exception{
		return sqlSession.update("mapper.expertQnA.modExpertQnA", qnaMap);
	}
	
	public int delExpertQnA(int no) throws Exception{
		return sqlSession.delete("mapper.expertQnA.delExpertQnA", no);
	}
}
