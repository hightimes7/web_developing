package com.spring.plt.expertpage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expertpage.vo.ExpertPageVO;
import com.spring.plt.page.vo.PageVO;

public interface ExpertPageService {
	public int listCount() throws Exception;
	public int listCount_i(String expId) throws Exception;
	public int listCount_c(String expId) throws Exception;
	public int listCount_w(String expId) throws Exception;
	public int listCount_d(String expId) throws Exception;
	public List<ExpertPageVO> w_listcon(PageVO pagevo, String expId) throws DataAccessException;
	public List<ExpertPageVO> i_listcon(PageVO pagevo, String expId) throws DataAccessException;
	public List<ExpertPageVO> c_listcon(PageVO pagevo, String expId) throws DataAccessException;
	public List<ExpertPageVO> d_listcon(PageVO pagevo, String expId) throws DataAccessException;
//	public List<ExpertPageVO> listcon(PageVO pagevo, String expId) throws DataAccessException;
	public int deleteesti(int no) throws Exception;
	public int status_n(int status, int no)throws Exception;
	public int status_y(int status, int no)throws Exception;
	
}
