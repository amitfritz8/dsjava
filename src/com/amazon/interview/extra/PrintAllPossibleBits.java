package com.amazon.interview.extra;

import java.util.Arrays;

public class PrintAllPossibleBits {

	static int count;
	public static void main(String[] args) {
		
		String str = "ABCDEF";
	    int[] ary = new int[5]; 
		printAllPossibleBits(5,0, ary, str);
		System.out.println(count);
		
		
		
	}
	
	
	static void printAllPossibleBits(int no,int index,int[] ary, String str) {
		
		if(index==no) {
			count++;
			System.out.println(Arrays.toString(ary));
		/*	String temp = str;int j=0;int times=0;
			for(int i=0;i<ary.length;i++) {
				if(ary[i]==1) {
					j=i+1+times;
					temp = temp.substring(0,j) + " " + temp.substring(j);
					times++;
				}
				
			}*/
			//System.out.println(temp);
			return;
		}
		ary[index]=0;
		printAllPossibleBits(no,index+1,ary,str);
		ary[index]=1;
		printAllPossibleBits(no,index+1,ary,str);
	}
}
