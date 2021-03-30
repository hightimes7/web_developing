package com.spring.plt.startuppage.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

public interface StartupPageService {
	public int deleteesti(int no) throws Exception;
	public int deletecon(int no) throws Exception;
	
	public List<StartupPageVO> listesti(PageVO pagevo, String compId) throws DataAccessException;  
	public int listCount() throws DataAccessException;
	public List<StartupPageVO> listprod(PageVO pagevo, String compId) throws DataAccessException;
	public List<StartupPageVO> listcon(PageVO pagevo, String compId) throws DataAccessException;
	
	public int estilistCount_i(String compId) throws Exception;
	public int estilistCount_w(String compId) throws Exception;
	public int estilistCount_c( String compId) throws Exception;
	public int estilistCount_d(String compId) throws Exception;
	
	public List<StartupPageVO> w_listesti(PageVO pagevo, String compId) throws DataAccessException; 
	public List<StartupPageVO> c_listesti(PageVO pagevo, String compId) throws DataAccessException; 
	public List<StartupPageVO> i_listesti(PageVO pagevo, String compId) throws DataAccessException; 
	public List<StartupPageVO> d_listesti(PageVO pagevo, String compId) throws DataAccessException; 
	
	
	
	public int status_y(int status, int no)throws Exception;
	public int status_n(int status, int no)throws Exception;
	public int constatus_n(int status, int no)throws Exception;
	public int constatus_y(int status, int no)throws Exception;
	
	
	public List<StartupPageVO> i_listcon(PageVO pagevo, String compId) throws DataAccessException;
	public List<StartupPageVO> c_listcon(PageVO pagevo, String compId) throws DataAccessException;
	public List<StartupPageVO> w_listcon(PageVO pagevo, String compId) throws DataAccessException;
	public List<StartupPageVO> d_listcon(PageVO pagevo, String compId) throws DataAccessException;
	
	
	public int conlistCount_i(String compId) throws Exception;
	public int conlistCount_c(String compId) throws Exception;
	public int conlistCount_w(String compId) throws Exception;
	public int conlistCount_d(String compId) throws Exception;
}
