package com.spring.plt.notice.controller;

import java.util.List;

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

import com.spring.plt.notice.service.NoticeService;
import com.spring.plt.notice.vo.NoticePageVO;
import com.spring.plt.notice.vo.NoticeVO;

@Controller("noticeController")
public class NoticeControllerImpl {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeVO noticeVO;
	
	@RequestMapping(value="notice/*Form.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView Form(@ModelAttribute("notice") NoticeVO notice, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		System.out.println("controller: "+viewName);
		System.out.println("notice: "+notice);
		ModelAndView mav = new ModelAndView();
		mav.addObject("notice", notice);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="notice/noticeList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView noticeList(NoticePageVO pageVO, @RequestParam(value="nowPage", required=false) String nowPage,
			@RequestParam(value="cntPerPage", required=false) String cntPerPage,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		int total = noticeService.listCount();
		if(nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		}else if(nowPage == null) {
			nowPage = "1";
		}else if(cntPerPage == null) {
			cntPerPage = "10";
		}
		pageVO = new NoticePageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		ModelAndView mav = new ModelAndView();
		List<NoticeVO> noticeList = noticeService.getNoticeList(pageVO);
		System.out.println("noticeList: "+noticeList);
		mav.setViewName(viewName);
		mav.addObject("noticeList", noticeList);
		mav.addObject("pageVO", pageVO);
		return mav;
	}
	
	@RequestMapping(value="notice/writeNotice.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity writeNotice(@ModelAttribute("notice") NoticeVO notice, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("notice: "+notice);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = noticeService.writeNotice(notice);
			message = "<script>";
			message += " alert('공지사항이 정상적으로 작성되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/notice/noticeList.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/notice/writeNoticeForm.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="notice/viewNotice.do", method=RequestMethod.GET)
	public ModelAndView viewNotice(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viweName = (String) request.getAttribute("viewName");
		noticeVO = noticeService.selectNotice(no);
		noticeService.cntPlus(no);
		System.out.println("noticeVO(viewNotice): "+noticeVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viweName);
		mav.addObject("notice", noticeVO);
		return mav;
	}
	
	@RequestMapping(value="notice/updateNotice.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity updateNotice(@ModelAttribute("notice") NoticeVO notice, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("notice: "+notice);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		int no=notice.getNo();
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = noticeService.updateNotice(notice);
			message = "<script>";
			message += " alert('공지사항이 정상적으로 수정되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/notice/viewNotice.do?no="+no+"';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/notice/noticeList.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="notice/deleteNotice.do", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity deleteNotice(@RequestParam("no")int no, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			int result = noticeService.deleteNotice(no);
			message = "<script>";
			message += " alert('공지사항이 정상적으로 삭제되었습니다.');";
			message += " location.href='"+request.getContextPath()+"/notice/noticeList.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			message = "<script>";
			message += " alert('오류가 발생했습니다.');";
			message += " location.href='"+request.getContextPath()+"/notice/noticeList.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
}
