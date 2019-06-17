package com.amazon.interview.extra;

public class TNode {
	
	public int data;
	public TNode left;
	public TNode right;
	public TNode parent;
	public int height;
	
	public TNode(int data){
		this.data=data;
	}
	
	public String toString() {
		return " " +  data;
	}
}
