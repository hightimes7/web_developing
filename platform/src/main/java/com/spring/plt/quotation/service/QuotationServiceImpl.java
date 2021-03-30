package com.spring.plt.quotation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.quotation.dao.QuotationDAO;
import com.spring.plt.quotation.vo.QuotationVO;

@Service("quotationService")
public class QuotationServiceImpl implements QuotationService{
	@Autowired
	QuotationDAO dao;
	
	@Override
	public void insertQuotation(QuotationVO quotationVO) {
		System.out.println("insert QuotationVO Service");
		dao.insertQuotation(quotationVO);
	}
	
	@Override
	public List<QuotationVO> quotationList(){
		return dao.quotationList();
	}

	@Override
	public QuotationVO viewOneQuotation(String no) {
		return dao.viewOneQuotation(no);
	}
	
	@Override
	public int alarmQuotation(String compId){
		return dao.alarmQuotation(compId);
	}

	@Override
	public int alarmManuQuotation(String manuId) {
		return dao.alarmManuQuotation(manuId);
	}
}
