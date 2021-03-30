package com.spring.plt.expertQnA.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.expertQnA.dao.ExpertQnADAO;
import com.spring.plt.expertQnA.vo.ExpertQnAVO;

@Service("expertQnAService")
public class ExpertQnAServiceImpl implements ExpertQnAService{
	@Autowired
	private ExpertQnADAO expertQnADAO;
	
	public List<ExpertQnAVO> getList(String expId) throws Exception{
		List<ExpertQnAVO> expertQnAList = expertQnADAO.getList(expId);
		return expertQnAList;
	}
	
	public int addQue(ExpertQnAVO expertQnAVO) throws Exception{
		return expertQnADAO.addQue(expertQnAVO);
	}
	
	public int addAnswer(ExpertQnAVO expertQnAVO) throws Exception{
		return expertQnADAO.addAnswer(expertQnAVO);
	}
	
	public int modExpertQnA(Map<String, Object> qnaMap) throws Exception{
		return expertQnADAO.modExpertQnA(qnaMap);
	}
	
	public int delExpertQnA(int no) throws Exception{
		return expertQnADAO.delExpertQnA(no);
	}
}
