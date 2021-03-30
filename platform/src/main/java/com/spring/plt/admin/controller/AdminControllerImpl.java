package com.spring.plt.admin.controller;

import java.net.InetAddress;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.plt.admin.service.AdminService;
import com.spring.plt.admin.vo.AdminVO;
import com.spring.plt.admin.vo.EditInfoVO;
import com.spring.plt.admin.vo.LoginLogVO;

@Controller("adminController")
@EnableAspectJAutoProxy
public class AdminControllerImpl implements AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminVO adminVO;
	private LoginLogVO loginVO;
	
	public static String getClientIp(HttpServletRequest req) {
	       String ip = req.getHeader("X-Forwarded-For");
	       if (ip == null) ip = req.getRemoteAddr();
	       return ip;
    }
	
	@Override
	@RequestMapping(value= {"/admin/changeLogForm.do","/admin/startchangeLogForm.do","/admin/manuchangeLogForm.do","/admin/expertchangeLogForm.do"}, method = {RequestMethod.GET, RequestMethod.POST})
	   public ModelAndView changeLog(HttpServletRequest request, HttpServletResponse response) throws Exception{
	      List<EditInfoVO> startEdit = adminService.startUpEdit();
	      List<EditInfoVO> manuEdit = adminService.manuEdit();
	      List<EditInfoVO> expertEdit = adminService.expertEdit();
	      
	      String viewName = (String)request.getAttribute("viewName");
	      ModelAndView mav = new ModelAndView();
	      
	      mav.addObject("manufacVO", manuEdit);
	      mav.addObject("startUpVO", startEdit);
	      mav.addObject("expertVO", expertEdit);
	      
	      mav.setViewName(viewName);
	      return mav;
	   }
	
	@RequestMapping(value="/admin/LoginLogForm.do", method= {RequestMethod.GET, RequestMethod.GET})
	public ModelAndView LoginLog(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<LoginLogVO> LoginLog = adminService.LoginLog();
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		
    	mav.addObject("LoginLogVO", LoginLog);
    		
		mav.setViewName(viewName);
		return mav;
	}
	   @RequestMapping(value="admin/*Form.do", method= {RequestMethod.POST, RequestMethod.GET})
	   public ModelAndView Form(HttpServletRequest request, HttpServletResponse response) throws Exception{
	      String viewName = (String)request.getAttribute("viewName");
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName(viewName);
	      return mav;
	   }

	   @RequestMapping(value="/admin/login.do", method=RequestMethod.POST)
	   public ModelAndView login(@ModelAttribute("member") AdminVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception {
	      System.out.println("adminVO: "+member);
	      ModelAndView mav = new ModelAndView();
	      adminVO = adminService.login(member);
	      
//	      InetAddress local = InetAddress.getLocalHost();
//	      String ip = local.getHostAddress();
	      
	      
	      String ip = request.getHeader("X-Forwarded-For");
	      System.out.println(ip);
	       if (ip == null) {
	           ip = request.getHeader("Proxy-Client-IP");
	       }
	       if (ip == null) {
	           ip = request.getHeader("WL-Proxy-Client-IP");
	       }
	       if (ip == null) {
	           ip = request.getHeader("HTTP_CLIENT_IP");
	       }
	       if (ip == null) {
	           ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	       }
	       if (ip == null) {
	           ip = request.getRemoteAddr();
	       }
	       
	        System.out.println(ip+"+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	      if(adminVO != null && adminVO.getIpNO().equals(ip)) {
	         HttpSession session = request.getSession();
	         session.setAttribute("member", adminVO);
	         session.setAttribute("isLogOn", true);
	         mav.setViewName("redirect:/main/main.do");            
	         } else {
	            rAttr.addAttribute("result", "loginFailed");
	            mav.setViewName("redirect:/common/loginForm.do");
	         }      
	      return mav;
	   }
	
	@Override
	@RequestMapping(value="/admin/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}
	
	@RequestMapping(value="/common/about.do", method=RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request, HttpServletRequest response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
}
