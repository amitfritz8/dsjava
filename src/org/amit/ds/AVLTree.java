package org.amit.ds;

public class AVLTree {

	
	public static void main(String[] args) {
		TNode root = new TNode(1);
		root = insert(root,5);
		root = insert(root,10);
		root = insert(root,15);
		root = insert(root,27);
		root = insert(root,30);
		root = insert(root,50);
		root = insert(root,55);
		root = insert(root,60);
		root = insert(root,75);
		root = insert(root,-1);

		inOrder(root);
		System.out.println();
		root = delete(root, 10);
		root = delete(root, 10);
		inOrder(root);
	}

	public static TNode delete(TNode root, int key) {
		
		if(root==null) {
			System.out.println("Tree is Empty");
			return null;
		}
		
		if(key==root.data && root.left==null) {
			return root.right;
		}else if(key==root.data && root.right==null) {
			return root.left;
		}else if(key>root.data) {
			root.right=delete(root.right, key);
		}else if(key<root.data) {
			root.left=delete(root.left, key);
		}else {
			
			TNode parent = root.right;
			TNode succ = root.right;
			while(succ.left!=null) {
				parent=succ;
				succ=succ.left;
			}
			if(parent==succ) {
				root.right=root.right.right;
			}else {
				parent.left=succ.right;
			}
			root.data=succ.data;
			
			root.right=delete(root.right, key);
		}
		if(root==null) {
			return root;
		}
		int balance = getBalance(root);
		
		if(balance>1 && getBalance(root.left)>0 ) {
			return RRRotation(root);
		}else if(balance>1 && getBalance(root.left)<=0 ) {
			root.left=LLRotation(root.left);
			return RRRotation(root);
		}else if(balance<-1 && getBalance(root.right)>0 ) {
			return LLRotation(root);
		}else if(balance<-1 && getBalance(root.left)<=0 ) {
			root.right=RRRotation(root.right);
			return LLRotation(root);
		}
		
		return root;
	}
	
	public static TNode minValue(TNode root) {
		
		TNode parent=root;
		TNode temp = null;
		if(root.right.left==null) {
			temp = new TNode(root.right.data);
			parent.right=root.right.right;
			return temp;
		}
		
		 temp = root.right;

		 while(temp.left!=null && temp.left.left!=null) {
			 parent=temp.left;
			 temp=temp.left.left;
		 }
		 
		 if(parent.left.right!=null) {
			 temp= new TNode(parent.left.data);
			  parent.left=parent.left.right;
		 }
			
		return temp;
	}
	
	public static TNode insert(TNode root, int key) {
		
		if(root==null) {
			return new TNode(key);
		}
		if(key>root.data) {
			root.right = insert(root.right, key);
		}else if(key<root.data) {
			root.left = insert(root.left, key);
		}else if(key==root.data) {
			return root;
		}
		
		if(getBalance(root)>1 && key<root.left.data ) {
			return RRRotation(root);
			
		}else if( getBalance(root)>1 && key>root.left.data) {
			root.left=LLRotation(root.left);
			return RRRotation(root);
			
		}else if(getBalance(root)<-1 && key>root.right.data) {
			return LLRotation(root);
			
		}else if(getBalance(root)<-1 && key<root.right.data) {
			root.right=RRRotation(root.right);
			return LLRotation(root);
		}
		
		return root;
	}
	
	public static int getBalance(TNode node) {
		
		if(node==null) {
			return 0;
		}
		int lh = getHeight(node.left);
		int rh = getHeight(node.right);
		
		return lh-rh;
		
	}
	
	public static int getHeight(TNode node) {
		
		if(node==null) {
			return 0;
		}
		
		return 1+Math.max(getHeight(node.left), getHeight(node.right));
	}
	
	public static TNode LLRotation(TNode node) {
		TNode temp = node.right;
		TNode tempLeft = temp.left;
		temp.left = node;
		node.right=tempLeft;
		return temp;
	}
	
	public static TNode RRRotation(TNode node) {
		TNode temp = node.left;
		TNode tempRight = temp.right;
		temp.right=node;
		node.left=tempRight;
		return temp;
	}
	
	public static void inOrder(TNode root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data + " -->");
			inOrder(root.right);
		}
	}
	
	public static void print(TNode root) {
		
	}
}

class TNode {
	
	int data;
	int height;
	TNode left;
	TNode right;
	TNode parent;
	
	TNode(int data){
		this.data=data;
	}
	
	public String toString() {
		return data + " ";
	}
}