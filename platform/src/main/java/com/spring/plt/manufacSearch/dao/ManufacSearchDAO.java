package com.spring.plt.manufacSearch.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.manufac.vo.ManufacVO;
import com.spring.plt.page.vo.PageVO;

public interface ManufacSearchDAO {
	List<ManufacVO> serchByManuType(String manuType);

	List<ManufacVO> serchByManuMinimunPrice(int price);


	List<ManufacVO> serchByManuLoc(String loc);

	ManufacVO viewOneManuFac(String id);

	int listCount() throws DataAccessException;

	List<ManufacVO> allManuFac(PageVO pageVO);

	
}
