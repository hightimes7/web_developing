package com.spring.plt.manufacpage.service;

import java.util.List;

import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

public interface ManufacPageService {
	public int listCount();

	public List<ManufacPageVO> listesti(PageVO pagevo,String manuId);

	

	public int deleteesti(int no) throws Exception;

	public int updatestatus(int quotestatus, int no);

	public int updatestatus_de(int quotestatus, int no);

	public List<ManufacPageVO> w_estiList(PageVO pagevo,String manuId) throws Exception;
	public List<ManufacPageVO> i_estiList(PageVO pagevo,String manuId) throws Exception;
	public List<ManufacPageVO> c_estiList(PageVO pagevo,String manuId) throws Exception;
	public List<ManufacPageVO> d_estiList(PageVO pagevo,String manuId) throws Exception;

	
	public int listCount_d(String manuId) throws Exception;
	public int listCount_i(String manuId) throws Exception;
	public int listCount_w(String manuId) throws Exception;
	public int listCount_c(String manuId) throws Exception;
}
