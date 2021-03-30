package com.spring.plt.message.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.message.vo.MessageVO;

public interface MessageController {
	public ResponseEntity send(@ModelAttribute("message") MessageVO message, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView messageList(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public int deleteMessage(@RequestParam("arr") String[] arr,	HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView search(@RequestParam("id") String id, @RequestParam("catetory") String catetory, @RequestParam("keyword") String keyword,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView readMessage(@RequestParam("messageNO") String messageNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public int unReadCount(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
