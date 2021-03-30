package com.spring.plt.manufacQnA.service;

import java.util.List;
import java.util.Map;

import com.spring.plt.manufacQnA.vo.ManufacQnAVO;

public interface ManufacQnAService {
	public List<ManufacQnAVO> getList(String manuId) throws Exception;
	public int addQue(ManufacQnAVO manufacQnAVO) throws Exception;
	public int addAnswer(ManufacQnAVO manufacQnAVO) throws Exception;
	public int modManufacQnA(Map<String, Object> proMap) throws Exception;
	public int delManufacQnA(int no) throws Exception;
}
