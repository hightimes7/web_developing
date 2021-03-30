package com.spring.plt.adminQnA.controller;

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

import com.spring.plt.adminQnA.service.AdminQnAService;
import com.spring.plt.adminQnA.vo.AdminQnAVO;

@Controller("adminQnAController")
public class AdminQnAControllerImpl implements AdminQnAController{
	@Autowired
	private AdminQnAService adminQnAService;
	@Autowired
	private AdminQnAVO adminQnAVO;
	
	@RequestMapping(value="/adminQnA/listArticles.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listArticles(@RequestParam(value="section", required=false) String section, @RequestParam(value="pageNum", required=false) String pageNum,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		int ISection = Integer.parseInt(((section == null) ? "1" : section));
		int IPageNum = Integer.parseInt(((pageNum == null) ? "1" : pageNum));
		Map<String, Integer> pagingMap = new HashMap<String, Integer>();
		pagingMap.put("section", ISection);
		pagingMap.put("pageNum", IPageNum);
		Map articlesMap = adminQnAService.listArticles(pagingMap);
		articlesMap.put("section", ISection);
		articlesMap.put("pageNum", IPageNum);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("articlesMap", articlesMap);
		return mav;
	}
	
	@RequestMapping(value="/adminQnA/*Form.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Form(@ModelAttribute("adminQnAVO") AdminQnAVO adminQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("adminQnAVO", adminQnAVO);
		return mav;
	}
	
	@RequestMapping(value="/adminQnA/addReplyForm.do", method=RequestMethod.GET)
	public ModelAndView addReplyForm(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		adminQnAVO = adminQnAService.viewArticle(no);
		mav.addObject("article", adminQnAVO);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/adminQnA/insertArticle.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addNewArticle(@ModelAttribute AdminQnAVO adminQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("addNewArticle: "+ adminQnAVO);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			adminQnAService.addNewArticle(adminQnAVO);
			message = "<script>";
			message += " alert('질문이 정상적으로 등록되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다..');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/articleForm.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="/adminQnA/addReply.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addReply(@ModelAttribute AdminQnAVO adminQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String message;
		int no = adminQnAVO.getNo();
		adminQnAVO.setParentNO(no);
		adminQnAVO.setNo(0);
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			adminQnAService.addNewArticle(adminQnAVO);
			message = "<script>";
			message += " alert('답변이 정상적으로 등록되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/articleForm.do';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="/adminQnA/updateArticle.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity updateArticle(@ModelAttribute AdminQnAVO adminQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("COntent-Type", "text/html; charset=utf-8");
		try {
			adminQnAService.updateArticle(adminQnAVO);
			message = "<script>";
			message += " alert('글이 정상적으로 수정되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/viewArticle.do?no="+adminQnAVO.getNo()+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="/adminQnA/deleteArticle.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity deleteArticle(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			adminQnAService.deleteArticle(no);
			message = "<script>";
			message += " alert('글이 정상적으로 삭제되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/listArticles.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = " <script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/adminQnA/viewArticle.do?no="+no+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="/adminQnA/viewArticle.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam("no") int no, @RequestParam("level") int level,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		adminQnAVO = adminQnAService.viewArticle(no);
		adminQnAVO.setLvl(level);
		System.out.println("viewArticle, qnaVO: "+adminQnAVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("article", adminQnAVO);
		return mav;
	}
	
}
