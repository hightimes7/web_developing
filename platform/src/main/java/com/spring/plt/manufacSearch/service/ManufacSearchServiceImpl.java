package com.spring.plt.manufacSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.manufac.vo.ManufacVO;
import com.spring.plt.manufacSearch.dao.ManufacSearchDAO;
import com.spring.plt.page.vo.PageVO;

@Service("manufacSearchService")
public class ManufacSearchServiceImpl implements ManufacSearchService{
	@Autowired
	ManufacSearchDAO dao;
	
	@Override
	public List<ManufacVO> serchByManuType(String manuType) {
		System.out.println("ManuFac service Type");
		return dao.serchByManuType(manuType);
	}

	@Override
	public List<ManufacVO> serchByManuMinimumPrice(int price) {
		System.out.println("ManuFac service price");
		return dao.serchByManuMinimunPrice(price);
	}

	@Override
	public ManufacVO viewManuFac(String id) {
		System.out.println("ManuFac service view");
		return dao.viewOneManuFac(id);
	}

	@Override
	public List<ManufacVO> allManuFac(PageVO pageVO) {
		System.out.println("ManuFac service all");
		return dao.allManuFac(pageVO);
	}

	@Override
	public List<ManufacVO> serchByManuLoc(String loc) {
		System.out.println("ManuFac service loc");
		return dao.serchByManuLoc(loc);
	}
	
	@Override
	public int listCount() throws DataAccessException {
		int listCount = dao.listCount();
		return listCount;
	}
}
