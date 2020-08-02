package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAOImpl implements BankDAO {
	private static final String WITHDRAW_QUERY="UPDATE BANK_DETAIL SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String DEPOSITE_QUERY="UPDATE BANK_DETAIL SET BALANCE=BALANCE+? WHERE ACCNO=?";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int withDraw(long accNo, double amt) {
		int count=0;
		count=jt.update(WITHDRAW_QUERY, amt, accNo);
		return count;
	}
 
	@Override
	public int deposite(long accNo, double amt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY, amt, accNo);
		return count;
	}

}
