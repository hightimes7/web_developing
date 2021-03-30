package com.spring.plt.adminQnA.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.adminQnA.vo.AdminQnAVO;

public interface AdminQnAController {
	public ModelAndView listArticles(@RequestParam(value="section", required=false) String section, @RequestParam(value="pageNum", required=false) String pageNum,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addNewArticle(@ModelAttribute AdminQnAVO adminQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addReplyForm(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewArticle(@RequestParam("articleNO") int articleNO, @RequestParam("level") int level,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity updateArticle(@ModelAttribute AdminQnAVO adminQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity deleteArticle(@RequestParam("articleNO") int articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
