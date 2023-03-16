package com.vtalent.insurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.vtalent.insurance.dao.VehicleDao;
import com.vtalent.insurance.model.CarModel;
import com.vtalent.insurance.model.CarStyle;
import com.vtalent.insurance.model.Year;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	
	@Autowired
	private VehicleDao vehicleDao;
	
    @GetMapping("/")
	public String doGet(HttpServletRequest req, HttpServletResponse res) throws SQLException,IOException {
		
	
    
    String op = req.getParameter("operation");

	if (op.equals("year")) {
		List<Year> clist = vehicleDao.getAllYear();
		Gson json = new Gson();
		// return json.toJson(clist);
		String yearList = json.toJson(clist);
		res.setContentType("text/html");
		res.getWriter().write(yearList);
		return yearList;
	}

	if (op.equals("car_model")) {
		int id = Integer.parseInt(req.getParameter("id"));
		List<CarModel> slist = vehicleDao.getCarModelByYearId(id);
		Gson json = new Gson();
		// return json.toJson(slist);
		String carModelList = json.toJson(slist);
		res.setContentType("text/html");
		res.getWriter().write(carModelList);
		return carModelList;
	}

	if (op.equals("car_style")) {
		int id = Integer.parseInt(req.getParameter("id"));
		List<CarStyle> carStyle = vehicleDao.getCarStyleByCarModelId(id);
		Gson json = new Gson();
		// return json.toJson(citylist);
		String styleList = json.toJson(carStyle);
		res.setContentType("text/html");
		res.getWriter().write(styleList);
		return styleList;
	}
	return null;
}
	
	@PostMapping("/success")
	public String success(HttpServletRequest req, HttpServletResponse res) {
		return "driver";
	}

}
