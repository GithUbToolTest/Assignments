package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class Test {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) {
		String eName,eAdd,basicSal,result;
		Scanner sc=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		EmployeeVO vo=null;
		MainController controller=null;
		
		//create scanner class object
		sc=new Scanner(System.in);
	
		System.out.print("Enter Employee Name:: ");
		eName=sc.next();
		System.out.print("Enter Employee Addrs:: ");
		eAdd=sc.next();
		System.out.print("Enter Basic Salary:: ");
		basicSal=sc.next();

		//create beanFactory obj
		factory=new DefaultListableBeanFactory(); 
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com\\nt\\cfgs\\applicationConntext.xml");
		//create controller class object
		controller=factory.getBean("controller", MainController.class);
		
		vo=new EmployeeVO();

		vo.seteName(eName);
		vo.setAddrs(eAdd);
		vo.setBasicSal(basicSal);

		try {
			result=controller.employeeRegistration(vo);
			System.out.println(result);
		}catch(Exception e) {
			System.out.println("Internal Problem");
			e.printStackTrace();
		}
	}
}
