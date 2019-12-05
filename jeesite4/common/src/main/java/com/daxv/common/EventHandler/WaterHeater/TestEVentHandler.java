package com.daxv.common.EventHandler.WaterHeater;

import java.util.Date;
import java.util.Scanner;

import com.daxv.common.EventHandler.ConcreteNotifier;

import junit.framework.TestCase; 

public class TestEVentHandler extends TestCase {
	private boolean falg = false;

	public void Teststu() {
		
		WaterBoiler wb=new WaterBoiler(); 
		ConcreteNotifier cNotifier = new ConcreteNotifier();
		wb.setCnf(cNotifier);
		
		System.out.println("是否开始烧水，1开始少水，2 不开始烧水 ");
		Scanner scanner = new Scanner(System.in);
		int numString = scanner.nextInt();

		System.out.println(numString);

		if (numString == 1) {
			wb.setFalg(true);
		}
		CallThePolice ct = new CallThePolice();
		WaterMonitor monitor = new WaterMonitor();		 
		wb.getCnf().addEventHandler(ct, "DisplayMassAge");  
		wb.getCnf().addEventHandler(monitor, "DisplayMassAge");		
		wb.BoiledWater();
	
	}
}
