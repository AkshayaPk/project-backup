package com.jeppiaar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.jeppiaar.model.Route;
import com.jeppiaar.model.RouteDetails;
import com.jeppiaar.model.RouteIpDetails;
import com.jeppiaar.util.ConnectionUtil;

public class RouteDetailsDAO {

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(RouteDetails routeDetails)
	{
		String sql="insert into seed_route_details(ROUTE_ID,ROUTE_BUS_NO,DEPARTURE_DATE,DEPARTURE_TIME) values(?,?,?,?,?)";
		Object[] params={routeDetails.getRouteId().getId(),routeDetails.getBusNo(),routeDetails.getDepartureDate(),routeDetails.getDepartureTime()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void update(RouteDetails routeDetails)
	{
		String sql="update seed_route_details set ROUTE_BUS_NO=? where ROUTE_ID=?";
		Object[] params={routeDetails.getBusNo(),routeDetails.getRouteId().getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println(rows);
	}
	public void delete(int id)
	{
		String sql="delete from seed_route_details where ID=?";
		
		int rows=jdbcTemplate.update(sql,id);
		System.out.println(rows);
	}
	public List<RouteDetails> list() {
		final String sql = "select ID,ROUTE_ID,ROUTE_BUS_NO,DEPARTURE_DATE,DEPARTURE_TIME from seed_route_details";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			RouteDetails routeDetails=convert(rs);
			return routeDetails;
		});

	}
 /**
  * Converts Object to ResultSet
  * @param rs
  * @return
  * @throws SQLException
  */
	static RouteDetails convert(final ResultSet rs) throws SQLException {
		RouteDetails routeDetails=new RouteDetails();
		routeDetails.setId(rs.getInt("ID"));
		Route route=new Route();
		route.setId(rs.getInt("ROUTE_ID"));
		routeDetails.setRouteId(route);
		routeDetails.setBusNo(rs.getInt("ROUTE_BUS_NO"));
		routeDetails.setDepartureDate(rs.getDate("DEPARTURE_DATE").toLocalDate());
		routeDetails.setDepartureTime(rs.getTime("DEPARTURE_TIME").toLocalTime());
		return routeDetails;
	}
	
	public String addRoute(String routeName, String endPoint, int busNo, LocalDate depDate, LocalTime depTime , String ip1 , String ip2 ,String ip3,String ip4,String ip5,String ip6,String errmsg) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_ADD_ROUTE").declareParameters(
				new SqlParameter("i_routename", Types.VARCHAR), new SqlParameter("i_endpoint", Types.VARCHAR),
				new SqlParameter("i_busno", Types.INTEGER), new SqlParameter("i_depdate", Types.DATE), new SqlParameter("i_deptime", Types.TIME), new SqlParameter("i_ip1", Types.VARCHAR), new SqlParameter("i_ip2", Types.VARCHAR),
				 new SqlParameter("i_ip3", Types.VARCHAR), new SqlParameter("i_ip4", Types.VARCHAR),new SqlParameter("i_ip5", Types.VARCHAR),new SqlParameter("i_ip6", Types.VARCHAR),
				new SqlOutParameter("errmsg", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("i_routename", routeName).addValue("i_endpoint", endPoint)
				.addValue("i_busno",busNo ).addValue("i_depdate", depDate).addValue("i_deptime", depTime).addValue("i_ip1", ip1).addValue("i_ip2", ip2).addValue("i_ip3", ip3).addValue("i_ip4", ip4).addValue("i_ip5", ip5).addValue("i_ip6", ip6).addValue("errmsg",errmsg );
		Map<String, Object> execute = call.execute(in);
		return (String) execute.get(errmsg);
}
	public String deleteRoute(Integer busno,String errmsg)
	{
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_DELETE_ROUTE").declareParameters(
				new SqlParameter("i_busno", Types.INTEGER),new SqlParameter("errmsg",Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("i_busno", busno).addValue("errmsg",errmsg);
		Map<String,Object> execute=call.execute(in);
		return (String) execute.get(errmsg);
				
	}
}
