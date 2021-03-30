package com.spring.plt.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.plt.notice.vo.NoticePageVO;
import com.spring.plt.notice.vo.NoticeVO;

@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO{
	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeVO> getNoticeList(NoticePageVO pageVO) throws Exception{
		return sqlSession.selectList("mapper.notice.getNoticeList", pageVO);
	}
	
	public int writeNotice(NoticeVO notice) throws Exception{
		return sqlSession.insert("mapper.notice.writeNotice", notice);
	}
	
	public NoticeVO selectNotice(int no) throws Exception{
		return sqlSession.selectOne("mapper.notice.selectNotice", no);
	}
	
	public int updateNotice(NoticeVO notice) throws Exception{
		return sqlSession.update("mapper.notice.updateNotice", notice);
	}
	
	public void cntPlus(int no) throws Exception{
		sqlSession.update("mapper.notice.cntPlus", no);
	}
	
	public int deleteNotice(int no) throws Exception{
		return sqlSession.delete("mapper.notice.deleteNotice", no);
	}
	
	public int listCount() throws Exception{
		return sqlSession.selectOne("mapper.notice.listCount");
	}
}
