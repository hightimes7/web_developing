package com.spring.plt.expert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.expert.dao.ExpertDAO;
import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;

@Service("expertService")
public class ExpertServiceImpl implements ExpertService {

	@Autowired
	private ExpertDAO expertDAO;
	
	@Override
	public ExpertVO login(ExpertVO expertVO) throws Exception {
		ExpertVO expertMember = expertDAO.loginById(expertVO);
		if(expertMember != null) {
		expertDAO.insertLoginLog(expertVO);
		}
		return expertDAO.loginById(expertVO);
	}	
		
	public int join_expert(Map expertMap) throws Exception{
		int result = expertDAO.join_expert(expertMap);
		expertDAO.insertExpImage(expertMap);
		return result;
	}

	@Override
	public List<ExpertVO> expertList() throws DataAccessException{
		List<ExpertVO> expertList = expertDAO.expertList();
		return expertList;
	}

	public int deleteexpert(String id) throws DataAccessException {
		return expertDAO.deleteexpert(id);
	}

	public int updateexpert(Map<String, Object> expMap) throws Exception{
	      ExpImageVO expImageVO = (ExpImageVO) expMap.get("imageFile");
	      ExpertVO expert = expertDAO.expertselect((String)expMap.get("id"));
	      expertDAO.insertExpEdit(expert);
	      if(expImageVO.getImageFileName() != null) {
	         expertDAO.updateExpImage(expMap);         
	      }
	      
	      return expertDAO.updateexpert(expMap);
	   }

	@Override
	public Map expertselect(String id) throws Exception{
		Map expMap = new HashMap();
		ExpertVO expert = expertDAO.expertselect(id);
		List<ExpImageVO> imageFileList = expertDAO.selectImageFileList(id);
		expMap.put("expertVO", expert);
		expMap.put("imageFileList", imageFileList);
		return expMap;
	}
	
	public int overlapCheck(String id) throws Exception{
		int count = 0;
		count = expertDAO.overlapCheck(id);
		return count;
	}
	
	
	

}
