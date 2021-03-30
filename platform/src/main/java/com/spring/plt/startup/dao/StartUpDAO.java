package com.spring.plt.startup.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.startup.vo.StartUpVO;

public interface StartUpDAO {
	public StartUpVO loginById(StartUpVO startUpVO) throws DataAccessException;
	public int join_startup(Map compMap) throws DataAccessException;
	public List<StartUpVO> startUpList() throws DataAccessException;
	public int deletestartUp(String id) throws DataAccessException;
	public StartUpVO startUpselect(String id) throws DataAccessException;
	public int updatestartUp(Map compMap) throws Exception;
	public void insertstartEdit(StartUpVO startup) throws Exception;
	public void insertLoginLog(StartUpVO startUpVO) throws Exception;
	public int overlapCheck(String id) throws Exception;
}



