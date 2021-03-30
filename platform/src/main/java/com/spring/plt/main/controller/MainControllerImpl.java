package com.spring.plt.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.main.service.MainService;
import com.spring.plt.manufac.vo.ManufacVO;

@Controller("mainController")
@EnableAspectJAutoProxy
public class MainControllerImpl implements MainController {

   @Autowired
   private MainService mainService;
      
   @Override
   @RequestMapping(value= {"/", "main/main.do"} , method= {RequestMethod.GET, RequestMethod.POST})
      public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{
      List<ManufacVO> manu = mainService.manumain();
      Map<String, Object> expMap = new HashMap<String, Object>();
      expMap = mainService.expertMain();
     
      String viewName = (String)request.getAttribute("viewName");
      
      ModelAndView mav = new ModelAndView();
      
      mav.addObject("manufacVO", manu);
      mav.addObject("expMap", expMap);
      mav.setViewName(viewName);
      
      return mav;
      
   }
   

   
}