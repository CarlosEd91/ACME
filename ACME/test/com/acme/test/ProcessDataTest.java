package com.acme.test;


import org.junit.AfterClass;
import org.junit.Test;

import com.acme.classes.ProcessData;

public class ProcessDataTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCalculateSalary() {

		ProcessData processData = new ProcessData();

		String[] test1 = { "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00",
				"MISHELL=MO10:00-12:00,TH12:00-14:00,FR20:00-21:00" };
		String[] test2 = {  };
		String[] test3 = { "ANOTHER FORMAT", "ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00",
				"MISHELL=MO10:00-12:00,TH12:00-14:00,ANOTHER FORMAT" };

		processData.calculateSalary(test1);
		processData.calculateSalary(test2);
		processData.calculateSalary(test3);
	}

}
