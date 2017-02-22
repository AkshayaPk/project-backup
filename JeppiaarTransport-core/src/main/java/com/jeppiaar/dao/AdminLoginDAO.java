package com.jeppiaar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jeppiaar.model.AdminLogin;
import com.jeppiaar.model.Route;
import com.jeppiaar.util.ConnectionUtil;

public class AdminLoginDAO {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
    public void save(AdminLogin adminLogin)
    {
   	String sql="insert into admin_login(username,password,emailid,phone) values(?,?,?,?)";
   	Object[] params={adminLogin.getUserName(),adminLogin.getPassword(),adminLogin.getEmailId(),adminLogin.getPhoneNumber()};
   	int rows=jdbcTemplate.update(sql,params);
   	System.out.println(rows);
    }
    public void update(AdminLogin adminLogin)
    {
   	String sql="update admin_login set password=?,emailid=? where username=?";
   	Object[] params={adminLogin.getPassword(),adminLogin.getEmailId(),adminLogin.getUserName()};
   	int rows=jdbcTemplate.update(sql,params);
   	System.out.println(rows);
    }
    public void delete(int id)
    {
   	String sql="delete from admin_login where ID=?";
   	
   	int rows=jdbcTemplate.update(sql,id);
   	System.out.println(rows);
    }
	public List<AdminLogin> list() {
		final String sql = "select USERNAME,PASSWORD,EMAILID,PHONE from admin_login";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			AdminLogin adminLogin=convert(rs);
			return adminLogin;
		});

	}
/**
 * Converts Object to ResultSet
 * @param rs
 * @return
 * @throws SQLException
 */
	static AdminLogin convert(final ResultSet rs) throws SQLException {
		AdminLogin adminLogin = new AdminLogin();
		adminLogin.setUserName(rs.getString("USERNAME"));
		adminLogin.setPassword(rs.getString("PASSWORD"));
		adminLogin.setEmailId(rs.getString("EMAILID"));
		adminLogin.setPhoneNumber(rs.getLong("PHONE"));
		return adminLogin;
	}
	
	public boolean functionValidLogin(String username,String password) {
		String sql = "select fn_is_valid_login(?,?)";
		return jdbcTemplate.queryForObject(sql, new Object[] {username,password}, Boolean.class);
	}
}
