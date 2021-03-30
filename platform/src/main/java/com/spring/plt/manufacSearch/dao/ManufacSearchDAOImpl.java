package com.spring.plt.manufacSearch.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.manufac.vo.ManufacVO;
import com.spring.plt.page.vo.PageVO;

@Repository("manufacSearchDAO")
public class ManufacSearchDAOImpl implements ManufacSearchDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ManufacVO> serchByManuLoc(String loc) throws DataAccessException{
		System.out.println("ManuFac DAO loc");
		System.out.println(loc);
		List<ManufacVO> manuFacList = null;
		manuFacList = sqlSession.selectList("mapper.manufac.selectByManuLoc",loc);
		System.out.println(manuFacList);
		return manuFacList;
	}

	@Override
	public List<ManufacVO> serchByManuType(String manuType) {
		System.out.println("ManuFac DAO type" + "  manuType: " + manuType);
		return sqlSession.selectList("mapper.manufac.serchByManuType", manuType);
	}

	@Override
	public List<ManufacVO> serchByManuMinimunPrice(int price) {
		System.out.println("ManuFac DAO price");
		return sqlSession.selectList("mapper.manufac.serchByManuMinimumPrice", price);
	}

	@Override
	public ManufacVO viewOneManuFac(String id) {
		System.out.println("ManuFac DAO view");
		return sqlSession.selectOne("mapper.manufac.viewManuFac", id);
	}

	@Override
	public List<ManufacVO> allManuFac(PageVO pageVO) {
		System.out.println("ManuFac DAO all"+" " + pageVO.getStart() +" "+ pageVO.getEnd());
		return sqlSession.selectList("mapper.manufac.allManuFac",pageVO);
	}

	@Override
	public int listCount() throws DataAccessException {
		int listCount = sqlSession.selectOne("mapper.manufac.listCount");
		return listCount;
	}
}
