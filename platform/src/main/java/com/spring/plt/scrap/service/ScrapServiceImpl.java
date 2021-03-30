package com.spring.plt.scrap.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.scrap.dao.ScrapDAO;
import com.spring.plt.scrap.vo.ScrapVO;

@Service("scrapService")
public class ScrapServiceImpl implements ScrapService{
	@Autowired
	ScrapDAO scrapDAO;
	
	//scrap
	@Override
	public Map<String, Object> printExpertScrapAll(Map compMap) throws Exception{
		List<ScrapVO> expertScrapAllList = scrapDAO.printExpertScrapAll(compMap);
		List<ExpImageVO> expertImage = scrapDAO.getExpImage();
		List<ExpImageVO> expImageList = new ArrayList<ExpImageVO>();
		for(int i=0; i<expertImage.size(); i++) {
			if(expertImage.get(i).getImageFileNO() % 2 == 1) {
				expImageList.add(expertImage.get(i));
			}
		}
		Map<String, Object> expMap = new HashMap<String, Object>();
		expMap.put("expertScrapAllList", expertScrapAllList);
		expMap.put("expertImage", expImageList);
		return expMap;
	}
	
	@Override
	public Map<String, Object> printExpertScrap(String compId) throws Exception{
		List<ScrapVO> expertScrapList = scrapDAO.printExpertScrap(compId);
		List<ExpImageVO> expertImage = scrapDAO.getExpImage();
		List<ExpImageVO> expImageList = new ArrayList<ExpImageVO>();
		for(int i=0; i<expertImage.size(); i++) {
			if(expertImage.get(i).getImageFileNO() % 2 == 1) {
				expImageList.add(expertImage.get(i));
			}
		}
		Map<String, Object> expMap = new HashMap<String, Object>();
		expMap.put("expertScrapList", expertScrapList);
		expMap.put("expertImage", expImageList);
		return expMap;
	}
	
	@Override
	public List<ScrapVO> printManuScrapAll(Map compMap) throws Exception{
		List<ScrapVO> manuScrapAllList = scrapDAO.printManuScrapAll(compMap);
		return manuScrapAllList;
	}
	
	@Override
	public List<ScrapVO> printManuScrap(String compId) throws Exception{
		List<ScrapVO> manuScrapList = scrapDAO.printManuScrap(compId);
		return manuScrapList;
	}
		
	@Override
	public Map<String, List<ScrapVO>> printScrap(String compId) throws Exception{
		Map<String, List<ScrapVO>> allScrapMap = new HashMap<String, List<ScrapVO>>();
		List<ScrapVO> expertScrapList = scrapDAO.printExpertScrap(compId);
		List<ScrapVO> manuScrapList = scrapDAO.printManuScrap(compId);
		allScrapMap.put("expertScrap", expertScrapList);
		allScrapMap.put("manuScrap", manuScrapList);
		return allScrapMap;
	}
	
	//insert scrap
	@Override
	public void scrapExpert(ScrapVO scrap) throws DataAccessException{
		scrapDAO.scrapExpert(scrap);
	}

	@Override
	public void scrapManu(ScrapVO scrap) throws DataAccessException{
		scrapDAO.scrapManu(scrap);
		System.out.println("scrapService �Ϸ�");
	}

	
	//scrap delete
	@Override
	public int deleteExpertScrap(int no) throws DataAccessException{
		return scrapDAO.deleteExpertScrap(no);
	}
	
	@Override
	public int deleteManuScrap(int no) throws DataAccessException{
		return scrapDAO.deleteManuScrap(no);
	}

	public int listCount(String compId) throws Exception{
		return scrapDAO.listCount(compId);
	}
	
	public int listExpScrapCount(String compId) throws Exception{
		return scrapDAO.listExpScrapCount(compId);
	}
	
	public int isOverlapE(Map overlap) throws Exception{
		return scrapDAO.isOverlapE(overlap);
	}

	public int isOverlapM(Map overlap) throws Exception{
		return scrapDAO.isOverlapM(overlap);
	}
	

}
