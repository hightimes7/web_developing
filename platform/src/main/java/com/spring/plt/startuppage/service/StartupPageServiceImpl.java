package com.spring.plt.startuppage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.dao.StartupPageDAO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Service("startupPageService")
public class StartupPageServiceImpl implements StartupPageService{
	@Autowired
	private StartupPageDAO startuppagedao;

	
	public int deleteesti(int no) throws Exception{
		return startuppagedao.deleteesti(no); 
	}
	public int deletecon(int no) throws Exception{
		return startuppagedao.deletecon(no); 
	}
	
	public List<StartupPageVO> listesti(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> estilist = null;
		estilist = startuppagedao.selectAllEstiList(pagevo,compId);
		return estilist; 
	}
	public List<StartupPageVO> w_listesti(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> w_estilist = null;
		w_estilist = startuppagedao.selectWaitEstiList(pagevo,compId);
		return w_estilist;
	}
	public List<StartupPageVO> c_listesti(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> c_estilist = null;
		c_estilist = startuppagedao.selectComEstiList(pagevo,compId);
		return c_estilist;
	}
	public List<StartupPageVO> i_listesti(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> i_estilist = null;
		i_estilist = startuppagedao.selectIngEstiList(pagevo,compId);
		return i_estilist;
	}
	public List<StartupPageVO> d_listesti(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> d_estilist = null;
		d_estilist = startuppagedao.selectDeEstiList(pagevo,compId);
		return d_estilist;
	}
	
	
	
	
	public int listCount() throws DataAccessException{
		return startuppagedao.listCount();
	}
	public int estilistCount_i(String compId) throws Exception{
		return startuppagedao.estilistCount_i(compId);
	}
	public int estilistCount_w(String compId) throws Exception{
		int result = startuppagedao.estilistCount_w(compId);
		System.out.println("service count : " + result);
		return result;
	}
	public int estilistCount_d(String compId) throws Exception{
		return startuppagedao.estilistCount_d(compId);
	}
	public int estilistCount_c(String compId) throws Exception{
		return startuppagedao.estilistCount_c(compId);
	}
	
	
	
	public List<StartupPageVO> listprod(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> prodlist = null;
		prodlist = startuppagedao.selectAllProdList(pagevo,compId);
		return prodlist;
	}
	
	
	
	
	public List<StartupPageVO> listcon(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> conlist = null;
		conlist = startuppagedao.selectAllConList(pagevo, compId);
		return conlist;
	}
	public List<StartupPageVO> w_listcon(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> w_conlist = null;
		w_conlist = startuppagedao.selectWaitConList(pagevo, compId);
		return w_conlist;
	}
	public List<StartupPageVO> d_listcon(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> d_conlist = null;
		d_conlist = startuppagedao.selectDeConList(pagevo, compId);
		return d_conlist;
	}
	public List<StartupPageVO> c_listcon(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> c_conlist = null;
		c_conlist = startuppagedao.selectComConList(pagevo, compId);
		return c_conlist;
	}
	public List<StartupPageVO> i_listcon(PageVO pagevo,String compId) throws DataAccessException{
		List<StartupPageVO> i_conlist = null;
		i_conlist = startuppagedao.selectIngConList(pagevo, compId);
		
		return i_conlist;
	}
	
	
	
	
	
	public int conlistCount_i(String compId) throws Exception{
		return startuppagedao.conlistCount_i(compId);
	}
	public int conlistCount_w(String compId) throws Exception{
		return startuppagedao.conlistCount_w(compId);
	}
	public int conlistCount_d(String compId) throws Exception{
		return startuppagedao.conlistCount_d(compId);
	}
	public int conlistCount_c(String compId) throws Exception{
		return startuppagedao.conlistCount_c(compId);
	}
	
	
	
	public int status_y(int status, int no)throws Exception{
		return startuppagedao.status_y(status, no);
	}
	public int status_n(int status, int no)throws Exception{
		return startuppagedao.status_n(status, no);
	}
	public int constatus_y(int status, int no)throws Exception{
		return startuppagedao.constatus_y(status, no);
	}
	public int constatus_n(int status, int no)throws Exception{
		return startuppagedao.constatus_n(status, no);
	}
	
	
}
