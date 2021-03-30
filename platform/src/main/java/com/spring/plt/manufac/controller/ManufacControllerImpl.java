package com.spring.plt.manufac.controller;


import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.plt.manufac.service.ManufacService;
import com.spring.plt.manufac.vo.ManufacVO;

@Controller("manufacController")
@EnableAspectJAutoProxy
public class ManufacControllerImpl implements ManufacController{
	private static String IMAGE_PATH = "C:/workspace/platform/src/main/webapp/resources/pltImage"; //�븰�썝
//	private static String IMAGE_PATH = "C:/JSP/projects/platform/src/main/webapp/resources/pltImage"; //吏�
	
	@Autowired
	private ManufacService manufacService;
	
	@Autowired
	private ManufacVO manufacVO;
	
	@Override
	@RequestMapping(value="/manufac/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") ManufacVO member, RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		manufacVO = manufacService.login(member);
		if(manufacVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", manufacVO);
			session.setAttribute("isLogOn", true);
			mav.setViewName("redirect:/main/main.do");				
			} else {
				rAttr.addAttribute("result", "loginFailed");
				mav.setViewName("redirect:/common/loginForm.do");
			}
		return mav;
	}
	
	@Override
	@RequestMapping(value="/manufac/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/main/main.do");
		return mav;
	}
	
	@RequestMapping(value="/manufac/join_manufac.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView join_manufac(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		Map<String, Object> manufacMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = request.getParameter(name);
			manufacMap.put(name, value);
		}
		String imageFileName = upload(request);
		manufacMap.put("manuImg", imageFileName);
		System.out.println(manufacMap);
		try {
			String id = (String) manufacMap.get("id");
			int result = 0;
			result = manufacService.join_manufac(manufacMap);
			if(imageFileName != null && imageFileName.length() != 0) {
				File srcFile = new File(IMAGE_PATH+"\\temp\\"+imageFileName);
				File destDir = new File(IMAGE_PATH+"\\"+id);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}
			mav.setViewName("redirect:/main/main.do");
		}catch(Exception e) {
			File srcFile = new File(IMAGE_PATH+"\\temp\\"+imageFileName);
			srcFile.delete();
			mav.setViewName("redirect:/manufac/manufacForm.do");
			e.printStackTrace();
		}
		return mav;
	}
	
	private String upload(MultipartHttpServletRequest request) throws Exception{
		String imageFileName = null;
		Iterator<String> fileNames = request.getFileNames();
		while(fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = request.getFile(fileName);
			imageFileName = UUID.randomUUID().toString()+mFile.getOriginalFilename();
			File file = new File(IMAGE_PATH+"\\"+fileName);
			if(mFile.getSize()!=0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(IMAGE_PATH+"\\temp\\"+imageFileName));
			}
		}
		return imageFileName;
	}

	@RequestMapping(value={"/manufac/manufacListForm.do","/manufac/manufacListFormo.do","/manufac/manufacListFormx.do"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView manufacList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		List<ManufacVO> manufacList = manufacService.manufacList();
		System.out.println("manufacList: "+manufacList);
		ModelAndView mav = new ModelAndView();
		mav.addObject("manufacList", manufacList);
		mav.setViewName(viewName);
		return mav;
	}


	@RequestMapping(value= {"/manufac/manufacSelectForm.do","/manufac/manufacSelectFormx.do"}, method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView manufacselect(@RequestParam("id") String id,HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		System.out.println("viewName: "+viewName);
		ManufacVO manufacselect = manufacService.manufacselect(id);
		System.out.println("expertselect: " +manufacselect);
		ModelAndView mav = new ModelAndView();
		mav.addObject("manufacVO", manufacselect);
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/manufac/deletemanufac.do", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deletemanufac(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		manufacService.deletemanufac(id);
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/manufac/manufacListForm.do");
		return mav; 
	}

	@RequestMapping(value="/manufac/updatemanufac.do", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity updatestartUp(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		Map<String, Object> manufacMap = new HashMap<String, Object>();
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = request.getParameter(name);
			manufacMap.put(name, value);
		}
		
		String manuImg = upload(request);
		manufacMap.put("manuImg", manuImg);
		
		System.out.println("-----------------manufacMap: "+manufacMap);
		
		String id = (String)manufacMap.get("id");
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			manufacService.updatemanufac(manufacMap);
			manufacVO = manufacService.manufacselect(id);
			HttpSession session = request.getSession();
			session.setAttribute("manufac", manufacVO);
			if(manuImg != null && manuImg.length() != 0) {
				File srcFile = new File(IMAGE_PATH+"\\temp\\"+manuImg);
				File destDir = new File(IMAGE_PATH+"\\"+id);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
				
				String originalFileName = (String) manufacMap.get("originalFileName");
				File oldFile = new File(IMAGE_PATH+"\\"+id+"\\"+originalFileName);
				oldFile.delete();
			}
			message = "<script>";
			message += " alert('수정 완료');";
			message += " history.go(-2);"; 
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
		}catch(Exception e) {
			File srcFile = new File(IMAGE_PATH+"\\temp\\"+manuImg);
			srcFile.delete();
			message = "<script>";
			message += " alert('입력되지 않은 사항이 있습니다');";
			message += " location.href='"+request.getContextPath()+"/manufac/manufacSelectForm.do?id="+id+"';";
			message +=" </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	
	@RequestMapping(value="manufac/*Form.do", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView Form(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="manufac/overlapCheck.do", method= RequestMethod.GET)
	@ResponseBody
	public int overlapCheck(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("1111");
		int count = 0;
		count = manufacService.overlapCheck(id);
		return count;
	}
	

}
