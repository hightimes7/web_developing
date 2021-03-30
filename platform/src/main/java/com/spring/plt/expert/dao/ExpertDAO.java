package com.spring.plt.expert.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;

public interface ExpertDAO {
	public ExpertVO loginById(ExpertVO expertVO) throws DataAccessException;
	public int join_expert(Map expertMap) throws Exception;
	public List<ExpertVO> expertList() throws DataAccessException;
	public int deleteexpert(String id) throws DataAccessException;
	public int updateexpert(Map<String, Object> expMap) throws Exception;
	public void updateExpImage(Map expMap) throws Exception;
	public ExpertVO expertselect(String id) throws DataAccessException;
	public void insertExpImage(Map expertMap) throws DataAccessException;
	public List<ExpImageVO> selectImageFileList(String id) throws Exception;
	public void insertExpEdit(ExpertVO expert) throws Exception;
	public void insertLoginLog(ExpertVO expertVO) throws Exception;
	public int overlapCheck(String id) throws Exception;
}
