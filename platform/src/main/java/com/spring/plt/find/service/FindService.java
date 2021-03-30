package com.spring.plt.find.service;

import org.springframework.dao.DataAccessException;

import com.spring.plt.find.vo.FindVO;

public interface FindService {
	public FindVO findId(FindVO findVO) throws DataAccessException;
	public FindVO findPwd(FindVO findVO) throws DataAccessException;
}
