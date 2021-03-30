package com.spring.plt.manufac.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufac.vo.ManufacVO;

public interface ManufacService {
	public ManufacVO login(ManufacVO manufacVO) throws DataAccessException, Exception;
	public int join_manufac(Map manufacMap) throws Exception;
	public List<ManufacVO> manufacList() throws Exception;
	public ManufacVO manufacselect(String id) throws Exception;
	public int deletemanufac(String id) throws Exception;
	public int updatemanufac(Map<String, Object> manufacMap);
	public int overlapCheck(String id) throws Exception;
}
