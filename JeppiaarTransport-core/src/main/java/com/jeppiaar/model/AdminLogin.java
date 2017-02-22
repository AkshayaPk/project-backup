package com.jeppiaar.model;

import lombok.Data;

@Data
public class AdminLogin {
private Integer id;
private String userName;
private String password;
private String emailId;
private Long phoneNumber;

}
