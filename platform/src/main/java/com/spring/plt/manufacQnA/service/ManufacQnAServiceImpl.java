package com.spring.plt.manufacQnA.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.manufacQnA.dao.ManufacQnADAO;
import com.spring.plt.manufacQnA.vo.ManufacQnAVO;


@Service("manufacQnAService")
public class ManufacQnAServiceImpl implements ManufacQnAService{
	@Autowired
	private ManufacQnADAO manufacQnADAO;
	
	public List<ManufacQnAVO> getList(String manuId) throws Exception{
		List<ManufacQnAVO> manufacQnAList = manufacQnADAO.getList(manuId);
		return manufacQnAList;
	}
	
	public int addQue(ManufacQnAVO manufacQnAVO) throws Exception{
		return manufacQnADAO.addQue(manufacQnAVO);
	}
	
	public int addAnswer(ManufacQnAVO manufacQnAVO) throws Exception{
		return manufacQnADAO.addAnswer(manufacQnAVO);
	}
	
	public int modManufacQnA(Map<String, Object> proMap) throws Exception{
		return manufacQnADAO.modManufacQnA(proMap);
	}
	
	public int delManufacQnA(int no) throws Exception{
		return manufacQnADAO.delManufacQnA(no);
	}
	
}
