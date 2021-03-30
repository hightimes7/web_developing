package com.spring.plt.adminQnA.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.plt.adminQnA.vo.AdminQnAVO;

@Repository("adminQnADAO")
public class AdminQnADAOImpl implements AdminQnADAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<AdminQnAVO> selectAllArticlesList() throws Exception{
		List<AdminQnAVO> articlesList = sqlSession.selectList("mapper.adminQnA.selectAllList");
		return articlesList;
	}
	
	public List<AdminQnAVO> selectAllArticlesList(Map<String, Integer> pagingMap) throws Exception{
		System.out.println("pagingMap: "+pagingMap);
		List<AdminQnAVO> articlesList = new ArrayList<AdminQnAVO>();
		articlesList = sqlSession.selectList("mapper.adminQnA.selectAllList", pagingMap);
		return articlesList;
	}
	
	public int listCount() throws DataAccessException{
		int listCount = sqlSession.selectOne("mapper.adminQnA.listCount");
		return listCount;
	}
	
	public int insertNewArticle(AdminQnAVO adminQnAVO) throws Exception{
		int no = selectNewno();
		adminQnAVO.setNo(no);
		int result = sqlSession.insert("mapper.adminQnA.insertNewArticle", adminQnAVO);
		return result;
	}
	
	public AdminQnAVO viewArticle(int no) throws Exception{
		return sqlSession.selectOne("mapper.adminQnA.viewArticle", no);
	}
	
	public int updateArticle(AdminQnAVO adminQnAVO) throws Exception{
		return sqlSession.update("mapper.adminQnA.updateArticle", adminQnAVO);
	}
	
	public int deleteArticle(int no) throws Exception{
		return sqlSession.delete("mapper.adminQnA.deleteArticle", no);
	}
	
	private int selectNewno() throws DataAccessException{
		return sqlSession.selectOne("mapper.adminQnA.selectNewno");
	}

}
