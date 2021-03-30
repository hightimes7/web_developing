package com.spring.plt.quotation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.quotation.vo.QuotationVO;

@Repository("quotationDAO")
public class QuotationDAOImpl implements QuotationDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertQuotation(QuotationVO quotationVO) {
		System.out.println("Quotation DAO");
		sqlSession.delete("mapper.quotation.insertQuotation", quotationVO);
	}
	@Override
	public List<QuotationVO> quotationList(){
		System.out.println("Quotation List DAO");
		return sqlSession.selectList("mapper.quotation.quotationList");
	}
	@Override
	public QuotationVO viewOneQuotation(String no) {
		System.out.println("Quotation view One Quotation");
		return sqlSession.selectOne("mapper.quotation.quotationOne", no);
	}
	@Override
	public int alarmQuotation(String compId){
		System.out.println("Quotation status List");
		int count = sqlSession.selectOne("mapper.quotation.alarmQuotation",compId);
		return count;
	}
	@Override
	public int alarmManuQuotation(String manuId) {
		int count = sqlSession.selectOne("mapper.quotation.alarmManuQuotation",manuId);
		return count;
	}
}
