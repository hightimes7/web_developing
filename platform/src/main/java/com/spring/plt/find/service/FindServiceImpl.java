package com.spring.plt.find.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.find.dao.FindDAO;
import com.spring.plt.find.vo.FindVO;

@Service("findService")
public class FindServiceImpl implements FindService{
	
	@Autowired
	private FindDAO findDAO;

	@Override
	public FindVO findId(FindVO findVO) throws DataAccessException {
		
		return findDAO.findId(findVO);
	}

	@Override
	public FindVO findPwd(FindVO findVO) throws DataAccessException {
		
		return findDAO.findPwd(findVO);
	}
	
	
}
