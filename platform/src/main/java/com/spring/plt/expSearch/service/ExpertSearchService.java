package com.spring.plt.expSearch.service;

import java.util.List;
import java.util.Map;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.page.vo.PageVO;

public interface ExpertSearchService {
	public List<ExpertVO> serchByExpertName(String name);
	public ExpertVO viewExpert(String id);
	public Map<String, Object> allExpert(PageVO pageVO) throws Exception;
	public int listCount();
	public List<ExpImageVO> getExpertImageList(String id);
	public List<ExpertVO> serchByExpertType(String type);
	public String serchByExpertImgFile(String expertId);
}
