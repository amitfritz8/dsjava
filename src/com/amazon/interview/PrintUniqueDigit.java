package com.amazon.interview;

public class PrintUniqueDigit {

	public static void main(String[] args) {
		printDigit(1, 300);
	}
	
	
	static void printDigit(int start, int end) {
		
		for(int i=start;i<=end;i++) {
			boolean[] visited = new boolean[10];
			int no = i;
			while(no!=0) {
				int digit = no%10;
				if(visited[digit]) {
					break;
					
				}else {
					visited[digit]=true;
				}
				no = no/10;
			}
			if(no==0) {
				System.out.println(i);
			}
			
		}
		
	}
	
}
