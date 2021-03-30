package com.spring.plt.adminQnA.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.adminQnA.vo.AdminQnAVO;

public interface AdminQnADAO {
	public List<AdminQnAVO> selectAllArticlesList() throws Exception;
	public List<AdminQnAVO> selectAllArticlesList(Map<String, Integer> pagingMap) throws Exception;
	public int listCount() throws DataAccessException;
	public int insertNewArticle(AdminQnAVO adminQnAVO) throws Exception;
	public AdminQnAVO viewArticle(int articleNO) throws Exception;
	public int updateArticle(AdminQnAVO qnaBoard) throws Exception;
	public int deleteArticle(int articleNO) throws Exception;
}
