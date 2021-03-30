package com.spring.plt.quotation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.quotation.vo.QuotationVO;

public interface QuotationController {
	ModelAndView insertQuotation(QuotationVO quotationVO, HttpServletRequest request, HttpServletResponse response);
	List<QuotationVO> quotationList(HttpServletRequest request, HttpServletResponse response);
	ModelAndView insertQuotationView(String manuId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	ModelAndView viewOneQuotation(String manuId, HttpServletRequest request, HttpServletResponse response);
	public int alarmQuotation(@RequestParam(value="compId", required=false) String compId, 
			  @RequestParam(value="manuId", required=false) String manuId,HttpServletRequest request, HttpServletResponse response);
}
