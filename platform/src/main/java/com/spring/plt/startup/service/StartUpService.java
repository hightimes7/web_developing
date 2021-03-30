package com.spring.plt.startup.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.startup.vo.StartUpVO;

public interface StartUpService {
	public StartUpVO login(StartUpVO startUpVO) throws DataAccessException, Exception;
	public int join_startup(Map compMap) throws Exception;
	public List<StartUpVO> startUpList() throws Exception;
	public int deletestartUp(String id) throws DataAccessException;
	public int updatestartUp(Map compMap) throws Exception;
	public StartUpVO startUpselect(String id) throws Exception;
	public int overlapCheck(String id) throws Exception;
}
