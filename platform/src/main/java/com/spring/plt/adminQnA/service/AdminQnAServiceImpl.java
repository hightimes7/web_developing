package com.spring.plt.adminQnA.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.adminQnA.dao.AdminQnADAO;
import com.spring.plt.adminQnA.vo.AdminQnAVO;

@Service("adminQnAService")
public class AdminQnAServiceImpl implements AdminQnAService{
	@Autowired
	private AdminQnADAO adminQnADAO;
	
	public List<AdminQnAVO> listArticles() throws Exception{
		List<AdminQnAVO> articlesList = adminQnADAO.selectAllArticlesList();
		return articlesList;
	}
	
	public Map listArticles(Map pagingMap) throws Exception{
		Map articlesMap = new HashMap();
		List<AdminQnAVO> articlesList = adminQnADAO.selectAllArticlesList(pagingMap);
		int total = adminQnADAO.listCount();
		articlesMap.put("articlesList", articlesList);
		articlesMap.put("total", total);
		return articlesMap;
	}
	
	public int listCount() throws DataAccessException{
		return adminQnADAO.listCount();
	}
		
	public int addNewArticle(AdminQnAVO adminQnAVO) throws Exception{
		return adminQnADAO.insertNewArticle(adminQnAVO);
	}
	
	public int updateArticle(AdminQnAVO adminQnAVO) throws Exception{
		return adminQnADAO.updateArticle(adminQnAVO);
	}
	
	public int deleteArticle(int no) throws Exception{
		return adminQnADAO.deleteArticle(no);
	}
	
	public AdminQnAVO viewArticle(int no) throws Exception{
		return adminQnADAO.viewArticle(no);
	}
}
