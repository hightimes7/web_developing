package com.spring.plt.startuppage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.startuppage.service.StartupPageService;
import com.spring.plt.startuppage.vo.StartupPageVO;

@Controller("startuppagecontroller")
public class StartuppageControllerImpl implements StartuppageController{
	@Autowired
	private StartupPageService startuppageservice;
	@Autowired
	private StartupPageVO startuppagevo;    // /startuppage/*list.do
	@RequestMapping(value = {"/startuppage/manu_prodlist.do","/startuppage/manu_estilist.do"}, method = RequestMethod.GET)
	public ModelAndView prodlist(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("html/text;charset=utf-8");
			String viewName = (String)request.getAttribute("viewName");
			int total = startuppageservice.listCount();
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			}else if(nowPage == null) {
				nowPage = "1";
			}else if(cntPerPage == null) {
				cntPerPage = "10";
			}
			pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			List<StartupPageVO> w_estilist = startuppageservice.w_listesti(pagevo, compId);
			List<StartupPageVO> c_estilist = startuppageservice.c_listesti(pagevo,compId);
			List<StartupPageVO> d_estilist = startuppageservice.d_listesti(pagevo,compId);
			List<StartupPageVO> i_estilist = startuppageservice.i_listesti(pagevo, compId);
			
			
			
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("w_estilist",w_estilist);
			mav.addObject("c_estilist",c_estilist);
			mav.addObject("d_estilist",d_estilist);
			mav.addObject("i_estilist",i_estilist);
			
