package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.BankDAO;

@Service("bankService")
public class BankMgmtSeviceImpl implements BankMgmtService {
	
	@Autowired
	private BankDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String transferMoney(long srcAcc, long desAcc, double amt) {
		int count1=0,count2=0;
		
		count1=dao.withDraw(srcAcc, amt);
		count2=dao.deposite(desAcc, amt);
		
		if (count1==0|| count2==0)
			throw new RuntimeException("Problem in Transfer Money");
		else
			return  amt+" amount of money  transffered  from "+srcAcc+"  to  "+desAcc;
	}

}
