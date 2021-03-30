package com.spring.plt.expertpage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;

public interface ExpertPageController {
	public ModelAndView prodlist(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView con_wait(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView con_com(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView con_ing(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView con_de(@RequestParam("expId")String expId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deletestatus(@RequestParam("expId") String expId,@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView com_deletestatus(@RequestParam("expId") String expId,@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView updatestatus_y(@RequestParam("expId")String expId, @RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView updatestatus_n(@RequestParam("expId")String expId, @RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
}
