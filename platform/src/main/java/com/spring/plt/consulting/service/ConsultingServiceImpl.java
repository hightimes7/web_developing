package com.spring.plt.consulting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.consulting.dao.ConsultingDAO;
import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.quotation.vo.QuotationVO;

@Service("consultingService")
public class ConsultingServiceImpl implements ConsultingService{
	@Autowired
	ConsultingDAO dao;
	
	@Override
	public void insertConsulting(ConsultingVO ConsultingVO) {
		System.out.println("insert ConsultingVO Service");
		dao.insertConsulting(ConsultingVO);
	}
	
	@Override
	public List<ConsultingVO> ConsultingList(){
		return dao.ConsultingList();
	}

	@Override
	public ConsultingVO viewOneConsulting(String no) {
		return dao.viewOneConsulting(no);
	}

	@Override
	public int alarmConsulting(String compId) {
		return dao.alarmConsulting(compId);
	}

	@Override
	public int alarmExpConsulting(String expId) {
		return dao.alarmExpConsulting(expId);
	}
}
