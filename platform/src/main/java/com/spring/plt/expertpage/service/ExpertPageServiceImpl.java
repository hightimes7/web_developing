package com.spring.plt.expertpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.expertpage.dao.ExpertPageDAO;
import com.spring.plt.expertpage.vo.ExpertPageVO;
import com.spring.plt.page.vo.PageVO;

@Service("expertPageService")
public class ExpertPageServiceImpl implements ExpertPageService{
	@Autowired 
	private ExpertPageDAO dao;
	
	public int listCount() throws Exception{
		System.out.println("service의 listCount()");
		int result = dao.listCount();
		System.out.println("service에서 result 출력"+result);
		return result;
	}
	public int listCount_i(String expId) throws Exception{
		return dao.listCount_i(expId);
	}
	public int listCount_w(String expId) throws Exception{
		return dao.listCount_w(expId);
	}
	public int listCount_d(String expId) throws Exception{
		return dao.listCount_d(expId);
	}
	public int listCount_c(String expId) throws Exception{
		return dao.listCount_c(expId);
	}
	
	
	public List<ExpertPageVO> w_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ExpertPageVO> w_conlist = null;
		w_conlist = dao.selectWaitEstiList(pagevo, expId);
		System.out.println("service" + w_conlist);
		return w_conlist;
	}
	public List<ExpertPageVO> i_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ExpertPageVO> i_conlist = null;
		i_conlist = dao.selectIngEstiList(pagevo, expId);
		System.out.println("service" + i_conlist);
		return i_conlist;
	}
	public List<ExpertPageVO> c_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ExpertPageVO> c_conlist = null;
		c_conlist = dao.selectComEstiList(pagevo, expId);
		System.out.println("service" + c_conlist);
		return c_conlist;
	}
	public List<ExpertPageVO> d_listcon(PageVO pagevo, String expId) throws DataAccessException{
		List<ExpertPageVO> d_conlist = null;
		d_conlist = dao.selectDeEstiList(pagevo, expId);
		System.out.println("service" + d_conlist);
		return d_conlist;
	}
//	public List<ExpertPageVO> listcon(PageVO pagevo, String expId) throws DataAccessException{
//		List<ExpertPageVO> conlist = null;
//		conlist = dao.selectAllEstiList(pagevo, expId);
//		System.out.println("service" + conlist);
//		return conlist;
//	}
	public int deleteesti(int no) throws Exception{
		return dao.deleteesti(no);
	}
	public int status_y(int status, int no)throws Exception{
		return dao.status_y(status, no);
	}
	public int status_n(int status, int no)throws Exception{
		return dao.status_n(status, no);
	}
}
