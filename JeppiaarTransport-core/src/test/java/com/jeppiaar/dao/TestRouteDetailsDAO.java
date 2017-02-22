package com.jeppiaar.dao;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestRouteDetailsDAO {
public static void main(String[] args) {
	RouteDetailsDAO dao=new RouteDetailsDAO();
	String status=dao.addRoute("KANCHEEPURAM", "KANCHEEPURAM", 20, LocalDate.parse("2017-02-18"), LocalTime.parse("15:00"), "a", "b", "c", "d", "e", "f", "errmsg");
	System.out.println(status);
}
}
