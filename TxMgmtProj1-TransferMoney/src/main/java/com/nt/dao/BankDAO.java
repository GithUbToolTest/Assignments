package com.nt.dao;

public interface BankDAO {
	
	public int withDraw(long accNo,double amt);
	public int deposite(long accNo,double amt);

}
