package com.jeppiaar.dao;

import java.util.List;

import com.jeppiaar.model.RouteDetails;
import com.jeppiaar.model.RouteIpDetails;

public class TestRouteIpDetailsDAO {
public static void main(String[] args) {
	RouteIpDetailsDAO routeIpDetailsDAO=new RouteIpDetailsDAO();
	List<RouteIpDetails> list=routeIpDetailsDAO.listRoutes();
	for(RouteIpDetails a:list)
	{
		System.out.println(a);
	}
}
}
