package com.spring.plt.expertpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.expertpage.service.ExpertPageService;
import com.spring.plt.expertpage.vo.ExpertPageVO;
import com.spring.plt.page.vo.PageVO;

@Controller("expertPageController")
public class ExpertPageControllerImpl implements ExpertPageController{
	@Autowired
	private ExpertPageService expertPageService;
	@Autowired
	private ExpertPageVO expertPageVO;
	
	@RequestMapping(value = "/expertpage/consulting.do",method = RequestMethod.GET)
	public ModelAndView prodlist(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("++++++++++++++++++++++++");
		int total = expertPageService.listCount();
		System.out.println("-----------------------");
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		System.out.println(nowPage);
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
//		List<ExpertPageVO> conlist = expertPageService.listcon(pagevo, expId);
		List<ExpertPageVO> c_conlist = expertPageService.c_listcon(pagevo, expId);
		List<ExpertPageVO> w_conlist = expertPageService.w_listcon(pagevo, expId);
		List<ExpertPageVO> i_conlist = expertPageService.i_listcon(pagevo, expId);
		List<ExpertPageVO> d_conlist = expertPageService.d_listcon(pagevo, expId);
		
		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("conlist",conlist);
		mav.addObject("w_conlist",w_conlist);
		mav.addObject("i_conlist",i_conlist);
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("d_conlist",d_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	
	
	@RequestMapping(value="/expertpage/con_wait.do",method = RequestMethod.GET)
	public ModelAndView con_wait(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = expertPageService.listCount_w(expId);
		String viewName = (String)request.getAttribute("viewName");
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ExpertPageVO> w_conlist = expertPageService.w_listcon(pagevo, expId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("w_conlist",w_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	
	@RequestMapping(value="/expertpage/com_consulting.do",method = RequestMethod.GET)
	public ModelAndView con_com(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = expertPageService.listCount_c(expId);
		String viewName = (String)request.getAttribute("viewName");
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ExpertPageVO> c_conlist = expertPageService.c_listcon(pagevo, expId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value="/expertpage/con_ing.do",method = RequestMethod.GET)
	public ModelAndView con_ing(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = expertPageService.listCount_i(expId);
		String viewName = (String)request.getAttribute("viewName");
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ExpertPageVO> i_conlist = expertPageService.i_listcon(pagevo, expId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("i_conlist",i_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value="/expertpage/con_de.do",method = RequestMethod.GET)
	public ModelAndView con_de(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int total = expertPageService.listCount_d(expId);
		String viewName = (String)request.getAttribute("viewName");
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<ExpertPageVO> d_conlist = expertPageService.d_listcon(pagevo, expId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("d_conlist",d_conlist);
		mav.addObject("pagevo",pagevo);
		
		
		return mav;
	}
	
	@RequestMapping(value="/expertpage/estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView deletestatus(@RequestParam("expId") String expId,@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		expertPageService.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/consulting.do?expId="+expId);
		return mav;
	}
	@RequestMapping(value="/expertpage/com_estilist_del.do" , method = RequestMethod.GET)
	public ModelAndView com_deletestatus(@RequestParam("expId") String expId,@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		expertPageService.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/com_consulting.do?expId="+expId);
		return mav;
	}
	@RequestMapping(value ="/expertpage/updatestatus_y.do", method = RequestMethod.GET)
	public ModelAndView updatestatus_y(@RequestParam("expId")String expId, @RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		expertPageService.status_y(status,no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/consulting.do?expId="+expId);
		return mav;
	}
	@RequestMapping(value ="/expertpage/updatestatus_n.do", method = RequestMethod.GET)
	public ModelAndView updatestatus_n(@RequestParam("expId")String expId, @RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		expertPageService.status_n(status,no);
		ModelAndView mav = new ModelAndView("redirect:/expertpage/consulting.do?expId="+expId);
		return mav;
	}
}
