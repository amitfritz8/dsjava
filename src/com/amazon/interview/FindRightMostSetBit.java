package com.amazon.interview;

public class FindRightMostSetBit {

	public static void main(String[] args) {
		
		int bit=  00000000;
		
		System.out.println(getPositionOfRightMostSetBit(bit));
	}
	
	static int getPositionOfRightMostSetBit (int bit) {
		 int position=0;
		
		 while(bit!=0) {
			 
			 if(bit%2==0) {
				 position++; 
				 bit = bit >> 1;
			 }else {
				 position++; 
				 break;
			 }
		 }
		 
		 
		return position;
	}
	
	
}
