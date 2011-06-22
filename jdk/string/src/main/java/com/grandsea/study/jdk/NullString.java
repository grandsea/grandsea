package com.grandsea.study.jdk;

public class NullString {

	public static void main(String args[]){
		String hello = null + "";
		if(hello == null){
			System.out.println("hello is null");
		}
		System.out.println(hello);
		System.out.println(true + "");
	}
}
