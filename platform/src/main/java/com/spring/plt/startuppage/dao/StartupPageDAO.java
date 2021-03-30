package com.spring.plt.startuppage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

public interface StartupPageDAO {
	List<StartupPageVO> selectAllEstiList(PageVO pagevo, String compId) throws DataAccessException;

	int listCount() throws DataAccessException;

	List<StartupPageVO> selectAllProdList(PageVO pagevo, String compId) throws DataAccessException;

	List<StartupPageVO> selectAllConList(PageVO pagevo, String compId) throws DataAccessException;

	List<StartupPageVO> selectWaitEstiList(PageVO pagevo, String compId) throws DataAccessException;

	List<StartupPageVO> selectIngEstiList(PageVO pagevo, String compId) throws DataAccessException;

	List<StartupPageVO> selectComEstiList(PageVO pagevo, String compId) throws DataAccessException;

	List<StartupPageVO> selectDeEstiList(PageVO pagevo, String compId) throws DataAccessException;

	int deleteesti(int no) throws DataAccessException;
	
	public int status_n(int status, int no) throws DataAccessException;
	public int status_y(int status, int no) throws DataAccessException;

	int estilistCount_i(String compId) throws Exception;
	int estilistCount_w(String compId) throws Exception;
	int estilistCount_d(String compId) throws Exception;
	int estilistCount_c(String compId) throws Exception;

	List<StartupPageVO> selectWaitConList(PageVO pagevo, String compId) throws DataAccessException;
	List<StartupPageVO> selectDeConList(PageVO pagevo, String compId) throws DataAccessException;
	List<StartupPageVO> selectIngConList(PageVO pagevo, String compId) throws DataAccessException;
	List<StartupPageVO> selectComConList(PageVO pagevo, String compId) throws DataAccessException;

	int deletecon(int no) throws DataAccessException;
	
	public int constatus_n(int status, int no) throws DataAccessException;
	public int constatus_y(int status, int no) throws DataAccessException;

	int conlistCount_i(String compId) throws Exception;
	int conlistCount_d(String compId) throws Exception;
	int conlistCount_c(String compId) throws Exception;
	int conlistCount_w(String compId) throws Exception;
}
