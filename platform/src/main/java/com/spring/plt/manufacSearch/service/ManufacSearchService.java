package com.spring.plt.manufacSearch.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufac.vo.ManufacVO;
import com.spring.plt.page.vo.PageVO;

public interface ManufacSearchService {
	public List<ManufacVO> serchByManuType(String manuType);
	public List<ManufacVO> serchByManuMinimumPrice(int price);
	public ManufacVO viewManuFac(String id);
	public List<ManufacVO> allManuFac(PageVO pageVO);
	public List<ManufacVO> serchByManuLoc(String loc);
	public int listCount() throws DataAccessException;
}
