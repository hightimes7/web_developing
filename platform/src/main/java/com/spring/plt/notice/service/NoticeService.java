package com.spring.plt.notice.service;

import java.util.List;

import com.spring.plt.notice.vo.NoticePageVO;
import com.spring.plt.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> getNoticeList(NoticePageVO pageVO) throws Exception;
	public int writeNotice(NoticeVO notice) throws Exception;
	public NoticeVO selectNotice(int no) throws Exception;
	public int updateNotice(NoticeVO notice) throws Exception;
	public void cntPlus(int no) throws Exception;
	public int deleteNotice(int no) throws Exception;
	public int listCount() throws Exception;
}
