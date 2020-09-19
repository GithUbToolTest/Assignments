package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.DisplayAllCountryMgmtService;

public class ShowAllCountries extends AbstractController {
	
	private DisplayAllCountryMgmtService service;
	
	public ShowAllCountries(DisplayAllCountryMgmtService service) {
		this.service=service;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	  List countryName=service.getAllCountryName();
	
		return new ModelAndView("result","getCountry",countryName);
	}

}
