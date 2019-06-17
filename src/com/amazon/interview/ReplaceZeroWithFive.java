package com.amazon.interview;

public class ReplaceZeroWithFive {

	
	public static void main(String[] args) {
		System.out.println(10^3);
		System.out.println(repalc0With5(1004060087));
	}
	
	static int repalc0With5(int no) {
		
		int i =0; int temp =0;int remainder=0;int newno=0;
		while(no>9) {
			
			if(no%10==0) {
				no = no/10;
			    temp=	temp+(int)Math.pow(10,i)*5;
			}else {
				remainder = no%10;
				no = no/10;
				temp=	temp + (int)Math.pow(10,i)*remainder;
				
			}
			 newno = no*(int)Math.pow(10,i+1)+temp;
			i++;
		}
		
		return newno;
	}
	
}
