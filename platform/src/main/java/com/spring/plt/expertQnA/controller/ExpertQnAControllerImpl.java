package com.spring.plt.expertQnA.controller;

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

import com.spring.plt.expertQnA.service.ExpertQnAService;
import com.spring.plt.expertQnA.vo.ExpertQnAVO;

@Controller("expertQnAController")
public class ExpertQnAControllerImpl implements ExpertQnAController{
	@Autowired
	private ExpertQnAService expertQnAService;
	
	@RequestMapping(value="expertQnA/getExpertQnAList.do", method= {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody ArrayList<HashMap> getManufacQnAList(@RequestParam("expId") String expId, HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		try {
			List<ExpertQnAVO> expertQnAList = expertQnAService.getList(expId);
			if(expertQnAList.size() > 0) {
				for(int i=0; i<expertQnAList.size(); i++) {
					HashMap pl = new HashMap();
					pl.put("level", expertQnAList.get(i).getLevel());
					pl.put("no", expertQnAList.get(i).getNo());
					pl.put("id", expertQnAList.get(i).getId());
					pl.put("content", expertQnAList.get(i).getContent());
					pl.put("writeDate", expertQnAList.get(i).getWriteDate());
					pl.put("expId", expertQnAList.get(i).getExpId());
					list.add(pl);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value="expertQnA/addExpertQnAQue.do", method=RequestMethod.POST)
	@ResponseBody
	public String addQue(@ModelAttribute("expertQnAVO") ExpertQnAVO expertQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		try {
			int result = expertQnAService.addQue(expertQnAVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="expertQnA/addExpertQnAAnswer.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addAnswer(@ModelAttribute("expertQnAVO") ExpertQnAVO expertQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("text/html; charset=utf-8");
		int no = expertQnAVO.getNo();
		expertQnAVO.setParentNO(no);
		expertQnAVO.setNo(0);
		String expId = expertQnAVO.getExpId();
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = expertQnAService.addAnswer(expertQnAVO);
			message = "<script>";
			message += " alert('답변이 작성되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/expSearch/viewExpert.do?id="+expId+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/expSearch/viewExpert.do?id="+expId+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="expertQnA/modExpertQnA.do", method=RequestMethod.POST)
	@ResponseBody
	public String modPro(@RequestParam("content") String content, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		Map<String, Object> qnaMap = new HashMap<String, Object>();
		qnaMap.put("content", content);
		qnaMap.put("no", no);
		try {
			int result = expertQnAService.modExpertQnA(qnaMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(value="expertQnA/delExpertQnA.do", method=RequestMethod.POST)
	@ResponseBody
	public String delPro(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			int result = expertQnAService.delExpertQnA(no);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
