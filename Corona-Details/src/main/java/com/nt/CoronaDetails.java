package com.nt;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CoronaVO;

@SpringBootApplication
public class CoronaDetails {

	public static void main(String[] args) {
		//read inputs from end user
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of cities :: ");
		int count=sc.nextInt();
		String cities[]=null;
		if(count>=1)
			cities=new String[count];
		else {
			System.out.println("invalid cities count ");
			return;
		}
		for(int i=0; i<count; i++) {
			System.out.println("enter city"+(i+1));
			String city=sc.next();
			cities[i]=city;
		}
	     		
		ApplicationContext ctx=SpringApplication.run(CoronaDetails.class, args);
		MainController controller=ctx.getBean("controller",MainController.class);
		
		//invoking business method
		try {
			List<CoronaVO> listVO=controller.showPatientsByCity(cities);
			System.out.println("Patient details having "+Arrays.toString(cities));
			listVO.forEach(vo->{
				System.out.println("ID: "+vo.getPatientID() + "     Name:  "+vo.getPname()+"     Stage: "+vo.getStage());
			});
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem Occured::"+e.getMessage());
		}
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
