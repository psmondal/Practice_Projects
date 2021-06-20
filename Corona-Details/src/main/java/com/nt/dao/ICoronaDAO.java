package com.nt.dao;
import java.util.List;
import com.nt.bo.CoronaBO;

public interface ICoronaDAO {
	public  List<CoronaBO>  getPatientsByCity(String cond)throws Exception;

}
