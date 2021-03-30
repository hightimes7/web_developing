package com.spring.plt.find.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.find.vo.FindVO;

@Repository("findDAO")
public class FindDAOImpl implements FindDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public FindVO findId(FindVO findVO) throws DataAccessException {
		FindVO vo = sqlSession.selectOne("mapper.find.showId", findVO);
		return vo;
	}

	@Override
	public FindVO findPwd(FindVO findVO) throws DataAccessException {
		FindVO vo = sqlSession.selectOne("mapper.find.findPwd", findVO);
		return vo;
	}

}
