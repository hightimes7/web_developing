package com.spring.plt.expSearch.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.plt.expSearch.dao.ExpertSearchDAO;
import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.page.vo.PageVO;

@Service("expertSearchService")
public class ExpertSearchServiceImpl implements ExpertSearchService{
	@Autowired
	ExpertSearchDAO dao;
	
	@Override
	public List<ExpertVO> serchByExpertName(String name) {
		System.out.println("expert Service name");
		return dao.serchByExpertName(name);
	}

	@Override
	public List<ExpertVO> serchByExpertType(String type) {
		System.out.println("expert Service type");
		return dao.serchByExpertType(type);
	}
	
	@Override
	public String serchByExpertImgFile(String expertId) {
		System.out.println("expert find fileName service");
		List<ExpImageVO> expImageList = dao.serchByExpertImgFile(expertId);
		return expImageList.get(1).getImageFileName();
	}
	
	
	@Override
	public ExpertVO viewExpert(String id) {
		System.out.println("expert service view");
		return dao.viewExpert(id);
	}

	@Override
	public Map<String, Object> allExpert(PageVO pageVO) throws Exception {
		System.out.println("expert Service all");
		Map<String, Object> expMap = new HashMap<String, Object>();
		List<ExpertVO> expertList = dao.allExpert(pageVO);
		List<ExpImageVO> expertImgList = dao.allExpertImg();
		for(int i=0; i<expertImgList.size(); i++) {
			if(expertImgList.get(i).getImageFileNO() % 2 ==1) {
				expertImgList.remove(expertImgList.get(i));
			}
		}
		expMap.put("expertList", expertList);
		expMap.put("expertImgList", expertImgList);
		return expMap;
	}

	@Override
	public int listCount() {
		return dao.listCount();
	}

	@Override
	public List<ExpImageVO> getExpertImageList(String id) {
		return dao.getExpertImageList(id);
	}

	
}
