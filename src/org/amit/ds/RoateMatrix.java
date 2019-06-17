package org.amit.ds;

public class RoateMatrix {
	
	public static void main(String[] args) {
		
		int mat[][] = { {1,2,3,4},
				     {4,5,6,7},
				     {8,9,10,11}
					};
	
		RoateMatrix r = new RoateMatrix();
		int [][] rotateMat = r.rotateMatrix(mat, 3, 4);
		r.prinRotateMatrix(rotateMat, 3, 4);;
		
		
	}
	
	int[][] rotateMatrix(int[][] mat, int row, int col ){
		
		
		
		
		return mat;
		
	}
	
	void prinRotateMatrix(int[][] mat, int row, int col) {
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(" "+ mat[i][j]);
				
			}
			System.out.println();
		}
		
	}
	

}
