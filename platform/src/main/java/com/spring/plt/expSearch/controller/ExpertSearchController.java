package com.spring.plt.expSearch.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;

public interface ExpertSearchController {
	public ModelAndView allExpert(PageVO pageVO, @RequestParam(value="nowPage",required = false) String nowPage, @RequestParam(value="cntPerPage", required = false) String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public Map<Integer, Map<String, Object>> serchByExpertName(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response);
	public Map<Integer,Map<String,Object>> serchByExpertType(@RequestParam("type") String type, HttpServletRequest request, HttpServletResponse response);
	public ModelAndView viewExpert(String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	String serchByExpertImgFile(String expertId, HttpServletRequest request, HttpServletResponse response);
}
