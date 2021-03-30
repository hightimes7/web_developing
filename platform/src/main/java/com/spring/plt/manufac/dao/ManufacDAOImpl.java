package com.spring.plt.manufac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.manufac.vo.ManufacVO;
import com.spring.plt.startup.vo.StartUpVO;

@Repository("ManufacDAO")
public class ManufacDAOImpl implements ManufacDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ManufacVO loginById(ManufacVO manufacVO) throws DataAccessException {
		ManufacVO vo = sqlSession.selectOne("mapper.manufac.loginById", manufacVO); 
		return vo;
	}
		
	public int join_manufac(Map manufacMap) throws DataAccessException{
		System.out.println("dao: "+manufacMap);
		int result = sqlSession.insert("mapper.manufac.join_manufac", manufacMap);
		return result;
	}

	@Override
	public List<ManufacVO> manufacList() throws DataAccessException {
		List<ManufacVO> manufacList = sqlSession.selectList("mapper.manufac.manufacList");
		System.out.println("dao: "+manufacList);
		return manufacList;
	}

	@Override
	public ManufacVO manufacselect(String id) throws DataAccessException {
		ManufacVO manufacselect = sqlSession.selectOne("mapper.manufac.manufacselect", id);
		return manufacselect;
	}

	@Override
	public int deletemanufac(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.manufac.deletemanufac",id);
		return result;
	}

	public int updatemanufac(Map<String, Object> manufacMap) {
		System.out.println("updatedao: "+manufacMap);
		return sqlSession.update("mapper.manufac.updatemanufac", manufacMap);
	}
	
	public void insertmanuEdit(ManufacVO manufac) throws Exception{
	      sqlSession.insert("mapper.manufac.insertmanuEdit", manufac);
	}
	
	public void insertLoginLog(ManufacVO manufac) throws Exception{
	      sqlSession.insert("mapper.manufac.insertLoginLog", manufac);
	}
	
	public int overlapCheck(String id) throws Exception{
		int count = 0;
		count = sqlSession.selectOne("mapper.startup.overlapCheck", id);
		return count;
	}
	
}
