package com.jeppiaar.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeppiaar.dao.AdminLoginDAO;
import com.jeppiaar.dao.RouteDetailsDAO;
import com.jeppiaar.dao.RouteIpDetailsDAO;
import com.jeppiaar.model.RouteIpDetails;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	
@GetMapping
	   public String listAllRoutes(ModelMap modelMap)
	   {  
		   
		   RouteIpDetailsDAO routeIpDetailsDAO=new RouteIpDetailsDAO();	

		   List<RouteIpDetails> routes=routeIpDetailsDAO.listRoutes();
			modelMap.addAttribute("ROUTE_LIST",routes);
			
			return "adminviewroutes.jsp";
	   }
@PostMapping("/login")	
	public String login(@RequestParam("username")String username,@RequestParam("password")String password)
	{
		AdminLoginDAO adminLoginDAO=new AdminLoginDAO();
		boolean valid=adminLoginDAO.functionValidLogin(username, password);
		if(valid)
			{
			return "redirect:../admin";
	        }

		return "redirect:../home.jsp";
		
	}
@PostMapping("/addroute")
public String addRoute(@RequestParam("routename") String routename,@RequestParam("endpoint")String endpoint,@RequestParam("busno") Integer busno,@RequestParam("depdate") String depdate,@RequestParam("deptime") String deptime,
		@RequestParam("ip1") String ip1,@RequestParam("ip2") String ip2,@RequestParam("ip3") String ip3,@RequestParam("ip4") String ip4,@RequestParam("ip5") String ip5,@RequestParam("ip6") String ip6)
{
	RouteDetailsDAO dao = new RouteDetailsDAO();
	String errmsg = null;
	System.out.println(depdate);
	System.out.println(deptime);
	LocalDate departureDate = LocalDate.parse(depdate);
	LocalTime departureTime=LocalTime.parse(deptime);


	dao.addRoute(routename,endpoint , busno, departureDate, departureTime, ip1, ip2, ip3, ip4, ip5, ip6, errmsg);
	return "redirect:../admin";
}
@PostMapping("/deleteroute")
public String deleteRoute(@RequestParam("busno") Integer busno)
{
	RouteDetailsDAO dao=new RouteDetailsDAO();
	String errmsg=null;
	dao.deleteRoute(busno, errmsg);
	return "redirect:../admin";
}

}
