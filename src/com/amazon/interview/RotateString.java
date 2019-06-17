package com.amazon.interview;

public class RotateString {

	public static void main(String[] args) {
	
		if(rotateString("kuamit","amitku")) {
			System.out.println("The give strings are rotation of each other");
		}else {
			System.out.println("The give strings are not rotation of each other");
		}
		
	}
	
	static boolean rotateString(String str1, String str2) {
		
		String firstStr = str1.substring(0, str1.length()-2);
		firstStr = str1.substring(str1.length()-2, str1.length()).concat(firstStr);
		
		String secondStr = str1.substring(0, 2);
		secondStr = str1.substring(2,str1.length()).concat(secondStr);
		
		//anticlock wise || clock wise
		if(str2.equals(firstStr) || str2.equals(secondStr)) {
			return true;
		}else
			return false;
		
	}
	
}
