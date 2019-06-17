package com.amazon.interview;

import com.amazon.interview.extra.TNode;

public class CheckBinaryTreeBST {

	public static void main(String[] args) {
		
		 TNode root = new TNode(4); 
		    root.left     = new TNode(2); 
		    root.right     = new TNode(5); 
		    root.left.left = new TNode(1); 
		    root.left.right = new TNode(3); 
		    
		 //System.out.println(isBST(root,new TNode(Integer.MIN_VALUE)));
		    
		  System.out.println(isBSTree(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}
	
	
	public static boolean isBSTree(TNode node,int min, int max) {
		
		if(node!=null) {
		if(node.data<min || node.data>max) {
			return false;
		} 
		if(!isBSTree(node.left,min, node.data))
			return false;
		 
		return isBSTree(node.right,node.data,max);
		}
		return true;
	}

	public static boolean isBST(TNode root, TNode prev) {
		
		if(root!=null) {
			
			 if(!isBST(root.left,prev))
				return false;
			
			 System.out.println(root.data + " " +  prev);
			if(prev!=null && root.data<prev.data) {
				return false;
			}
			// prev.data = root.data;
			 prev = root;
			 return isBST(root.right,prev);
		}
		return true;
	}
	
}	
