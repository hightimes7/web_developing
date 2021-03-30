package com.spring.plt.find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.plt.find.service.FindService;
import com.spring.plt.find.vo.FindVO;

@Controller("findController")
@EnableAspectJAutoProxy
public class FindControllerImpl implements FindController {

	@Autowired
	private FindService findService;
	@Autowired
	private FindVO findVO;
	
	@Override
	@RequestMapping(value="/member/findId.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView findId(@ModelAttribute("showId") FindVO find, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		findVO = findService.findId(find);
		if(findVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("showId", findVO);
			session.setAttribute("isCorrect", true);			
			mav.setViewName("redirect:/common/showId.do");
		} else {
			rAttr.addAttribute("result", "isNotCorrect");
			mav.setViewName("redirect:/common/idForm.do");			
		}
		return mav;
	}

	@Override
	@RequestMapping(value="/member/findPwd.do")
	public ModelAndView findPwd(@ModelAttribute("findPwd") FindVO find, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		String id = find.getId();
		findVO = findService.findPwd(find);
		if(findVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("findPwd", find);
			session.setAttribute("isCorrect", true);
			if (find.getType().equals("startup")) {
				mav.setViewName("redirect:/startup/startUpSelectForm.do?id="+id);
			} else if (find.getType().equals("manufac")) {
				mav.setViewName("redirect:/manufac/manufacSelectForm.do?id="+id);
			} else if (find.getType().equals("expert")) {
				mav.setViewName("redirect:/expert/expertSelectForm.do?id="+id);
			}
			
		} else {
			rAttr.addAttribute("result", "isDifferent");
			mav.setViewName("redirect:/common/pwdForm.do");
		}
		return mav;
	}
		
	@RequestMapping(value="/common/showId.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView showId(@RequestParam(value="result", required = false) String result, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);		
		return mav;
	}	
	
}
