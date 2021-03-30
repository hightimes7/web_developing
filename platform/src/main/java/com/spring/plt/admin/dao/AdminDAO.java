package com.spring.plt.admin.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.plt.admin.vo.AdminVO;
import com.spring.plt.admin.vo.EditInfoVO;
import com.spring.plt.admin.vo.LoginLogVO;

public interface AdminDAO {
	public AdminVO loginById(AdminVO adminVO) throws DataAccessException;
	public List<EditInfoVO> startUpEdit() throws Exception;
    public List<EditInfoVO> manuEdit() throws Exception;
    public List<EditInfoVO> expertEdit() throws Exception;
	public List<LoginLogVO> LoginLog() throws Exception;
}
