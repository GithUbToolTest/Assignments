package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankMgmtService;
import com.nt.service.BankMgmtSeviceImpl;

public class MoneyTxTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankMgmtService proxy=null;
		
		//create the container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy object
		proxy=ctx.getBean("bankService",BankMgmtSeviceImpl.class);
		
		System.out.println(proxy.getClass()+"      "+proxy.getClass().getSuperclass());
		//invoke methods
		try {
			System.out.println(proxy.transferMoney(1002, 1003,10000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
