package com.jeppiaar.service;

import com.jeppiaar.dao.AdminLoginDAO;
import com.jeppiaar.model.AdminLogin;

public class AdminLoginService {
	public void register() {
		AdminLogin adminLogin=new AdminLogin();
        AdminLoginDAO adminLoginDAO=new AdminLoginDAO();
        adminLoginDAO.save(adminLogin);
	}
	public boolean login()
	{
		AdminLogin adminLogin=new AdminLogin();
		AdminLoginDAO adminLoginDAO=new AdminLoginDAO();
		return adminLoginDAO.functionValidLogin(adminLogin.getUserName(), adminLogin.getPassword());
	    
	}
	
}
