package com.spring.plt.manufacQnA.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.manufacQnA.service.ManufacQnAService;
import com.spring.plt.manufacQnA.vo.ManufacQnAVO;


@Controller("manufacQnAController")
public class ManufacQnAControllerImpl implements ManufacQnAController{
	@Autowired
	private ManufacQnAService manufacQnAService;
	
	@RequestMapping(value="manufacQnA/getManufacQnAList.do", method= {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ArrayList<HashMap> getManufacQnAList(@RequestParam("manuId") String manuId, HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		try {
			List<ManufacQnAVO> manufacQnAList = manufacQnAService.getList(manuId);
			if(manufacQnAList.size() > 0) {
				for(int i=0; i<manufacQnAList.size(); i++) {
					HashMap pl = new HashMap();
					pl.put("level", manufacQnAList.get(i).getLevel());
					pl.put("no", manufacQnAList.get(i).getNo());
					pl.put("id", manufacQnAList.get(i).getId());
					pl.put("content", manufacQnAList.get(i).getContent());
					pl.put("writeDate", manufacQnAList.get(i).getWriteDate());
					pl.put("manuId", manufacQnAList.get(i).getManuId());
					list.add(pl);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="manufacQnA/addManufacQnAQue.do", method=RequestMethod.POST)
	@ResponseBody
	public String addQue(@ModelAttribute("manufacQnAVO") ManufacQnAVO manufacQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		try {
			int result = manufacQnAService.addQue(manufacQnAVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="manufacQnA/addManufacQnAAnswer.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addAnswer(@ModelAttribute("manufacQnAVO") ManufacQnAVO manufacQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html; charset=utf-8");
		int no = manufacQnAVO.getNo();
		manufacQnAVO.setParentNO(no);
		manufacQnAVO.setNo(0);
		String manuId = manufacQnAVO.getManuId();
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = manufacQnAService.addAnswer(manufacQnAVO);
			message = "<script>";
			message += " alert('답변이 작성되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/manufacSearch/viewManufac.do?id="+manuId+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/manufacSearch/viewManufac.do?id="+manuId+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="manufacQnA/modManufacQnA.do", method=RequestMethod.POST)
	@ResponseBody
	public String modPro(@RequestParam("content") String content, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("content", content);
		proMap.put("no", no);
		try {
			int result = manufacQnAService.modManufacQnA(proMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="manufacQnA/delManufacQnA.do", method=RequestMethod.POST)
	@ResponseBody
	public String delPro(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			int result = manufacQnAService.delManufacQnA(no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
