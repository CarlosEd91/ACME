package com.acme.classes;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileAccess {

	public String[] readFile(String file) {

		String[] array = {};

		
		if(file != null){
			

			try {

				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
			
				String str;

				List<String> lines = new ArrayList<String>();
				

				while ((str = br.readLine()) != null) {


					if(str.length() > 0) {
					
						lines.add(str);
					}
					

				}

				array = lines.toArray(new String[lines.size()]);
				
				
				br.close();

			} catch (FileNotFoundException e) {
				System.out.println("File is not found");
			} catch (IOException e) {
				e.printStackTrace();
			}
			

			
		}else{
			System.out.println("File address is null");
		}
		return array;


	}

}
