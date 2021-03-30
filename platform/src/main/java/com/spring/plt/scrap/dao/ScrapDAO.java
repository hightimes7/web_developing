package com.spring.plt.scrap.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.scrap.vo.ScrapVO;

public interface ScrapDAO {
	//?�읈�눧硫�? 4揶쏆뮆彛� �빊�뮆�젾
		public List<ScrapVO> printExpertScrap(String compId) throws DataAccessException;
		
		//?�읈�눧硫�? * �빊�뮆�젾
		public List<ScrapVO> printExpertScrapAll(Map compMap) throws DataAccessException;

		
		//?�젫鈺곌퀣毓쏙㎗? 4揶쏆뮆彛� �빊�뮆�젾
		public List<ScrapVO> printManuScrap(String compId) throws DataAccessException;
		
		//?�젫鈺곌퀣毓쏙㎗? * �빊�뮆�젾
		public List<ScrapVO> printManuScrapAll(Map compMap) throws DataAccessException;
			
		//insert scrap
		public void scrapExpert(ScrapVO scrapVO) throws DataAccessException;
		
		public void scrapManu(ScrapVO scrapVO) throws DataAccessException;
			
		//delete scrap
		public int deleteExpertScrap(int no) throws DataAccessException;

		public int deleteManuScrap(int no) throws DataAccessException;

		public int listCount(String compId) throws Exception;
		
		public int listExpScrapCount(String compId) throws Exception;

		public int isOverlapE(Map overlap) throws Exception;

		public int isOverlapM(Map overlap) throws Exception;

		public List<ExpImageVO> getExpImage() throws Exception;
		
}
