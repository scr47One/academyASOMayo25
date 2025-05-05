package com.curso.v0;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class PrincipalExceptions {

	public static void main(String[] args) {
		
		try {
			for (;;);
		} finally {
		}

//		int x = validMethod();
//		try {
//			if (x == 5)
//				throw new IOException();
//			else if (x == 6)
//				throw new Exception();
//		} finally {
//			x = 8;
//		} catch (Exception e) {
//			x = 9;
//		} 

//		try {
//			  try {
//			     ServerSocket s = new ServerSocket(3030);
//			  }catch(Exception e) { 
//			    //s = new ServerSocket(4040);
//			  } 
//			}

//		int k = 0;
//		try {
//		  k = callValidMethod();
//		} 
//		//System.out.println(k);
//		catch {  k = -1; }

//		try {
//			  File f = new File("c:\\a.txt");
//			} catch {  f = null; }


	}

	private static int validMethod() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static int callValidMethod() {
		// TODO Auto-generated method stub
		return 0;
	}

}
