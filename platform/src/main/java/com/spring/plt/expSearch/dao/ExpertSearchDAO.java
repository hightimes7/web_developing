package com.spring.plt.expSearch.dao;

import java.util.List;
import java.util.Map;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;
import com.spring.plt.page.vo.PageVO;

public interface ExpertSearchDAO {
	public List<ExpertVO> serchByExpertName(String name);
	public ExpertVO viewExpert(String id);
	public List<ExpertVO> allExpert(PageVO pageVO);
	public List<ExpImageVO> allExpertImg() throws Exception;
	public int listCount();
	public List<ExpImageVO> getExpertImageList(String id);
	public List<ExpertVO> serchByExpertType(String type);
	public List<ExpImageVO> serchByExpertImgFile(String Id);
}
