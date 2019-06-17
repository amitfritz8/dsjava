package com.amazon.interview;

public class CountNoOfWaysThrowDice {

  public static void main(String[] args) {
	  
	 int sum=8,noOfdice = 3, noOfFaces = 6;
	  
	 int result = countNoOfWays(noOfdice,noOfFaces,sum);
	 System.out.println(result);
	 int[][] resultAry = new int[noOfdice+1][sum+1];
	 System.out.println(countNoOfWaysDP(3,6,8,resultAry));
  }
  
  
  public static int countNoOfWaysDP(int n, int m, int sum, int[][] result) {
	  
	  for(int i=1;i<=m;i++) {
		  result[1][i]=1;
	  }
	  
	  for(int i=2;i<=n; i++) {
		  for(int j=1;j<=sum;j++) {
			  for(int k=1;k<j && k<=m;k++) {
				  result[i][j]=result[i][j]+result[i-1][j-k];
			  }
		  }
	  }
	  
	  return result[n][sum];
  }
  
  public static int countNoOfWays (int n, int m, int sum) {
	  
	  if(n==0 && sum==0) {
		  return 1;
	  }
	  
	  if(n==0) {
		  return 0;
	  }
	  int count=0;
	  for(int i=1;i<=m;i++) {
		count = count+  countNoOfWays(n-1,m,sum-i);
	  }
	  
	  return count;
  }
	
}
