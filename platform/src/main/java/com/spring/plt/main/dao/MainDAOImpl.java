package com.spring.plt.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.manufac.vo.ManufacVO;

@Repository("mainDAO")
public class MainDAOImpl implements MainDAO {
   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public List<ManufacVO> manumain() throws Exception {
      List<ManufacVO> manu = sqlSession.selectList("mapper.manufac.manufacList");
      return manu;
   }

   @Override
   public List<ExpertVO> expertmain() throws Exception {
      List<ExpertVO> expert = sqlSession.selectList("mapper.expert.expertList");
      return expert;
   }
   
   public List<ExpImageVO> expertImgMain() throws Exception{
	   List<ExpImageVO> expertImg = sqlSession.selectList("mapper.expert.selectAllImageFileList");
	   return expertImg;
   }
   
   
}