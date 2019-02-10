package com.acme.classes;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileAccess file = new FileAccess();
		ProcessData processData = new ProcessData();
		processData.calculateSalary(file.readFile("src/data.txt"));

	}

}
 	