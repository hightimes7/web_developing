package com.spring.plt.adminQnA.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.spring.plt.adminQnA.vo.AdminQnAVO;

public interface AdminQnAService {
	public List<AdminQnAVO> listArticles() throws Exception;
	public Map listArticles(Map pagingMap) throws Exception;
	public int listCount() throws DataAccessException;
	public int addNewArticle(AdminQnAVO adminQnAVO) throws Exception;
	public int updateArticle(AdminQnAVO adminQnAVO) throws Exception;
	public int deleteArticle(int articleNO) throws Exception;
	public AdminQnAVO viewArticle(int articleNO) throws Exception;
}
