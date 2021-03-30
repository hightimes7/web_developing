package com.spring.plt.map.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.map.vo.MapVO;

@Controller
public class MapController {
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value="/map/viewMap.do", method = RequestMethod.GET)
	public ModelAndView viewMap(HttpServletRequest request, HttpServletResponse response) {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		List<MapVO> manuAddrList = sqlSession.selectList("mapper.map.getManuAddrList");
		mav.addObject("manuAddrList", manuAddrList);
		System.out.println(mav);
		return mav;
	}
	
	
	@RequestMapping("/map/getGeo")
	@ResponseBody
	public Map<String, String> getGeo(HttpServletRequest requset, HttpServletResponse response ){
		List<MapVO> mapVO = sqlSession.selectList("mapper.map.getGeo");
		Map<String, String> manuAddr = new HashMap<String, String>();
		
		for(int i = 0 ; i <mapVO.size(); i++) {
			try {
				if(mapVO.get(i).getManuAddr() != null) {
					manuAddr.put(mapVO.get(i).getManuName(), mapVO.get(i).getManuAddr());
				}
			} catch (Exception e) {
				System.out.println(false);
			}
		}
		System.out.println(manuAddr);
		return manuAddr;
	}
}
