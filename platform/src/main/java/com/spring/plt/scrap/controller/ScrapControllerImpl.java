package com.spring.plt.scrap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.page.vo.PageVO;
import com.spring.plt.scrap.service.ScrapService;
import com.spring.plt.scrap.vo.ScrapVO;

@Controller("scrapController")
public class ScrapControllerImpl implements ScrapController{
	@Autowired
	private ScrapService scrapService;
	@Autowired
	private ScrapVO scrapVO;
	
	
//	compId占쎈ご? �슖�돦裕꾬옙�쟽?占쎈데 ?占쎈쐩 session?�굢占�?�땻占� �뛾�룇猷뉔뇡占�?占쎄텕?占쎈츎 �뇦猿됲뜑占쎈さ�슖占�? ?占쎈빢?占쎌젧?�뜮占�?�뜮占�?�뜮占�?占쎈퉵?占쎈펲  - parent key ?占쎄텕占쎈ご?
	
//	scrap占쎈퉲占쎈츊占쎌졑
	//?占쎌쓧占쎈닱筌롳옙? * 占쎈퉲占쎈츊占쎌졑
	@Override
	@RequestMapping(value="/scrap/printExpertScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printExpertScrapAll(PageVO pageVO, @RequestParam(value="nowPage", required = false) String nowPage, @RequestParam(value="cntPerPage", required=false)String cntPerPage,
			@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		
//		paging code
		int total = scrapService.listExpScrapCount(compId);
	    if(nowPage == null && cntPerPage == null) {
	        nowPage = "1";
	        cntPerPage = "8";
	    }else if(nowPage == null) {
	        nowPage = "1";
	    }else if(cntPerPage == null) {
	        cntPerPage = "8";
	    } //nowPage ?占쎄껑?占쎌궨 ?占쎌쓡?占쎈턄嶺뚳옙?, cntPerPage = ?�뇡占�?占쎌쓡?占쎈턄嶺뚳옙??占쎈샬 �뼨占�? �뤆�룇裕뉛옙�빢
	    pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	    Map compMap = new HashMap();
	    compMap.put("compId", compId);//占쎄쉭占쎈�∽옙肉됵옙苑� 揶쏉옙占쎌죬占쎌궞野껓옙
	    compMap.put("pageVO", pageVO);
	    Map<String, Object> expMap = new HashMap<String, Object>();
		expMap = scrapService.printExpertScrapAll(compMap);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("expMap", expMap);
		mav.addObject("pageVO", pageVO);
		return mav;		
	}
	
	
	@Override
	@RequestMapping(value="/scrap/printManuScrap.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printManuScrapAll(PageVO pageVO, @RequestParam(value="nowPage", required = false) String nowPage,
			@RequestParam(value="cntPerPage", required=false)String cntPerPage, 
			@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		
		HttpSession session = request.getSession();
		
//		paging code
		int total = scrapService.listCount(compId);
	    if(nowPage == null && cntPerPage == null) {
	        nowPage = "1";
	        cntPerPage = "8";
	    }else if(nowPage == null) {
	        nowPage = "1";
	    }else if(cntPerPage == null) {
	        cntPerPage = "8";
	    } //nowPage ?占쎄껑?占쎌궨 ?占쎌쓡?占쎈턄嶺뚳옙?, cntPerPage = ?�뇡占�?占쎌쓡?占쎈턄嶺뚳옙??占쎈샬 �뼨占�? �뤆�룇裕뉛옙�빢
	    pageVO = new PageVO(total, Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
	    Map compMap = new HashMap();
	    compMap.put("compId", compId);
	    compMap.put("pageVO", pageVO);
		List manuScrapAllList = scrapService.printManuScrapAll(compMap);
		System.out.println("manuScrapAllList: "+ manuScrapAllList);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("manuScrapAllList", manuScrapAllList);
		mav.addObject("pageVO", pageVO);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/scrap/printScrapAll.do",method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView printScrapAll(@RequestParam("compId") String compId,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		Map allScrapMap = scrapService.printScrap(compId);
		Map<String, Object> expMap = scrapService.printExpertScrap(compId);
		List manuScrapList = scrapService.printManuScrap(compId);
		System.out.println("manuScrapList: "+manuScrapList);
		ModelAndView mav = new ModelAndView(viewName);
//		mav.addObject("expertScrapList", expertScrapList);
		mav.addObject("expMap", expMap);
		mav.addObject("manuScrapList", manuScrapList);
		mav.addObject("allScrapMap", allScrapMap);
		return mav;
	}
	
	//insert scrap
	@Override
	@RequestMapping(value="/scrap/scrapExpert.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity scrapExpert(@RequestParam("expId") String expId, @RequestParam("compId") String compId,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		Map overlap = new HashMap();
		overlap.put("compId", compId);
		overlap.put("expId", expId);		
		int Overlapped = scrapService.isOverlapE(overlap);
		if(compId == null || compId == "") {
			message = "<script>";
			message += " alert('로그인 후 이용해주세요.');";
			message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		else {
			if(Overlapped == 0) {
				try {
					scrapVO.setCompid(compId);
					scrapVO.setExpid(expId);
					scrapService.scrapExpert(scrapVO);
					message = "<script>";
					message += " alert('스크랩 되었습니다.');";
					message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
					message += "</script>";
					resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				}catch(Exception e) {
					message = "<script>";
					message += " alert('스크랩하지 못했습니다.');";
					message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
					message += "</script>";
					resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				}
			}
			else {
				message = "<script>";
				message += " alert('이미 스크랩된 항목입니다.');";
				message += " location.href='"+request.getContextPath()+"/expSearch/allExpert.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}
		}
		return resEnt;
	}
	
	@Override
	@RequestMapping(value="/scrap/scrapManu.do", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity scrapManu(@RequestParam("manuId") String manuId, @RequestParam("compId") String compId,
							HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		Map overlap = new HashMap();
		overlap.put("compId", compId);
		overlap.put("manuId", manuId);
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		int Overlapped = scrapService.isOverlapM(overlap);
		if(compId == null || compId == "") {
			message = "<script>";
			message += " alert('로그인 후 이용해주세요.');";
			message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}
		else {
			if(Overlapped == 0) {
				try {
					scrapVO.setCompid(compId);
					scrapVO.setManuid(manuId);
					scrapService.scrapManu(scrapVO);
					message = "<script>";
					message += " alert('스크랩 되었습니다.');";
					message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
					message += "</script>";
					resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				}catch(Exception e) {
					message = "<script>";
					message += " alert('스크랩하지 못했습니다.');";
					message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
					message += "</script>";
					resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
				}
			}	
			else {
				message = "<script>";
				message += " alert('이미 스크랩된 항목입니다.');";
				message += " location.href='"+request.getContextPath()+"/manufacSearch/allManufac.do';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			}
		}
		return resEnt;
	}


	//delete scrap
	@Override
	@RequestMapping(value="/scrap/deleteExpertScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity deleteExpertScrap(@RequestParam("compId")String compId, @RequestParam("no") int no, 
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String message;
		scrapService.deleteExpertScrap(no);
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		message = "<script>";
		message += " alert('스크랩 삭제되었습니다.');";
		message += " location.href='"+request.getContextPath()+"/scrap/printExpertScrap.do?compId="+compId+"';";
		message += "</script>";
		
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		
//		String compId = "compId";
		
//		ModelAndView mav = new ModelAndView("redirect:/scrap/printExpertScrap.do?compId=" + compId);
		return resEnt;
		
		
	}
	
	@Override
	@RequestMapping(value="/scrap/deleteManuScrap.do", method={RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity deleteManuScrap(@RequestParam("compId")String compId, @RequestParam("no") int no, 
						HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");		
		String message;
		scrapService.deleteManuScrap(no);
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		message = "<script>";
		message += " alert('스크랩 삭제되었습니다.');";
		message += " location.href='"+request.getContextPath()+"/scrap/printManuScrap.do?compId="+compId+"';";
		message += "</script>";
		
		resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
//		ModelAndView mav = new ModelAndView("redirect:/scrap/printManuScrap.do?compId=" + compId);
		return resEnt;
	}

}
