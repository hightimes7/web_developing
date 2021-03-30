package com.spring.plt.manufacpage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

@Repository("manufacPageDAO")
public class ManufacPageDAOImpl implements ManufacPageDAO{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.manufacpage.listCount");
		
		return listCount;
	}
	@Override
	public List<ManufacPageVO> selectAllEstiList(PageVO pagevo, String manuId) throws DataAccessException{
		List<ManufacPageVO> estiList = null;
		Map<String, Object> estilistMap = new HashMap<String,Object>();
		estilistMap.put("pagevo", pagevo);
		estilistMap.put("manuId", manuId);
		estiList = sqlSession.selectList("mapper.manufacpage.selectAllEstilist",estilistMap);
		return estiList;
	}
	public List<ManufacPageVO> selectWaitingEstiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estiList = null;
		Map<String, Object> estilistMap = new HashMap<String,Object>();
		estilistMap.put("pagevo", pagevo);
		estilistMap.put("manuId", manuId);
		estiList = sqlSession.selectList("mapper.manufacpage.selectWaitingEstiList",estilistMap);
		return estiList;
	}
	public List<ManufacPageVO> selectIngEstiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estiList = null;
		Map<String, Object> estilistMap = new HashMap<String,Object>();
		estilistMap.put("pagevo", pagevo);
		estilistMap.put("manuId", manuId);
		estiList = sqlSession.selectList("mapper.manufacpage.selectIngEstiList",estilistMap);
		return estiList;
	}
	public List<ManufacPageVO> selectComEstiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estiList = null;
		Map<String, Object> estilistMap = new HashMap<String,Object>();
		estilistMap.put("pagevo", pagevo);
		estilistMap.put("manuId", manuId);
		estiList = sqlSession.selectList("mapper.manufacpage.selectComEstiList",estilistMap);
		return estiList;
	}
	public List<ManufacPageVO> selectDeEstiList(PageVO pagevo, String manuId) throws Exception{
		List<ManufacPageVO> estiList = null;
		Map<String, Object> estilistMap = new HashMap<String,Object>();
		estilistMap.put("pagevo", pagevo);
		estilistMap.put("manuId", manuId);
		estiList = sqlSession.selectList("mapper.manufacpage.selectDeEstiList",estilistMap);
		return estiList;
	}
	
	@Override
	public int deleteesti(int no) throws DataAccessException {
		int deleteesti = sqlSession.delete("mapper.manufacpage.deleteesti", no);
		
		return deleteesti;
	}
	@Override
	public int quotestatus(int quotestatus, int no) throws DataAccessException{
		int result = 0;
		if (quotestatus == 0) {
			result = sqlSession.update("mapper.manufacpage.upstatus_esti_ing",no);
			System.out.println("dao result" + result);
		}else if(quotestatus == 1) {
			result = sqlSession.update("mapper.manufacpage.upstatus_esti_com",no);
		}
		return result;
	}
	public int quotestatus_de(int quotestatus, int no) throws DataAccessException{
		int result = 0;
		if (quotestatus == 0) {
			result = sqlSession.update("mapper.manufacpage.upstatus_esti_de",no);
		}
		return result;
	}
	@Override
	public int estilistCount_i(String manuId) throws Exception{
		int estilistCount_i = sqlSession.selectOne("mapper.manufacpage.estilistCount_i",manuId);
		return estilistCount_i;
	}
	@Override
	public int estilistCount_w(String manuId) throws Exception{
		int estilistCount_w = sqlSession.selectOne("mapper.manufacpage.estilistCount_w",manuId);
		System.out.println("紐⑸줉�씠 �뾾�쓣�븣 Count媛믪씠 �뼱�뼸寃� �굹�삤�뒗吏� �솗�씤"+estilistCount_w);
		return estilistCount_w;
	}
	@Override
	public int estilistCount_c(String manuId) throws Exception{
		int estilistCount_c = sqlSession.selectOne("mapper.manufacpage.estilistCount_c",manuId);
		return estilistCount_c;
	}
	@Override
	public int estilistCount_d(String manuId) throws Exception{
		int estilistCount_d = sqlSession.selectOne("mapper.manufacpage.estilistCount_d",manuId);
		System.out.println("페이징!!!!"+estilistCount_d);
		return estilistCount_d;
	}
}
