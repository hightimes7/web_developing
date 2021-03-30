package com.spring.plt.consulting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.quotation.vo.QuotationVO;

public interface ConsultingController {
	ModelAndView insertConsulting(ConsultingVO ConsultingVO, HttpServletRequest request, HttpServletResponse response) throws Exception;

	ModelAndView insertConsultingView(String manuId, HttpServletRequest request, HttpServletResponse response);

	List<ConsultingVO> ConsultingList(HttpServletRequest request, HttpServletResponse responset);

	ModelAndView viewOneConsulting(String no, HttpServletRequest request, HttpServletResponse response);

	public int alarmConsulting(@RequestParam(value="expId", required=false) String expId,
			@RequestParam(value="compId", required=false) String compId, HttpServletRequest request, HttpServletResponse response);

}
