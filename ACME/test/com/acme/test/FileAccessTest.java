package com.acme.test;


import org.junit.AfterClass;
import org.junit.Test;

import com.acme.classes.FileAccess;

public class FileAccessTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testReadFile() {
		FileAccess file = new FileAccess();
		
		String test1 = null;
		String test2 = "src/data.txt";
		String test3 = "another direction";
		
		
		file.readFile(test1);
		file.readFile(test2);
		file.readFile(test3);

	}

}
