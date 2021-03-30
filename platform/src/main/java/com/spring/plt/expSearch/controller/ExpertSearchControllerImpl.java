package com.spring.plt.expSearch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.expSearch.service.ExpertSearchService;
import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.page.vo.PageVO;

@Controller("expertSearchController")
public class ExpertSearchControllerImpl implements ExpertSearchController{
	@Autowired
	ExpertSearchService service;
	
	@Autowired
	ExpertVO expertVO;
	
	@RequestMapping(value="/expSearch/allExpert")
	@Override
	public ModelAndView allExpert(PageVO pageVO, @RequestParam(value="nowPage",required = false) String nowPage, @RequestParam(value="cntPerPage", required = false) String cntPerPage, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		request.setCharacterEncoding("utf-8");
        response.setContentType("html/text;charset=utf-8");
        int total = service.listCount();
        if(nowPage == null && cntPerPage == null) {
            nowPage = "1";
            cntPerPage = "9";
        }else if(nowPage == null) {
            nowPage = "1";
        }else if(cntPerPage == null) {
            cntPerPage = "9";
        } 
        System.out.println(cntPerPage + " " + nowPage);
        pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));

		System.out.println(viewName);
		System.out.println("expert Controller allExpert");
//		List<ExpertVO> expertList = new ArrayList<ExpertVO>();
		Map<String, Object> expMap = new HashMap<String, Object>();
		expMap = service.allExpert(pageVO);
//		expertList = service.allExpert(pageVO);
		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("expertList", expertList);
		mav.addObject("expMap", expMap);
		mav.addObject("pageVO", pageVO);
		return mav;
	}
	
	@RequestMapping(value="/serchByExpertName",method = RequestMethod.GET)
	@Override
	@ResponseBody
	public Map<Integer, Map<String, Object>> serchByExpertName(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("expert Controller serchByExpertName");
		List<ExpertVO> expertList = new ArrayList<ExpertVO>();
		expertList = service.serchByExpertName(name);
		System.out.println(expertList);
		Map<Integer,Map<String,Object>> map = new HashMap<Integer,Map<String,Object>>();
		for(int i = 0; i<expertList.size(); i++) {
			map.put(i,putMapExpert(i,expertList));
		}
		System.out.println(expertList);
		return map;
	}
	
	@RequestMapping(value="/serchByExpertType", method = RequestMethod.GET)
	@Override
	@ResponseBody
	public Map<Integer,Map<String,Object>> serchByExpertType(@RequestParam("type") String type, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("expert Controller serchByExpertType");
		List<ExpertVO> expertList = new ArrayList<ExpertVO>();
		expertList = service.serchByExpertType(type);
		Map<Integer,Map<String,Object>> map = new HashMap<Integer,Map<String,Object>>();
		for(int i = 0; i<expertList.size(); i++) {
			map.put(i,putMapExpert(i,expertList));
		}
		System.out.println(expertList);
		return map;
	}
	
	
	@RequestMapping(value="/serchByExpertImgFile")
	@Override
	@ResponseBody
	public String serchByExpertImgFile(@RequestParam("expertId") String expertId, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("find image file Controller");
		System.out.println(expertId + "  매개변수 확인 controller");
		String fileName = service.serchByExpertImgFile(expertId);
		return fileName;
	}
	
	
	@RequestMapping(value="/expSearch/viewExpert", method = RequestMethod.GET)
	@Override
	public ModelAndView viewExpert(String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		System.out.println("expert Controller serchByExpertType");
		id = request.getParameter("id");
		System.out.println(id + "  <==id");
		Map<String, Object> expMap = new HashMap<String, Object>();
		List<ExpImageVO> expImageList = service.getExpertImageList(id); 
		expertVO = service.viewExpert(id);
		System.out.println(expertVO);
		expMap.put("expertVO", expertVO);
		expMap.put("expImageList", expImageList);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expMap", expMap);
		System.out.println(mav);
		return mav;
	}
	
	
	public Map<String, Object> putMapExpert(int i,List<ExpertVO> expertList){
		Map<String, Object> expert = new HashMap<String, Object>();
		String id = expertList.get(i).getId();
		expert.put("id", id);
		String pwd = expertList.get(i).getPwd();
		expert.put("pwd", pwd);
		String name = expertList.get(i).getExpName();
		expert.put("name", name);
		String email = expertList.get(i).getExpEmail();
		expert.put("email", email);
		String tel = expertList.get(i).getExpTel();
		expert.put("tel",tel);
		String type = expertList.get(i).getExpBizField();
		expert.put("type",type);
		String carreer = expertList.get(i).getExpCareer();
		expert.put("carreer",carreer);
		String detail = expertList.get(i).getExpDetail();
		expert.put("detail",detail);
		String auth = expertList.get(i).getExpAuth();
		expert.put("auth",auth);
		return expert;
	}
}
