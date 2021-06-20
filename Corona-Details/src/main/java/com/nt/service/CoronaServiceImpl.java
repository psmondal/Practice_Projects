package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.CoronaBO;
import com.nt.dao.ICoronaDAO;
import com.nt.dto.CoronaDTO;

@Service("coronaService")
public class CoronaServiceImpl implements ICoronaService {
	
	@Autowired
	private ICoronaDAO  dao;

	@Override
	public List<CoronaDTO> fetchPatientsByCity(String[] cities) throws Exception {
		  
		StringBuilder  buffer=new StringBuilder("(");
		 for(int i=0;i<cities.length;++i) {
			 if(i==cities.length-1) 
				 buffer.append("'"+cities[i]+"')");
			 else
				 buffer.append("'"+cities[i]+"',"); 
		 }
		 
		  String cond=buffer.toString();
		  System.out.println(cond);
		 
		  List<CoronaBO> listBO=dao.getPatientsByCity(cond);
		  
		   List<CoronaDTO> listDTO=new ArrayList<>();
		   
		   listBO.forEach(bo->{
			   CoronaDTO dto=new CoronaDTO();
			   BeanUtils.copyProperties(bo,dto); 
			   listDTO.add(dto);
		   });

		return listDTO;
	}
}
