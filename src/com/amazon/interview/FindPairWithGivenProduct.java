package com.amazon.interview;

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairWithGivenProduct {
	
	
	public static void main(String[] args) {
		
		int[] numberAry = {8,5,8,7,3,62,19,15,12,6};
		quickSort(numberAry,0,numberAry.length-1);
		System.out.println(Arrays.toString(numberAry));
		boolean isProduct = isProductBFMethod(numberAry,16);
		System.out.println(isProduct);
		boolean isProductHash = isProductHashMethod(numberAry,16);
		System.out.println(isProductHash);
	}
	
	
	static boolean isProductHashMethod(int[] numberAry, int product) {
		
		Map map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<numberAry.length;i++) {
			if(product%numberAry[i]==0) {
				if(map.get(product/numberAry[i])!=null){
					return true;
				}else {
					map.put(numberAry[i], numberAry[i]);
				}
			}
		}
		
		return false;
	}
	
	static boolean isProductBSMethod(int[] noAry, int product) {
		
		for(int i=0;i<noAry.length-1;i++) {
			if(product%noAry[i]==0) {
				int no = product/noAry[i];
				if(binarySearch(no,noAry,i+1,noAry.length-1 )) {
					return true;
				}else
					return false;
			}
		}
		
		return false;
	}
	
	static boolean binarySearch(int no, int[]noAry, int start, int end) {
		
		if(start<end) {
			int mid = (start+end)/2;
			if(noAry[mid]==no)
				return true;
			binarySearch(no,noAry,start,mid-1);
			binarySearch(no,noAry,mid+1,end);

		}
		return false;
	}
	
	static boolean isProductBFMethod(int[] noAry, int product) {
		
		for(int i=0;i<noAry.length;i++) {
			for(int j=i+1;j<noAry.length;j++) {
				if(noAry[i]*noAry[j]==product) 
					return true;
			}
		}
		return false;
	}
	
	static void quickSort(int[] aryNo,int start, int end) {
	
		if(start<end) {
		int p = partition(aryNo,start,end);
		
		System.out.println("Parition p index: "+ p + "--> " + aryNo[p]);
		
		System.out.println("Start Index:--> " + start+ " & End Index:--> " + end);
		for(int i=start;i<=end;i++) {
			System.out.print(  "[ " + aryNo[i] + "], ");
		}
		System.out.println();

		quickSort(aryNo,start,p-1);
		quickSort(aryNo,p+1,end);
		}
	}
	
	static int partition(int[] aryNo, int start, int end) {
		
		int i=start-1; int pivot=end; int temp=0;
		
		for(int j=start;j<=end-1;j++) {
			if(aryNo[j]<aryNo[pivot]) {
				temp=aryNo[++i];
				aryNo[i]=aryNo[j];
				aryNo[j]=temp;
			}
		}
	
		temp=aryNo[++i];
		aryNo[i]=aryNo[pivot];
		aryNo[pivot]=temp;
		
		return i;
	}

}
