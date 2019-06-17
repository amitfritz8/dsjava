package com.amazon.interview;

import java.util.Arrays;
import java.util.Stack;

public class FindNearestNumber {

	public static void main(String[] args) {
		
		int[] numberAry =  {1, 6, 4, 10, 2, 5};
		System.out.println(Arrays.toString(numberAry));
		//int[] resultAry = findNearestNumberUsingBruteForceMethod(numberAry);
		int[] resultAry = findNearestNumberUsingStack(numberAry);
		//System.out.println(Arrays.toString(resultAry));
		
		
	}
	
	static int[] findNearestNumberUsingBruteForceMethod(int[] numberAry){
		
		int[] result = new int[numberAry.length];
		result[0]=0;
		for(int i=1;i<numberAry.length;i++) {
			
			for(int j=i-1;j>=0;j--) {
				
				if(numberAry[j]<numberAry[i]) {
					result[i]=numberAry[j];
					break;
				}
			}
		}
		return result;
	}
	
	
	static int[] findNearestNumberUsingStack(int[] numberAry) {
		
		Stack stack = new Stack();
		stack.push(numberAry[0]);
		int[] result = new int[numberAry.length];
		
		result[0]=0;
		
		for(int i=1;i<numberAry.length;i++) {
			
		
				while(!stack.isEmpty() && (int)stack.peek()>=numberAry[i] )
				stack.pop();
		
			System.out.print(" "+(int)stack.peek());
			stack.push(numberAry[i]);
		}
		
		return result;
	}
	
}

