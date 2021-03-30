package com.spring.plt.manufacQnA.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.manufacQnA.vo.ManufacQnAVO;


@Repository("manufacQnADAO")
public class ManufacQnADAOImpl implements ManufacQnADAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<ManufacQnAVO> getList(String manuId) throws Exception{
		List<ManufacQnAVO> manufacQnAList = sqlSession.selectList("mapper.manufacQnA.getList", manuId);
		return manufacQnAList;
	}
	
	public int addQue(ManufacQnAVO manufacQnAVO) throws Exception{
		return sqlSession.insert("mapper.manufacQnA.addQnA", manufacQnAVO);
	}
	
	public int addAnswer(ManufacQnAVO manufacQnAVO) throws Exception{
		return sqlSession.insert("mapper.manufacQnA.addQnA", manufacQnAVO);
	}
	
	public int modManufacQnA(Map<String, Object> proMap) throws Exception{
		return sqlSession.update("mapper.manufacQnA.modManufacQnA", proMap);
	}
	
	public int delManufacQnA(int articleNO) throws Exception{
		return sqlSession.delete("mapper.manufacQnA.delManufacQnA", articleNO);
	}
}
