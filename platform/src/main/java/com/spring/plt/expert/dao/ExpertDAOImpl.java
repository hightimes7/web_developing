package com.spring.plt.expert.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.expert.vo.ExpImageVO;
import com.spring.plt.expert.vo.ExpertVO;

@Repository("ExpertDAO")
public class ExpertDAOImpl implements ExpertDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ExpertVO loginById(ExpertVO expertVO) throws DataAccessException {
		ExpertVO vo = sqlSession.selectOne("mapper.expert.loginById", expertVO);
		return vo;
	}

	
	public int join_expert(Map expertMap) throws Exception{
		int result = sqlSession.insert("mapper.expert.join_expert", expertMap);
		return result;
	}
	
	public void insertExpImage(Map expertMap) throws DataAccessException{
		List<ExpImageVO> imageFileList = (ArrayList)expertMap.get("imageFileList");
		String id = (String) expertMap.get("id");
		int imageFileNO = selectNewImageFileNO();
		for(ExpImageVO expimage:imageFileList) {
			expimage.setImageFileNO(++imageFileNO);
			expimage.setId(id);
		}
		sqlSession.insert("mapper.expert.insertExpImage", imageFileList);
	}
	
	private int selectNewImageFileNO() throws DataAccessException{
		return sqlSession.selectOne("mapper.expert.newExpImageFileNO");
	}

	@Override
	public List<ExpertVO> expertList() throws DataAccessException {
		List<ExpertVO> expertList = sqlSession.selectList("mapper.expert.expertList");
		return expertList;
	}

	@Override
	public int deleteexpert(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.expert.deleteexpert", id);
		return result;
	}

	public int updateexpert(Map<String, Object> expMap) throws Exception{
		int result = sqlSession.update("mapper.expert.updateexpert", expMap);
		return result;
	}
	@Override
	public void updateExpImage(Map expMap) throws Exception{
		System.out.println("updateExpImage expMap: "+expMap);
		ExpImageVO imageFile = (ExpImageVO) expMap.get("imageFile");
		String id = (String)expMap.get("id");
		String expImg = (String)expMap.get("expImg");
		int no = sqlSession.selectOne("mapper.expert.selectImageFileNO", expImg);
		imageFile.setImageFileNO(no);
		imageFile.setId(id);
		sqlSession.update("mapper.expert.updateExpImage", imageFile);
	}
	@Override
	public ExpertVO expertselect(String id) throws DataAccessException {
		ExpertVO expertselect = sqlSession.selectOne("mapper.expert.expertselect", id);
		return expertselect;
	}
	
	public List<ExpImageVO> selectImageFileList(String id) throws Exception{
		List<ExpImageVO> imageFileList = null;
		imageFileList = sqlSession.selectList("mapper.expert.selectImageFileList", id);
		return imageFileList;
	}
	
	public void insertExpEdit(ExpertVO expert) throws Exception{
	      sqlSession.insert("mapper.expert.insertExpEdit", expert);
	}
	
	public void insertLoginLog(ExpertVO expert) throws Exception{
		sqlSession.insert("mapper.expert.insertLoginLog", expert);
	}
	
	public int overlapCheck(String id) throws Exception{
		int count = 0;
		count = sqlSession.selectOne("mapper.startup.overlapCheck", id);
		return count;
	}
	

}
