package com.spring.plt.expertpage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.expertpage.vo.ExpertPageVO;
import com.spring.plt.page.vo.PageVO;

@Repository("expertPageDAO")
public class ExpertPageDAOImpl implements ExpertPageDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int listCount() throws Exception{
		int listCount = sqlSession.selectOne("mapper.expertpage.listCount");
		return listCount;
	}
	@Override
	public int listCount_i(String expId) throws Exception{
		int listCount_i = sqlSession.selectOne("mapper.expertpage.listCount_i",expId);
		return listCount_i;
	}
	@Override
	public int listCount_w(String expId) throws Exception{
		System.out.println("dao에서 expId가 어떻게 오나: "+ expId);
		int listCount_w = sqlSession.selectOne("mapper.expertpage.listCount_w",expId);
		return listCount_w;
	}
	@Override
	public int listCount_c(String expId) throws Exception{
		int listCount_c = sqlSession.selectOne("mapper.expertpage.listCount_c",expId);
		return listCount_c;
	}
	@Override
	public int listCount_d(String expId) throws Exception{
		int listCount_d = sqlSession.selectOne("mapper.expertpage.listCount_d",expId);
		return listCount_d;
	}
	
	
	
	
//	@Override
//	public List<ExpertPageVO> selectAllEstiList(PageVO pagevo, String expId) throws DataAccessException{
//		
//		List<ExpertPageVO> conList = null;
//		Map<String, Object> consultingMap = new HashMap<String, Object>();
//		consultingMap.put("pagevo", pagevo);
//		consultingMap.put("expId", expId);
//		conList = sqlSession.selectList("mapper.expertpage.selectAllEstilist",consultingMap);
//		
//		return conList;
//	}
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.expertpage.deleteesti", no);
		
		return deleteesti;
	}
	@Override
	public List<ExpertPageVO> selectWaitEstiList(PageVO pagevo, String expId) throws DataAccessException{
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		List<ExpertPageVO> w_conList = null;
		w_conList = sqlSession.selectList("mapper.expertpage.selectWaitEstiList",consultingMap);
		
		return w_conList;
	}
	@Override
	public List<ExpertPageVO> selectIngEstiList(PageVO pagevo, String expId) throws DataAccessException{
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		List<ExpertPageVO> i_conList = null;
		i_conList = sqlSession.selectList("mapper.expertpage.selectIngEstiList",consultingMap);
		
		return i_conList;
	}
	@Override
	public List<ExpertPageVO> selectComEstiList(PageVO pagevo, String expId) throws DataAccessException{
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		List<ExpertPageVO> c_conList = null;
		c_conList = sqlSession.selectList("mapper.expertpage.selectComEstilist",consultingMap);
		
		return c_conList;
	}
	@Override
	public List<ExpertPageVO> selectDeEstiList(PageVO pagevo, String expId) throws DataAccessException{
		Map<String, Object> consultingMap = new HashMap<String, Object>();
		consultingMap.put("pagevo", pagevo);
		consultingMap.put("expId", expId);
		List<ExpertPageVO> d_conList = null;
		d_conList = sqlSession.selectList("mapper.expertpage.selectDeEstilist",consultingMap);
		
		return d_conList;
	}
	public int status_y(int status, int no)throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_ing",no); //누르면 진행중으로 업데이트
			System.out.println("dao result" + result);
		}else if(status == 1) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_com",no);//완료로 업데이트ㄴ
		}
		return result;
	}
	public int status_n(int status, int no) throws DataAccessException{
		int result = 0;
		if (status == 0) {
			result = sqlSession.update("mapper.expertpage.upstatus_esti_de",no);
		}
		return result;
	}
}
