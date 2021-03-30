package com.spring.plt.expertpage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expertpage.vo.ExpertPageVO;
import com.spring.plt.page.vo.PageVO;

public interface ExpertPageDAO {
	public int listCount() throws Exception;
	public int listCount_i(String expId) throws Exception;
	public int listCount_w(String expId) throws Exception;
	public int listCount_c(String expId) throws Exception;
	public int listCount_d(String expId) throws Exception;
//	public List<ExpertPageVO> selectAllEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public int deleteesti(int no) throws DataAccessException;
	public List<ExpertPageVO> selectWaitEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public List<ExpertPageVO> selectIngEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public List<ExpertPageVO> selectComEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public List<ExpertPageVO> selectDeEstiList(PageVO pagevo, String expId) throws DataAccessException;
	public int status_y(int status, int no)throws DataAccessException;
	public int status_n(int status, int no) throws DataAccessException;
}
