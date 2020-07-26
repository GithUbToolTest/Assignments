package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public final class EmployeeDAOImpl implements EmployeeDAO {

	private static final String INSERT_QUERY="INSERT INTO EMPLOYEE_REGISTRATION VALUES(ENO_SEQ.NEXTVAL,?,?,?,?,?)";
	private DataSource ds=null;
	
	public EmployeeDAOImpl(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;		
		int count=0;
		
		//create the jdbc connection object using dataSource object
		con=ds.getConnection();
		//create prepareStmt object
		ps=con.prepareStatement(INSERT_QUERY);
		//set query param
		ps.setString(1,bo.geteName());
		ps.setString(2,bo.geteName());
		ps.setDouble(3,bo.getBasicSal());
		ps.setDouble(4,bo.getGrossSal());
		ps.setDouble(5,bo.getNetSal());
		
		//execute the query
		count=ps.executeUpdate();
		//close the connection
		ps.close();
		con.close();
				
		return count;
	}//method
}//class
