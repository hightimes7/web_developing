package com.spring.plt.main.service;

import java.util.List;
import java.util.Map;

import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.manufac.vo.ManufacVO;

public interface MainService {
	public List<ManufacVO> manumain() throws Exception;
	public List<ExpertVO> expertmain() throws Exception;
	public Map<String, Object> expertMain() throws Exception;
}
