package com.spring.plt.manufacpage.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

public interface ManufacPageDAO {
	public int listCount() throws DataAccessException;
	public List<ManufacPageVO> selectAllEstiList(PageVO pagevo,String manuId) throws DataAccessException;
	public List<ManufacPageVO> selectWaitingEstiList(PageVO pagevo,String manuId) throws Exception;
	public List<ManufacPageVO> selectIngEstiList(PageVO pagevo,String manuId) throws Exception;
	public List<ManufacPageVO> selectComEstiList(PageVO pagevo,String manuId) throws Exception;
	public List<ManufacPageVO> selectDeEstiList(PageVO pagevo,String manuId) throws Exception;
	
	public int deleteesti(int no) throws DataAccessException;
	public int quotestatus(int quotestatus, int no) throws DataAccessException;
	public int quotestatus_de(int quotestatus, int no) throws DataAccessException;
	public int estilistCount_i(String manuId) throws Exception;
	public int estilistCount_w(String manuId) throws Exception;
	public int estilistCount_c(String manuId) throws Exception;
	public int estilistCount_d(String manuId) throws Exception;
}
