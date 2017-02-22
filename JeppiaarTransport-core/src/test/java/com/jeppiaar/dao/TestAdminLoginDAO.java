package com.jeppiaar.dao;

import java.util.List;

import com.jeppiaar.model.AdminLogin;

public class TestAdminLoginDAO {
public static void main(String[] args) {
	AdminLoginDAO adminLoginDAO=new AdminLoginDAO();
	List<AdminLogin> list=adminLoginDAO.list();
	for(AdminLogin a:list)
	{
		System.out.println(a.getUserName()+"\t"+a.getPassword()+"\t"+a.getEmailId()+"\t"+a.getPhoneNumber());
	}
}
}
