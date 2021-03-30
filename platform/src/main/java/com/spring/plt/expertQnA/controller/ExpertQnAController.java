package com.spring.plt.expertQnA.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.plt.expertQnA.vo.ExpertQnAVO;

public interface ExpertQnAController {
	public @ResponseBody ArrayList<HashMap> getManufacQnAList(@RequestParam("expId") String expId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String addQue(@ModelAttribute("expertQnAVO") ExpertQnAVO expertQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addAnswer(@ModelAttribute("expertQnAVO") ExpertQnAVO expertQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String modPro(@RequestParam("content") String content, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String delPro(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
