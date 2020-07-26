package com.nt.controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.vo.EmployeeVO;

public final class MainController {
	private EmployeeMgmtServiceImpl service=null;

	
	public MainController(EmployeeMgmtServiceImpl service) {
		this.service=service;
	}
	
	public String employeeRegistration(EmployeeVO vo)throws Exception {
		EmployeeDTO dto=null;
		String result=null;
		
		//create all objects
		dto=new EmployeeDTO();
					
		//set the values of vo to dto
		dto.seteName(vo.geteName());
		dto.setAddrs(vo.getAddrs());
		dto.setBasicSal(Double.parseDouble(vo.getBasicSal()));
		
		//call the method of Service class
		result=service.register(dto);
		return result;		
	}
}
