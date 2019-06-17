package com.amazon.interview;

public class CountTheNoOccInSortedArray {

	static int count = 0;

	public static void main(String[] args) {

		int[] ary = { 2, 3, 3, 3, 4, 5, 5, 6, 6, 6, 6, 6, 7, 8 };

		// System.out.println(findNoOfOcc(ary,6));


		int left = leftIndex(ary,6,0,ary.length-1);
		
		int right = rightIndex(ary,6,0,ary.length-1);
		
		System.out.println(right);
		System.out.println(left);

		if(left==-1 && right==-1) {
			System.out.println(-1);
		}else {
			System.out.println(right - left + 1);
		}
	}

	static int leftIndex(int[] ary,int no,int start, int end) {
		
		if(start<=end) {
			
			int mid = (start+end)/2;
			if((mid==0 ||ary[mid-1]<no) && (ary[mid]==no)) {
				return mid;
			} else if(ary[mid]>=no) {
				return leftIndex(ary, no, start, mid-1);
			}else {
				return leftIndex(ary, no, mid+1, end);	
			}
			
		}
		
		return -1;
	}
	
	static int rightIndex(int[] ary,int no, int start, int end) {
		if(start<=end) {
			
			int mid = (start+end)/2;
			 if(mid==ary.length-1 && ary[mid]==no|| (ary[mid]==no && ary[mid+1]>no) ) {
				 return mid;
			 } 
			 else if(ary[mid]>no) {
				return rightIndex(ary,no,start,mid-1);
			 }else {
				return rightIndex(ary,no,mid+1,end);
			 }
			
		}
		return -1;
	}

	static int findNoOfOcc(int[] ary, int no) {
		int count = 0, i = 0;

		int index = binarySearch(ary, 0, ary.length - 1, no);

		if (index == -1) {
			return count;
		} else {

			i = index - 1;
			count = count + 1;

			while (ary[i] == no) {
				i--;
				count++;
			}
			i = index + 1;
			while (ary[i] == no) {
				i++;
				count++;
			}

		}

		return count;
	}

	static int binarySearch(int[] ary, int start, int end, int no) {

		if (start <= end) {
			int mid = (start + end) / 2;
			if (ary[mid] == no) {
				System.out.println(ary[mid]);
				return mid;
			}

			if (ary[mid] > no) {
				return binarySearch(ary, start, mid - 1, no);
			} else {
				return binarySearch(ary, mid + 1, end, no);
			}

		}

		return -1;

	}

}
