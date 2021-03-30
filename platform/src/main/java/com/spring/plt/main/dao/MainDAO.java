package com.spring.plt.main.dao;

import java.util.List;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.manufac.vo.ManufacVO;

public interface MainDAO {

	List<ManufacVO> manumain() throws Exception;

	List<ExpertVO> expertmain() throws Exception;
	public List<ExpImageVO> expertImgMain() throws Exception;
}
