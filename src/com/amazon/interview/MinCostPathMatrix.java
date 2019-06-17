package com.amazon.interview;

public class MinCostPathMatrix {

	public static void main(String[] args) {

		int cost[][] = { { 1, 2, 3 }, 
						 { 4, 8, 2 }, 
						 { 1, 5, 3 } };
		

		//System.out.print(minCostBF(cost, 2, 2));
		System.out.print(minCost(cost, 2, 2));

	}

	public static int minCost(int[][] matix, int row, int col) {
		
		int[][] minCost = new int[row+1][col+1];
		
		minCost[0][0] = matix[0][0];
		
		for(int i=1;i<=row;i++) {
			minCost[0][i] = matix[0][i-1]+matix[0][i];
		}
		
		for(int j=1;j<=col;j++) {
			minCost[j][0] = matix[j-1][0]+matix[j][0];
		}
		
		for( int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				minCost[i][j]= matix[i][j] + min(minCost[i-1][j],minCost[i][j-1],minCost[i-1][j-1]);
			}
		}
		
		
		return minCost[row][col];
	}
	
	public static int minCostBF(int[][] matrix, int row, int col) {

		if(row<0 || col<0) {
			return Integer.MAX_VALUE;
		}
			
		if(row==0 && col ==0) {
			return matrix[row][col];
		}
		
		return matrix[row][col] + min(minCostBF(matrix,row-1,col),minCostBF(matrix,row-1,col-1),
				minCostBF(matrix,row,col-1));
		
	}

  public static int min(int x, int y, int z) {
	   
	   if(x<y)
		 return  x<z?x:z;
	   else 
		 return  y<z?y:z; 
	   
   }
  
}