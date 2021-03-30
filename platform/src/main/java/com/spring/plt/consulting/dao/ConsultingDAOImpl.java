package com.spring.plt.consulting.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.consulting.vo.ConsultingVO;
import com.spring.plt.quotation.vo.QuotationVO;

@Repository("consultingDAO")
public class ConsultingDAOImpl implements ConsultingDAO{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insertConsulting(ConsultingVO ConsultingVO) {
		System.out.println("Consulting DAO");
		sqlSession.insert("mapper.consulting.insertConsulting", ConsultingVO);
	}
	@Override
	public List<ConsultingVO> ConsultingList(){
		System.out.println("Consulting List DAO");
		return sqlSession.selectList("mapper.consulting.ConsultingList");
	}
	@Override
	public ConsultingVO viewOneConsulting(String no) {
		System.out.println("Consulting view DAO");
		return sqlSession.selectOne("mapper.consulting.viewOneConsulting",no);
	}
	@Override
	public int alarmConsulting(String compId) {
		System.out.println("Consulting alarm DAO");
		int count;
		count = sqlSession.selectOne("mapper.consulting.alarmConsulting",compId);
		return count;
	}
	@Override
	public int alarmExpConsulting(String expId) {
		int count;
		count = sqlSession.selectOne("mapper.consulting.alarmExpConsulting", expId);
		return count;
	}
}
