package com.spring.plt.consulting.controller;

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

import com.spring.plt.consulting.service.ConsultingService;
import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.quotation.vo.QuotationVO;

@Controller("consultingController")
public class ConsultingControllerImpl implements ConsultingController{
	@Autowired
	ConsultingService service;
	
	@Autowired
	ConsultingVO ConsultingVO;
	
	@RequestMapping(value = "/consulting/insertConsultingForm.do", method = RequestMethod.GET)
	@Override
	public ModelAndView insertConsultingView(@RequestParam("expId") String expId, HttpServletRequest request,HttpServletResponse response) {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	
	@RequestMapping(value = "/insertConsulting.do")
	@Override
	public ModelAndView insertConsulting(@ModelAttribute ConsultingVO ConsultingVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		System.out.println("insert Consulting Controller");
		System.out.println(ConsultingVO.getFileName());
		System.out.println(ConsultingVO.getExpId());
		service.insertConsulting(ConsultingVO);
		String viewName = "redirect:/expSearch/viewExpert.do?id=" + ConsultingVO.getExpId();
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println(mav);
		return mav;
	}
	
	@RequestMapping(value = "/ConsultingList.do",  produces="application/json; charset=UTF8")
	@Override
	@ResponseBody
	public List<ConsultingVO> ConsultingList(HttpServletRequest request, HttpServletResponse responset){
		System.out.println("Consulting List Controller");
		List<ConsultingVO> list = service.ConsultingList();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping(value="/consulting/viewOneConsulting.do", method = RequestMethod.GET)
	@Override
	public ModelAndView viewOneConsulting(@RequestParam("no") String no, HttpServletRequest request, HttpServletResponse response) {
		//해당 글 번호로 vo를 조회 하여 화면에 견적서 , 발주요청서, 컨설팅 요청서 출력
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		ConsultingVO ConsultingVO = service.viewOneConsulting(no);
		mav.addObject("ConsultingVO", ConsultingVO);
		System.out.println(mav);
		return mav;
	}
	
	@RequestMapping(value="/alarmConsulting.do", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public int alarmConsulting(@RequestParam(value="expId", required=false) String expId,
			@RequestParam(value="compId", required=false) String compId, HttpServletRequest request, HttpServletResponse response){
		System.out.println("Quotation List Controller");
		int count = 0;
		if(compId!=null && compId.length()!=0) {
			count = service.alarmConsulting(compId);
		}else if(expId!=null && expId.length()!=0) {
			count = service.alarmExpConsulting(expId);
		}
		System.out.println(count);
		return count;
	}
}
