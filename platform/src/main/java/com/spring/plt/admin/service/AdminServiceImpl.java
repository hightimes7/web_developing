package com.spring.plt.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.spring.plt.admin.dao.AdminDAO;
import com.spring.plt.admin.vo.AdminVO;
import com.spring.plt.admin.vo.EditInfoVO;
import com.spring.plt.admin.vo.LoginLogVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public AdminVO login(AdminVO adminVO) throws DataAccessException {
		
		return adminDAO.loginById(adminVO);
	}
	
	@Override
	   public List<EditInfoVO> expertEdit() throws Exception {
	      List<EditInfoVO> expertEdit = adminDAO.expertEdit();
	      return expertEdit;
	   }

   @Override
   public List<EditInfoVO> startUpEdit() throws Exception {
      List<EditInfoVO> startUpEdit = adminDAO.startUpEdit();
      return startUpEdit;
   }

   @Override
   public List<EditInfoVO> manuEdit() throws Exception {
      List<EditInfoVO> expertEdit = adminDAO.expertEdit();
      return expertEdit;

}

	@Override
	public List<LoginLogVO> LoginLog() throws Exception {
		List<LoginLogVO> LoginLog = adminDAO.LoginLog();
		return LoginLog;
	}
}
