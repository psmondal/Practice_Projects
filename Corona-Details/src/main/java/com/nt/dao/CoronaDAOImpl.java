package com.nt.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.CoronaBO;

@Repository("coronaDAO")
public class CoronaDAOImpl implements ICoronaDAO {
	
	private static final String GET_PATIENTS_BY_CITY="SELECT PATIENTID, PNAME,  ADDR, STAGE FROM PATIENT  WHERE ADDR IN";
	
	@Autowired
	private  DataSource  ds;

	@Override
	public List<CoronaBO> getPatientsByCity(String cond) throws Exception {
		 List<CoronaBO> listBO=null;
		 
		 System.out.println("Final Query: " +GET_PATIENTS_BY_CITY+cond+" ORDER BY ADDR");
		 
		try{
			 Connection con=ds.getConnection();
			 Statement st=con.createStatement();
		     ResultSet rs=st.executeQuery(GET_PATIENTS_BY_CITY+cond+" ORDER BY ADDR");
		     
		     //System.out.println("Resultset: " +rs.toString());
		     
			 listBO=new ArrayList<>();
			 CoronaBO bo=null;
			 
			 while(rs.next()) {
				 	 bo=new CoronaBO();
					 bo.setPatientID(rs.getInt(1));
					 bo.setPname(rs.getString(2));
					 bo.setAddr(rs.getString(3));
					 bo.setStage(rs.getString(4));
					 
					 //System.out.println(bo);
				 
					 listBO.add(bo);
			 }
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}

}
