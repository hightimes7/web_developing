package com.spring.plt.startuppage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;

public interface StartuppageController {
	public ModelAndView prodlist(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView estilist_w(@RequestParam("compId") String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response, Object expId) throws Exception;
	public ModelAndView estilist_ing(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView estilist_de(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView updatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView conupdatestatus_y(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView conupdatestatus_n(@RequestParam("status") int status, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView conlist(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView conlist_w(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView conlist_i(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView conlist_d(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView com_consulting(@RequestParam("compId")String compId, PageVO pagevo, @RequestParam(value="nowPage", required = false)String nowPage, @RequestParam(value  = "cntPerPage", required = false)String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deletestatus_con(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView deletestatus(@RequestParam("compId") String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView com_deletestatus_con(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView com_deletestatus(@RequestParam("compId") String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	public ModelAndView com_deletestatus_conmore(String compId, int no, HttpServletRequest request,HttpServletResponse response) throws Exception;
	public ModelAndView com_deletestatus_estimore(@RequestParam("compId")String compId, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response)throws Exception;
	
}
