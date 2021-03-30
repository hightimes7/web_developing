package com.spring.plt.main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.main.dao.MainDAO;
import com.spring.plt.manufac.vo.ManufacVO;

@Service("mainService")
public class MainServiceImpl implements MainService{
   @Autowired
   private MainDAO mainDAO;
   
   @Override
   public List<ManufacVO> manumain() throws Exception {
      List<ManufacVO> manu = mainDAO.manumain();
      return manu;
   }

   @Override
   public List<ExpertVO> expertmain() throws Exception {
      List<ExpertVO> expert = mainDAO.expertmain();
      return expert;
   }
   
   public Map<String, Object> expertMain() throws Exception{
	   Map<String, Object> expMap = new HashMap<String, Object>();
	   List<ExpertVO> expertList = mainDAO.expertmain();
	   List<ExpImageVO> expertImgList = mainDAO.expertImgMain();
	   for(int i=0; i<expertImgList.size(); i++) {
		   if(expertImgList.get(i).getImageFileNO() % 2 == 1)
			   expertImgList.remove(expertImgList.get(i));
	   }
	   expMap.put("expertList", expertList);
	   expMap.put("expertImgList", expertImgList);
	   return expMap;
   }
   

   
}