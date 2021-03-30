package com.spring.plt.expertQnA.service;

import java.util.List;
import java.util.Map;

import com.spring.plt.expertQnA.vo.ExpertQnAVO;

public interface ExpertQnAService {
	public List<ExpertQnAVO> getList(String expId) throws Exception;
	public int addQue(ExpertQnAVO expertQnAVO) throws Exception;
	public int addAnswer(ExpertQnAVO expertQnAVO) throws Exception;
	public int modExpertQnA(Map<String, Object> qnaMap) throws Exception;
	public int delExpertQnA(int no) throws Exception;
}
