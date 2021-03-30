package com.spring.plt.manufacpage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.manufacpage.service.ManufacPageService;
import com.spring.plt.manufacpage.vo.ManufacPageVO;
import com.spring.plt.page.vo.PageVO;

@Controller("manufacPageController")
public class ManufacPageControllerImpl implements ManufacPageController{
	@Autowired
	private ManufacPageService manufacservice;
	
	@Autowired
	private ManufacPageVO manufac;
	
	@RequestMapping(value = "/manufacpage/estilist.do", method = RequestMethod.GET)
	public ModelAndView prodlist(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		
		int total = manufacservice.listCount();
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
		
		List<ManufacPageVO> estilist = manufacservice.listesti(pagevo,manuId);
		List<ManufacPageVO> w_estiList = manufacservice.w_estiList(pagevo,manuId);
		List<ManufacPageVO> i_estiList = manufacservice.i_estiList(pagevo,manuId);
		List<ManufacPageVO> c_estiList = manufacservice.c_estiList(pagevo,manuId);
		List<ManufacPageVO> d_estiList = manufacservice.d_estiList(pagevo,manuId);
//		
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("estilist",estilist);
		mav.addObject("w_estiList", w_estiList);
		mav.addObject("i_estiList", i_estiList);
		mav.addObject("c_estiList", c_estiList);
		mav.addObject("d_estiList", d_estiList);
		
		mav.addObject("pagevo",pagevo);
		
		System.out.println("estiList: "+estilist);
		
		return mav;
	}
	@RequestMapping(value="/manufacpage/estilist_del.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deletestatus(@RequestParam("manuId") String manuId,@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		manufacservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do?manuId="+manuId);
		return mav;
	}
	@RequestMapping(value="/manufacpage/com_estilist_del.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView com_deletestatus(@RequestParam("manuId") String manuId,@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		manufacservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/manufacpage/com_estilist.do?manuId="+manuId);
		return mav;
	}
	@RequestMapping(value ="/manufacpage/estilist_updatestatus.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updatestatus(@RequestParam("manuId")String manuId,@RequestParam("quotestatus") int quotestatus, @RequestParam("no") int no,
		   HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		manufacservice.updatestatus(quotestatus,no);
		ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do?manuId="+manuId);
		return mav;
	}
	
	@RequestMapping(value ="/manufacpage/estilist_updatestatus_de.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView updatestatus_de(@RequestParam("manuId")String manuId, @RequestParam("quotestatus") int quotestatus, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		manufacservice.updatestatus_de(quotestatus,no); 
		ModelAndView mav = new ModelAndView("redirect:/manufacpage/estilist.do?manuId="+manuId);
		return mav;
	}
	@RequestMapping(value = "/manufacpage/estilist_more_w.do",method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView prodlist_w(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = manufacservice. listCount_w(manuId);
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
		List<ManufacPageVO> w_estiList = manufacservice.w_estiList(pagevo,manuId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("w_estiList", w_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	
	@RequestMapping(value="manufacpage/estilist_more_ing.do", method=RequestMethod.GET)
	public ModelAndView prodlist_ing(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = manufacservice. listCount_i(manuId);
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
		List<ManufacPageVO> i_estiList = manufacservice.i_estiList(pagevo,manuId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("i_estiList", i_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value="/manufacpage/com_estilist.do", method=RequestMethod.GET)
	public ModelAndView prodlist_com(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = manufacservice. listCount_c(manuId);
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
		List<ManufacPageVO> c_estiList = manufacservice.c_estiList(pagevo,manuId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("c_estiList", c_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
}
	@RequestMapping(value="/manufacpage/estilist_more_de.do", method=RequestMethod.GET)
	public ModelAndView prodlist_de(@RequestParam("manuId")String manuId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = manufacservice. listCount_d(manuId);
		System.out.println("��Ÿ��: " +total);
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
		List<ManufacPageVO> d_estiList = manufacservice.d_estiList(pagevo,manuId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("d_estiList", d_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
}

	
}
