package com.nt.service;

import java.util.List;

import com.nt.dto.CoronaDTO;

public interface ICoronaService {
	
	public List<CoronaDTO>  fetchPatientsByCity(String cities[])throws Exception;

}
