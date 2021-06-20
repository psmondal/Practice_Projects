package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CoronaDTO;
import com.nt.service.ICoronaService;
import com.nt.vo.CoronaVO;

@Controller("controller")
public class MainController {
	
	@Autowired
	private ICoronaService service;
	
	public List<CoronaVO> showPatientsByCity(String cities[]) throws Exception{
		
		List<CoronaDTO> listDTO=service.fetchPatientsByCity(cities);
		List<CoronaVO> listVO=new ArrayList<>();
		
		listDTO.forEach(dto->{
			CoronaVO vo=new CoronaVO();
			BeanUtils.copyProperties(dto, vo);
			vo.setPatientID(Integer.valueOf(dto.getPatientID()));
			vo.setPname(String.valueOf(dto.getPname()));
			vo.setAddr(String.valueOf(dto.getAddr()));
			vo.setStage(String.valueOf(dto.getStage()));
			
			listVO.add(vo);
		});
		return listVO;
	}

}