			return mav;
	}
	
	
	
	@RequestMapping(value = "/startuppage/estilist_more_w.do", method = RequestMethod.GET)
	public ModelAndView estilist_w(@RequestParam("compId") String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response, Object expId) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int total = startuppageservice.estilistCount_w(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> w_estilist = startuppageservice.w_listesti(pagevo, compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("w_estilist",w_estilist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/estilist_more_ing.do", method = RequestMethod.GET)
	public ModelAndView estilist_ing(@RequestParam("compId") String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		int total = startuppageservice.estilistCount_i(compId);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> i_estilist = startuppageservice.i_listesti(pagevo, compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("i_estilist",i_estilist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/estilist_more_de.do", method = RequestMethod.GET)
	public ModelAndView estilist_de(@RequestParam("compId") String compId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		int total = startuppageservice.estilistCount_d(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> d_estilist = startuppageservice.d_listesti(pagevo,compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("d_estilist",d_estilist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	

	
	
	@Override
	@RequestMapping(value="/startuppage/estilist_del.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deletestatus(@RequestParam("compId") String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		startuppageservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do?compId="+compId);
		return mav;
	}
	@Override
	@RequestMapping(value="/startuppage/conlist_del.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deletestatus_con(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.deletecon(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consultinglist.do?compId="+compId);
		return mav;
	}
	@Override
	@RequestMapping(value= "/startuppage/com_conlist_del.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView com_deletestatus_con(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.deletecon(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/com_consultinglist.do?compId="+compId);
		return mav;
	}
	@Override
	@RequestMapping(value= "/startuppage/com_conlist_del_more.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView com_deletestatus_conmore(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.deletecon(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/com_consulting_more.do?compId="+compId);
		return mav;
	}
	@Override
	@RequestMapping(value="/startuppage/com_estilist_del.do" , method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView com_deletestatus(@RequestParam("compId") String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		System.out.println("delete NO: "+no);
		startuppageservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/com_consultinglist.do?compId="+compId);
		return mav;
	}
	@Override
	@RequestMapping(value= "/startuppage/com_estilist_del_more.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView com_deletestatus_estimore(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.deleteesti(no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/com_esti_more.do?compId="+compId);
		return mav;
	}

	
	
	
	
	@RequestMapping(value ="/startuppage/updatestatus_y.do", method = RequestMethod.GET)
	public ModelAndView updatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.status_y(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
		return mav;
	}
	@RequestMapping(value ="/startuppage/updatestatus_n.do", method = RequestMethod.GET)
	public ModelAndView updatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.status_n(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/manu_estilist.do");
	
		return mav;
	}
	
	@RequestMapping(value ="/startuppage/conupdatestatus_y.do", method = RequestMethod.GET)
	public ModelAndView conupdatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.constatus_y(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consultinglist.do");
		return mav;
	}
	@RequestMapping(value ="/startuppage/conupdatestatus_n.do", method = RequestMethod.GET)
	public ModelAndView conupdatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		startuppageservice.constatus_n(status,no);
		ModelAndView mav = new ModelAndView("redirect:/startuppage/consultinglist.do");
	
		return mav;
	}
	
	
	
	
	
	@RequestMapping(value = "/startuppage/consultinglist.do", method = RequestMethod.GET)
	public ModelAndView conlist(@RequestParam("compId") String compId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
			request.setCharacterEncoding("utf-8");
			response.setContentType("html/text;charset=utf-8");
			String viewName = (String)request.getAttribute("viewName");
			int total = startuppageservice.listCount();
			if(nowPage == null && cntPerPage == null) {
				nowPage = "1";
				cntPerPage = "10";
			}else if(nowPage == null) {
				nowPage = "1";
			}else if(cntPerPage == null) {
				cntPerPage = "10";
			}
			pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
			List<StartupPageVO> conlist = startuppageservice.listcon(pagevo,compId);
			List<StartupPageVO> w_conlist = startuppageservice.w_listcon(pagevo,compId);
			List<StartupPageVO> c_conlist = startuppageservice.c_listcon(pagevo,compId);
			List<StartupPageVO> d_conlist = startuppageservice.d_listcon(pagevo,compId);
			List<StartupPageVO> i_conlist = startuppageservice.i_listcon(pagevo,compId);
			
			
			
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("conlist",conlist);
			mav.addObject("w_conlist",w_conlist);
			mav.addObject("c_conlist",c_conlist);
			mav.addObject("d_conlist",d_conlist);
			mav.addObject("i_conlist",i_conlist);
			return mav;
	}
	@RequestMapping(value = "/startuppage/consulting_more_w.do", method = RequestMethod.GET)
	public ModelAndView conlist_w(@RequestParam("compId") String compId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int total = startuppageservice.conlistCount_w(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> w_conlist = startuppageservice.w_listcon(pagevo,compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("w_conlist",w_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/consulting_more_i.do", method = RequestMethod.GET)
	public ModelAndView conlist_i(@RequestParam("compId") String compId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_i(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> i_conlist = startuppageservice.i_listcon(pagevo,compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("i_conlist",i_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/consulting_more_d.do", method = RequestMethod.GET)
	public ModelAndView conlist_d(@RequestParam("compId") String compId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_d(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> d_conlist = startuppageservice.d_listcon(pagevo,compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("d_conlist",d_conlist);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	@RequestMapping(value = "/startuppage/com_consultinglist.do", method = RequestMethod.GET)
	public ModelAndView com_consulting(@RequestParam("compId") String compId,PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		int total = startuppageservice.conlistCount_c(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pagevo = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> c_conlist = startuppageservice.c_listcon(pagevo,compId);
		List<StartupPageVO> c_estiList = startuppageservice.c_listesti(pagevo, compId);
		ModelAndView mav = new ModelAndView(viewName);
		System.out.println("이거되는거야?"+c_estiList);
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("c_estiList", c_estiList);
		mav.addObject("pagevo",pagevo);
		return mav;
	}
	
	@RequestMapping(value="/startuppage/com_consulting_more.do", method=RequestMethod.GET)
	public ModelAndView com_consulting_more(@RequestParam("compId") String compId,PageVO pageVO, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.conlistCount_c(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> c_conlist = startuppageservice.c_listcon(pageVO,compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("c_conlist",c_conlist);
		mav.addObject("pageVO",pageVO);
		return mav;
	}
	
	@RequestMapping(value="/startuppage/com_esti_more.do", method=RequestMethod.GET)
	public ModelAndView com_esti_more(@RequestParam("compId") String compId, PageVO pageVO, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		int total = startuppageservice.estilistCount_c(compId);
		System.out.println("total : " + total);
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
		List<StartupPageVO> c_listesti = startuppageservice.c_listesti(pageVO,compId);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("c_listesti",c_listesti);
		mav.addObject("pageVO",pageVO);
		return mav;
	}
	

}
