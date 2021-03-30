package com.spring.plt.manufacSearch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.allUser.AllUserVO;
import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.manufac.vo.ManufacVO;
import com.spring.plt.manufacSearch.service.ManufacSearchService;
import com.spring.plt.page.vo.PageVO;
import com.spring.plt.quotation.vo.QuotationVO;
import com.spring.plt.scrap.vo.ScrapVO;

@Controller("manufacSearchController")
public class ManufacSearchControllerImpl implements ManufacSearchController{
	@Autowired
	ManufacSearchService service;
	
	@Autowired
	ManufacVO manufacVO;
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value="/manufacSearch/allManufac")
	@Override
	public ModelAndView allManufac(PageVO pageVO,
			@RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage,HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ManuFac Controller allManuFac");
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		String viewName = (String) request.getAttribute("viewName");
		int total = service.listCount();
		if(nowPage == null && cntPerPage == null) {
	         nowPage = "1";
	         cntPerPage = "9";
	      }else if(nowPage == null) {
	         nowPage = "1";
	      }else if(cntPerPage == null) {
	         cntPerPage = "9";
	      } 
	    System.out.println(cntPerPage+" 한장당 표시할 페이지");
	    pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));

		List<ManufacVO> manufacList= new ArrayList<ManufacVO>();
		manufacList = service.allManuFac(pageVO);
		System.out.println("allmanufac manufacList: "+manufacList);
		ModelAndView mav = new ModelAndView(viewName);


		mav.addObject("manufacList",manufacList);
		mav.addObject("pageVO", pageVO);
		return mav;
	}
	
	
	@RequestMapping(value="/manufacSearch/serchBymanufacLoc", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public Map<Integer, Map<String, Object>> serchByLoc(@RequestParam("loc") String loc,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(loc);
		System.out.println("Manufac controller");
		List<ManufacVO> manufacList= new ArrayList<ManufacVO>();
		manufacList = service.serchByManuLoc(loc);
		Map<Integer, Map<String, Object>> map = new HashMap<Integer, Map<String,Object>>();
		for(int i =0; i<manufacList.size(); i++) {
			map.put(i,putMapManufac(i,manufacList));
		}
		return map;
	}
	
	@RequestMapping(value="/manufacSearch/serchByManuType", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public Map<Integer, Map<String, Object>> serchByManuType(@RequestParam("manuType") String manuType,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(manuType);
		System.out.println("Manufac controller");
		List<ManufacVO> manufacList= new ArrayList<ManufacVO>();
		manufacList = service.serchByManuType(manuType);
		Map<Integer, Map<String, Object>> map = new HashMap<Integer, Map<String,Object>>();
		for(int i =0; i<manufacList.size(); i++) {
			map.put(i,putMapManufac(i,manufacList));
		}
		System.out.println(manufacList);
		return map;
	}
	
	@RequestMapping(value="/manufacSearch/serchByPrice", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public Map<Integer, Map<String, Object>> serchByManuMinimumPrice(@RequestParam("price") String price,HttpServletRequest request, HttpServletResponse response) {
//		price += "0000";
		int iPrice = Integer.parseInt(price);
		System.out.println(iPrice);
		System.out.println("Manufac controller");
		List<ManufacVO> manufacList= new ArrayList<ManufacVO>();
		manufacList = service.serchByManuMinimumPrice(iPrice);
		Map<Integer, Map<String, Object>> map = new HashMap<Integer, Map<String,Object>>();
		for(int i =0; i<manufacList.size(); i++) {
			map.put(i,putMapManufac(i,manufacList));
		}
		return map;
	}
	
	@RequestMapping(value="/manufacSearch/viewManufac", method= RequestMethod.GET)
	@Override
	public ModelAndView viewManufac(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(id);
		System.out.println("Manufac View");
		String viewName = (String) request.getAttribute("viewName");
		manufacVO = service.viewManuFac(id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("manufacVO", manufacVO);
		System.out.println(mav);
		return mav;
	}
	
	public Map<String, Object> putMapManufac(int i,List<ManufacVO> manufacList){
		Map<String, Object> manufac = new HashMap<String, Object>();
		String id = manufacList.get(i).getId();
		manufac.put("id", id);
		String pwd = manufacList.get(i).getPwd();
		manufac.put("pwd", pwd);
		String name = manufacList.get(i).getManuName();
		manufac.put("name", name);
		String ceoName = manufacList.get(i).getManuCeoName();
		manufac.put("ceoName", ceoName);
		String email = manufacList.get(i).getManuEmail();
		manufac.put("email", email);
		String bizNo = manufacList.get(i).getManuBizNo();
		manufac.put("bizNo",bizNo);
		String bizType = manufacList.get(i).getManuBizType();
		manufac.put("bizType",bizType);
		String addr = manufacList.get(i).getManuAddr();
		manufac.put("addr",addr);
		String detailAddr = manufacList.get(i).getManuDetailAddr();
		manufac.put("detailAddr",detailAddr);
		String tel = manufacList.get(i).getManuTel();
		manufac.put("tel",tel);
		String start = manufacList.get(i).getManuStart();
		manufac.put("start",start);
		String detail = manufacList.get(i).getManuDetail();
		manufac.put("detail",detail);
		String img = manufacList.get(i).getManuImg();
		manufac.put("img",img);
		int price = manufacList.get(i).getProductPrice();
		manufac.put("price",price);
		String auth = manufacList.get(i).getManuAuth();
		manufac.put("auth",auth);
		String Type = manufacList.get(i).getType();
		manufac.put("Type", Type);
		return manufac;
	}
}
