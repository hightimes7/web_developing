package com.spring.plt.manufacSearch.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;

public interface ManufacSearchController {
	public ModelAndView allManufac(PageVO pageVO, @RequestParam("userId")String userId, @RequestParam(value="cntPerPage", required=false)String cntPerPage,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public Map<Integer, Map<String, Object>> serchByLoc(@RequestParam("loc") String loc,HttpServletRequest request, HttpServletResponse response);
	public Map<Integer, Map<String, Object>> serchByManuType(@RequestParam("manuType") String manuType,HttpServletRequest request, HttpServletResponse response);
	public Map<Integer, Map<String, Object>> serchByManuMinimumPrice(@RequestParam("price") String price,HttpServletRequest request, HttpServletResponse response);
	public ModelAndView viewManufac(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response);
	
}
