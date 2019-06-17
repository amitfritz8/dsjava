package com.amazon.interview;

public class BooleanMatrixMakeRowColumnOne {

	
	public static void main(String[] args) {
		int[][] boolMatrix = { {1,0,0,1,0},
							   {1,1,0,1,0},
							   {0,0,0,0,0},
							   {0,0,0,0,0},
		};
		int row =4, col=5;
	
		System.out.println("Matrix befor: ");
		print(boolMatrix,row,col);
		
		printBooleanMatrix(boolMatrix,row,col);
		
		System.out.println("Matrix After: ");
		print(boolMatrix,row,col);
		
	}
	
	static void print(int [][] matrix, int row, int col) {
		
		for(int i=0;i<row;i++) {
			System.out.print("[");
			for(int j=0;j<col;j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.print("]");
			System.out.println();
	}

	}
	
	static void printBooleanMatrix (int[][] boolMax, int row, int col) {
		
		int [][] temp = new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				temp[i][j]=boolMax[i][j];
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				
				if(temp[i][j]==1) {
					
					for(int k=0,l=0;k<row||l<col;k++,l++) {
						
						if(l<col) {
							boolMax[i][l]=1;
						}
						if(k<row) {
							boolMax[k][j]=1;
						}
					}
					
				}
			}
		}
		
	}
	
}
