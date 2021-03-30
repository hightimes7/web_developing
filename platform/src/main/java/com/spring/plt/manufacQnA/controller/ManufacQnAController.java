package com.spring.plt.manufacQnA.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.plt.manufacQnA.vo.ManufacQnAVO;

public interface ManufacQnAController {
	public @ResponseBody ArrayList<HashMap> getManufacQnAList(@RequestParam("manuId") String manuId, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String addQue(@ModelAttribute("manufacQnAVO") ManufacQnAVO manufacQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ResponseEntity addAnswer(@ModelAttribute("manufacQnAVO") ManufacQnAVO manufacQnAVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String modPro(@RequestParam("content") String content, @RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public String delPro(@RequestParam("no") int no, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
