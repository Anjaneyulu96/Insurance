package com.vtalent.insurance.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.vtalent.insurance.dao.CustomerRepository;
import com.vtalent.insurance.dao.ZipRepository;
import com.vtalent.insurance.model.Customer;
import com.vtalent.insurance.model.UsaZipInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ZipRepository zipRepo;
	
	@Autowired
	private CustomerRepository cusRepo;
	
	@GetMapping("/")
	public ModelAndView init(HttpServletRequest req, HttpServletResponse res) {
	    ModelAndView model = new ModelAndView("customer");
	    Customer customer = new Customer();
	    model.addObject("customer", customer);
	    return model;
	}
	
	@GetMapping("/get")
	public ModelAndView get(HttpServletRequest req, HttpServletResponse res) {
	    String zip = req.getParameter("zip");
	    UsaZipInfo zipcode = zipRepo.findByZip(zip);
	    
	    ModelAndView model = new ModelAndView("customer");
	    Customer customer = new Customer();
	    if(zipcode != null) {
	    	customer.setZip(zipcode.getZip());
		    customer.setCity(zipcode.getCity());
		    customer.setState(zipcode.getState());
	    }
	    
	    model.addObject("customer", customer);
	    return model;
	}
	
	@PostMapping("/success")
	public String success(@ModelAttribute("customer") Customer customer) {
		cusRepo.save(customer);
		return "vehicle";
	}
	
	@PostMapping("/onchange")
	public @ResponseBody UsaZipInfo onchange(@RequestBody UsaZipInfo customer) {
		String zip = customer.getZip();
		return Objects.requireNonNull(zipRepo.findByZip(zip));
	}
	

}
