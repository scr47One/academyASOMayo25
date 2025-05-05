package com.curso.v0;

import java.io.FileInputStream;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) {

		FileInputStream tempFis = null;  
		
		try(FileInputStream fis = 
		 			new FileInputStream("c:\\temp\\test.text")){
			
			System.out.println(fis);                         
			tempFis = fis; 
		}
		//catch(IOException | NullPointerException e){}
		//catch(IOException ioe){ }
		catch(IOException e){ }
		finally {
			try {
				tempFis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
