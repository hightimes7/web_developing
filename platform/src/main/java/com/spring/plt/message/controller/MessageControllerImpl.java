package com.spring.plt.message.controller;

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

import com.spring.plt.message.service.MessageService;
import com.spring.plt.message.vo.MessageVO;

@Controller("messageController")
public class MessageControllerImpl implements MessageController{
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private MessageVO messageVO;
	
	@RequestMapping(value="message/sendMessage.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity send(@ModelAttribute("message") MessageVO message, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println(message);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String complete;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			messageService.sendMessage(message);
			complete = "<script>";
			complete += " alert('쪽지가 정상적으로 발송되었습니다.');";
			complete += " location.href='"+request.getContextPath()+"/message/messageList.do?id="+message.getSendId()+"';";
			complete +=" </script>";
			resEnt = new ResponseEntity(complete, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			complete = "<script>";
			complete += " alert('오류가 발생했습니다.');";
			complete += " location.href='"+request.getContextPath()+"/message/messageList.do?id="+message.getSendId()+"';";
			complete +=" </script>";
			resEnt = new ResponseEntity(complete, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="message/messageList.do", method=RequestMethod.GET)
	public ModelAndView messageList(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		List<MessageVO> list = messageService.messageList(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("messageList", list);
		return mav;
	}
	
	@RequestMapping(value="message/deleteMessage.do", method=RequestMethod.POST)
	@ResponseBody
	public int deleteMessage(@RequestParam("arr") String[] arr,	HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println(arr.toString());
		try {
			for(int i=0; i < arr.length; i++) {
				if(arr[i].contains("send")) {
					String messageNO = arr[i].substring(4);
					int NO = Integer.parseInt(messageNO);
					messageService.deleteSendMessage(NO);
				}else if(arr[i].contains("receive")) {
					String messageNO = arr[i].substring(7);
					int NO = Integer.parseInt(messageNO);
					messageService.deleteReceiveMessage(NO);
				}
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	@RequestMapping(value="message/readMessage.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView readMessage(@RequestParam("messageNO") String messageNO, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String) request.getAttribute("viewName");
		int NO;
		if(messageNO.contains("send")) {
			NO = Integer.parseInt(messageNO.substring(4));
			messageVO = messageService.readSendMessage(NO);
		}else if(messageNO.contains("receive")) {
			NO = Integer.parseInt(messageNO.substring(7));
			messageVO = messageService.readReceiveMessage(NO);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("message", messageVO);
		return mav;
	}
	
	@RequestMapping(value="message/searchMessage.do", method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("id") String id, @RequestParam("catetory") String catetory, @RequestParam("keyword") String keyword,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		Map<String, String> searchMap = new HashMap<String, String>();
		searchMap.put("id", id);
		searchMap.put("category", catetory);
		searchMap.put("keyword", keyword);
		List<MessageVO> messageList = messageService.searchMessage(searchMap);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("messageList", messageList);
		return mav;
	}
	
	@RequestMapping(value="message/unReadCount.do", method=RequestMethod.GET)
	@ResponseBody
	public int unReadCount(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		int cnt = 0;
		try {
			cnt = messageService.unReadCount(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
