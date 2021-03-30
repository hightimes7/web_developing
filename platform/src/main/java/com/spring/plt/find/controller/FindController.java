package com.spring.plt.find.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.plt.find.vo.FindVO;

public interface FindController {
	public ModelAndView findId(@ModelAttribute("showId") FindVO find, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response);
	public ModelAndView findPwd(@ModelAttribute("findPwd") FindVO find, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response);
}
