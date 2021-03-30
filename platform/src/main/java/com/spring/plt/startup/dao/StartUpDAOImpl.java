package com.spring.plt.startup.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.startup.vo.StartUpVO;

@Repository("startUpDAO")
public class StartUpDAOImpl implements StartUpDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public StartUpVO loginById(StartUpVO startUpVO) throws DataAccessException {
		StartUpVO vo = sqlSession.selectOne("mapper.startup.loginById", startUpVO);
		return vo;
	}
	
	public int join_startup(Map compMap) throws DataAccessException{
		System.out.println("dao: "+compMap);
		int result = sqlSession.insert("mapper.startup.join_startup", compMap);
		return result;
	}

	@Override
	public List<StartUpVO> startUpList() throws DataAccessException {
		List<StartUpVO> startUpList = sqlSession.selectList("mapper.startup.startUpList");
		return startUpList;
	}

	@Override
	public int deletestartUp(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.startup.deletestartUp", id);
		return result;
	}

	public int updatestartUp(Map compMap) throws Exception{
		System.out.println("DAO: "+compMap);
		return sqlSession.update("mapper.startup.updatestartUp", compMap);
	}

	@Override
	public StartUpVO startUpselect(String id) throws DataAccessException {
		StartUpVO startUpselect = sqlSession.selectOne("mapper.startup.startUpselect", id);
		return startUpselect;
	}
	
	public void insertstartEdit(StartUpVO startup) throws Exception{
	      sqlSession.insert("mapper.startup.insertstartEdit", startup);
	}
	
	public void insertLoginLog(StartUpVO startup) throws Exception{
		sqlSession.insert("mapper.startup.insertLoginLog", startup);
	}
	
	public int overlapCheck(String id) throws Exception{
		int count = 0;
		count = sqlSession.selectOne("mapper.startup.overlapCheck", id);
		return count;
	}
	
}
