package com.amazon.interview;

public class CountWaysTorReachNStairs {

	public static void main(String[] args) {
		
		//System.out.println(countNoOfWaysRec(2,6));
		
		System.out.println(countNoOfWaysDP(5,6));
		
		
	}
	
	public static int countNoOfWaysDP(int m, int n) {
		
		int[] res = new int[n+1];
		
		res[0]=1;res[1]=1;res[2]=2;
		
		for(int i=3;i<=res.length-1;i++) {
			for(int j=1;j<=m && j<=i;j++) {
				res[i] = res[i] + res[i-j];
			}
		}
		return res[n];
	}
	
	public static int countNoOfWaysRec(int m, int n){
		
		if(n==0||n==1)
			return 1;
		
		int res = 0;
		
		for(int i=1;i<=m;i++) {
			res = res + countNoOfWaysRec(m,n-i);
		}
		
		return res;
	}
	
	
}
