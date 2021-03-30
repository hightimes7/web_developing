package com.spring.plt.scrap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;

public interface ScrapController {

	public ResponseEntity deleteExpertScrap(@RequestParam("compId")String compId, @RequestParam("no") int no, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ResponseEntity deleteManuScrap(@RequestParam("compId")String compId, @RequestParam("no") int no, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;

//	public void scrapExpert(String expId, HttpServletRequest request, HttpServletResponse response) throws Exception;
//	public void scrapManu(String manuId, HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView printScrapAll(@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

//	ModelAndView printExpertScrapAll(PageVO pageVO, String nowPage, String cntPerPage, HttpServletRequest request,
//			HttpServletResponse response) throws Exception;
	public ModelAndView printExpertScrapAll(PageVO pageVO, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage,
			@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

//	ModelAndView printManuScrapAll(PageVO pageVO, String nowPage, String cntPerPage, HttpServletRequest request,
//			HttpServletResponse response) throws Exception;
	public ModelAndView printManuScrapAll(PageVO pageVO, @RequestParam(value="nowPage", required = false) String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

	ResponseEntity scrapManu(String manuId, String compId, HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	public ResponseEntity scrapExpert(@RequestParam("expId") String expId, @RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception;

}
