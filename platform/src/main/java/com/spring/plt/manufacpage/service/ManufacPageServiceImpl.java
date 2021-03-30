package com.spring.plt.manufacpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.manufacpage.dao.ManufacPageDAO;
import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

@Service("manufacPageService")
public class ManufacPageServiceImpl implements ManufacPageService{
	@Autowired
	private ManufacPageDAO manufacdao;
	
	public List<ManufacPageVO> listesti(PageVO pagevo, String manuId) throws DataAccessException{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectAllEstiList(pagevo,manuId);
		return estilist;
	}
	public List<ManufacPageVO> w_estiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectWaitingEstiList(pagevo,manuId);
		return estilist;
	}
	public List<ManufacPageVO> i_estiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectIngEstiList(pagevo,manuId);
		return estilist;
	}
	public List<ManufacPageVO> c_estiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectComEstiList(pagevo,manuId);
		return estilist;
	}
	public List<ManufacPageVO> d_estiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estilist = null;
		estilist = manufacdao.selectDeEstiList(pagevo,manuId);
		return estilist;
	}
	public int listCount() throws DataAccessException{
		return manufacdao.listCount();
	}
	
	public int deleteesti(int no) throws Exception {
		return manufacdao.deleteesti(no);
	}
	public int updatestatus(int quotestatus, int no)throws DataAccessException{
		return manufacdao.quotestatus(quotestatus,no);
	}
	public int updatestatus_de(int quotestatus, int no)throws DataAccessException{
		return manufacdao.quotestatus_de(quotestatus,no);
	}
	public int listCount_i(String manuId) throws Exception{
		return manufacdao.estilistCount_i(manuId);
	}
	public int listCount_w(String manuId) throws Exception{
		return manufacdao.estilistCount_w(manuId);
	}
	public int listCount_d(String manuId) throws Exception{
		return manufacdao.estilistCount_d(manuId);
	}
	public int listCount_c(String manuId) throws Exception{
		return manufacdao.estilistCount_c(manuId);
	}


}
