package com.spring.plt.quotation.service;

import java.util.List;

import com.spring.plt.quotation.vo.QuotationVO;

public interface QuotationService {
	void insertQuotation(QuotationVO quotationVO);
	List<QuotationVO> quotationList();
	QuotationVO viewOneQuotation(String no);
	int alarmQuotation(String compId);
	int alarmManuQuotation(String manuId);
}
