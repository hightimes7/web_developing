package com.spring.plt.startuppage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Repository("startupPageDAO")
public class StartupPageDAOImpl implements StartupPageDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.startuppage.deleteesti", no);
		System.out.println("dao : " + deleteesti);
		return deleteesti;
	}
	@Override
	public int deletecon(int no) throws DataAccessException {
		int deletecon = sqlSession.delete("mapper.startuppage.deletecon", no);
		return deletecon;
	}
	
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.startuppage.listCount");
		return listCount;
	}
	@Override
	public int estilistCount_i(String compId) throws Exception{
		int EstiListCount_i = sqlSession.selectOne("mapper.startuppage.estilistCount_i",compId);
		return EstiListCount_i;
	}
	@Override
	public int estilistCount_w(String compId) throws Exception{
		int estilistCount_w = sqlSession.selectOne("mapper.startuppage.estilistCount_w",compId);
		System.out.println("dao count" + estilistCount_w);
		return estilistCount_w;
	}
	@Override
	public int estilistCount_d(String compId) throws Exception{
		int EstiListCount_d = sqlSession.selectOne("mapper.startuppage.estilistCount_d",compId);
		return EstiListCount_d;
	}
	@Override
	public int estilistCount_c(String compId) throws Exception{
		int EstiListCount_c = sqlSession.selectOne("mapper.startuppage.estilistCount_c",compId);
		return EstiListCount_c;
	}
	@Override
	public List<StartupPageVO> selectAllEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> estiList = null;
		Map<String,Object> estiMap = new HashMap<String, Object>();
		estiMap.put("pagevo", pagevo);
		estiMap.put("compId", compId);
		estiList = sqlSession.selectList("mapper.startuppage.selectAllEstilist",estiMap);
		return estiList;
	}
	@Override
	public List<StartupPageVO> selectWaitEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> w_estiList = null;
		Map<String,Object> estiMap = new HashMap<String, Object>();
		estiMap.put("pagevo", pagevo);
		estiMap.put("compId", compId);
		
		w_estiList = sqlSession.selectList("mapper.startuppage.selectWaitEstilist",estiMap);
		return w_estiList;
	}
	@Override
	public List<StartupPageVO> selectIngEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> i_estiList = null;
		Map<String,Object> estiMap = new HashMap<String, Object>();
		estiMap.put("pagevo", pagevo);
		estiMap.put("compId", compId);
		i_estiList = sqlSession.selectList("mapper.startuppage.selectIngEstilist",estiMap);
		return i_estiList;
	}
	@Override
	public List<StartupPageVO> selectComEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> c_estiList = null;
		Map<String,Object> estiMap = new HashMap<String, Object>();
		estiMap.put("pagevo", pagevo);
		estiMap.put("compId", compId);
		c_estiList = sqlSession.selectList("mapper.startuppage.selectComEstilist",estiMap);
		System.out.println("dao 견적완료 : " + c_estiList);
		return c_estiList;
	}
	@Override
	public List<StartupPageVO> selectDeEstiList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> d_estiList = null;
		Map<String,Object> estiMap = new HashMap<String, Object>();
		estiMap.put("pagevo", pagevo);
		estiMap.put("compId", compId);
		d_estiList = sqlSession.selectList("mapper.startuppage.selectDeEstilist",estiMap);
		return d_estiList;
	}
	public int status_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_ing",no);
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_com",no);
		}
		return result;
	}
	public int status_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_esti_de",no);
		}
		return result;
	}
	
	
	
	
	public int constatus_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_ing",no); //�늻瑜대㈃ 吏꾪뻾以묒쑝濡� �뾽�뜲�씠�듃
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_com",no);//�셿猷뚮줈 �뾽�뜲�씠�듃�꽩
		}
		return result;
	}
	public int constatus_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.startuppage.upstatus_con_de",no);
		}
		return result;
	}
	
	
	
	
	@Override
	public int conlistCount_i(String compId) throws Exception{
		int conlistCount_i = sqlSession.selectOne("mapper.startuppage.conlistCount_i", compId);
		return conlistCount_i;
	}
	@Override
	public int conlistCount_w(String compId) throws Exception{
		int conlistCount_w = sqlSession.selectOne("mapper.startuppage.conlistCount_w", compId);
		return conlistCount_w;
	}
	@Override
	public int conlistCount_d(String compId) throws Exception{
		int conlistCount_d = sqlSession.selectOne("mapper.startuppage.conlistCount_d", compId);
		return conlistCount_d;
	}
	@Override
	public int conlistCount_c(String compId) throws Exception{
		int conlistCount_c = sqlSession.selectOne("mapper.startuppage.conlistCount_c", compId);
		return conlistCount_c;
	}
	
	
	
	
	
	@Override
	public List<StartupPageVO> selectAllProdList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> prodList = null;
		Map<String,Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		prodList = sqlSession.selectList("mapper.startuppage.selectAllProdlist",consultingMap);
		
		return prodList;
	}	
	@Override
	public List<StartupPageVO> selectAllConList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> conList = null;
		Map<String,Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		conList = sqlSession.selectList("mapper.startuppage.selectAllConlist",consultingMap);
		return conList;
	}
	@Override
	public List<StartupPageVO> selectWaitConList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> w_conList = null;
		Map<String,Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		w_conList = sqlSession.selectList("mapper.startuppage.selectWaitConlist",consultingMap);
		return w_conList;
	}
	public List<StartupPageVO> selectIngConList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> i_conList = null;
		Map<String,Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		i_conList = sqlSession.selectList("mapper.startuppage.selectIngConlist",consultingMap);
		return i_conList;
	}
	public List<StartupPageVO> selectComConList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> c_conList = null;
		Map<String,Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		c_conList = sqlSession.selectList("mapper.startuppage.selectComConlist",consultingMap);
		System.out.println("dao Comconlist : " + c_conList);
		return c_conList;
	}
	public List<StartupPageVO> selectDeConList(PageVO pagevo, String compId) throws DataAccessException{
		List<StartupPageVO> d_conList = null;
		Map<String,Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("compId", compId);
		d_conList = sqlSession.selectList("mapper.startuppage.selectDeConlist",consultingMap);
		return d_conList;
	}
}
