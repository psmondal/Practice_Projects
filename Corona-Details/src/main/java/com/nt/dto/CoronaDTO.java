package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CoronaDTO implements Serializable {
	private Integer patientID;
    private String pname;
    private  String addr;
    private  String stage;
}
