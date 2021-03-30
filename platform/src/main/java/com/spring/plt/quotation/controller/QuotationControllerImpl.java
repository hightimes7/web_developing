package com.spring.plt.quotation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.quotation.service.QuotationService;
import com.spring.plt.quotation.vo.QuotationVO;

@Controller("quotationController")
public class QuotationControllerImpl implements QuotationController{
	@Autowired
	QuotationService service;
	@RequestMapping(value = "/quotation/insertQuotationForm.do", method = RequestMethod.GET)
	@Override
	public ModelAndView insertQuotationView(@RequestParam("manuId") String manuId, HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	
	@RequestMapping(value = "/insertQuotation.do")
	@Override
	public ModelAndView insertQuotation(@ModelAttribute QuotationVO quotationVO, HttpServletRequest request, HttpServletResponse response) {
		if (quotationVO.getTempSave() == null) quotationVO.setTempSave("false");
		service.insertQuotation(quotationVO);
		String viewName = "redirect:/manufacSearch/viewManufac.do?id=" + quotationVO.getManuId();
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	@RequestMapping(value = "/quotationList.do",  produces="application/json; charset=UTF8")
	@Override
	@ResponseBody
	public List<QuotationVO> quotationList(HttpServletRequest request, HttpServletResponse responset){
		System.out.println("Quotation List Controller");
		List<QuotationVO> list = service.quotationList();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="quotation/viewOneQuotation.do", method = RequestMethod.GET)
	@Override
	public ModelAndView viewOneQuotation(@RequestParam("no") String no, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Quotation NO = " + no);
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		QuotationVO quotationVO = service.viewOneQuotation(no);
		mav.addObject("quotationVO", quotationVO);
		return mav;
	}
	
	@RequestMapping(value="/alarmQuotation.do", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public int alarmQuotation(@RequestParam(value="compId", required=false) String compId, 
							  @RequestParam(value="manuId", required=false) String manuId,HttpServletRequest request, HttpServletResponse response){
		System.out.println("Quotation List Controller");
		int count = 0;
		if(compId!=null && compId.length()!=0) {
			count = service.alarmQuotation(compId);
		}else if(manuId!=null && manuId.length()!=0) {
			count = service.alarmManuQuotation(manuId);
		}
		System.out.println(count);
		return count;
	}

}
