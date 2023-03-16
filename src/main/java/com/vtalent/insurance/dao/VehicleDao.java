package com.vtalent.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.vtalent.insurance.model.CarModel;
import com.vtalent.insurance.model.CarStyle;
import com.vtalent.insurance.model.Year;

public class VehicleDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	Connection con;
	 
	PreparedStatement pst;
	    String query;
	    ResultSet rs;

		public Connection getConnection(JdbcTemplate jdbctemplate) throws SQLException {
			return jdbctemplate.getDataSource().getConnection();
		}
	  public List<Year> getAllYear(){
	        List<Year> list  = new ArrayList<>();
	        try{
	            query = "select * from year";
	            con = getConnection(jdbcTemplate);
	            pst = this.con.prepareStatement(query);
	            rs = pst.executeQuery();
	            while(rs.next()){
	                Year year = new Year();
	                year.setY_id(rs.getInt("y_id"));
	                year.setYear(rs.getString("y_name"));
	                list.add(year);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    
	    public List<CarModel> getCarModelByYearId(int y_id){
	        List<CarModel> list = new ArrayList<>();
	        try{
	            query = "select * from car_model where c_id=?";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, y_id);
	            rs = pst.executeQuery();
	            while(rs.next()){
	                CarModel state = new CarModel();
	                state.setId(rs.getInt("id"));
	                state.setY_id(rs.getInt("y_id"));
	                state.setName(rs.getString("name"));
	                list.add(state);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        } 
	        return list;
	    }
	    
	    
	    public List<CarStyle> getCarStyleByCarModelId(int c_Id){
	        List<CarStyle> list = new ArrayList<>();
	        try{
	            query = "select * from car_style where c_id=?";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, c_Id);
	            rs = pst.executeQuery();
	            while(rs.next()){
	                CarStyle style = new CarStyle();
	                style.setId(rs.getInt("id"));
	                style.setY_id(rs.getInt("y_id"));
	                style.setC_id(rs.getInt("c_id"));
	                style.setName(rs.getString("name"));
	                list.add(style);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	        return list;
	    }
	}

	  