package com.amazon.interview;

import java.util.List;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class SmallestWindowStringContainingAllChar {

	public static void main(String[] args) {
		String str1 = "geeksforgeeksorks";
		String str2 = "ork"; //ksfor
		
		//System.out.println(findSmallestWindowStrBF(str1,str2));
		System.out.println(findSmallestWindowStrOptimized(str1,str2));
	
	}

	public static String findSmallestWindowStrOptimized(String str1,
			String str2) {
		
		int len1 = str1.length();
		int len2 = str2.length();
		int count =0,startIndex=-1,min=str1.length(), start=0;
		int[] patAry = new int[256];
		int[] strAry = new int[256];
		
		for(int i =0;i<len2;i++) {
			patAry[str2.charAt(i)]++;
		}
		
		for(int j=0;j<len1;j++) {
			
			strAry[str1.charAt(j)]++;
			
			if(strAry[str1.charAt(j)]!=0 &&
					strAry[str1.charAt(j)]<=patAry[str1.charAt(j)]) {
				
				count++;
			}
			
			if(len2==count) {
				
				while(strAry[str1.charAt(start)]==0
			         || strAry[str1.charAt(start)]>
						patAry[str1.charAt(start)]) {
					
					if(strAry[str1.charAt(start)]>patAry[str1.charAt(start)]) {
						strAry[str1.charAt(start)]--;
					}
					
					start++;
				}
				
			int len = j-start+1;	
				if(len<min) {
					min=len;
					startIndex = start;
				}
			}
			
			
		}
		
		if(startIndex==-1) {
			System.out.println("No Window Found");
			return "";
		}
		
		return str1.substring(startIndex, min+startIndex);
	}
	
	
	public static String findSmallestWindowStrBF(String str1, String str2) {
		int min=str1.length(); String res="";
		char[] ary1  = str1.toCharArray();
		char[] ary2 = str2.toCharArray();
		
		int[] charAry = new int[str2.length()];
		
		List<Character>result = new ArrayList<>();
		
		for(int i=0;i<ary1.length;i++) {
			result.add(ary1[i]);
			for(int j=i+1;j<ary1.length;j++) {
				result.add(ary1[j]);
				if(result.size()>=str2.length() &&
						checkIfContains(result,ary2)) {
					if(result.size()<min) {
						min=result.size();
					    res=result.toString();
					}
				}
			}
			result.clear();
		}
		return res.toString();
	}
	
	public static boolean checkIfContains(List result, char[] ary2) {
		List lst = new ArrayList<>(result);
		int count=0;
		for(int i=0;i<ary2.length;i++) {
				if(lst.contains(ary2[i])) {
					lst.remove((Character)ary2[i]);
					count++;
			}
		}
		if(count==ary2.length)
			return true;
		
		return false;
	}
}
