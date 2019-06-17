package com.amazon.interview.extra;

public class AVLTree {

	public int findHeght(TNode root) {
		
		if(root==null) {
			return 0;
		}else {
			int lH = 1+findHeght(root.left);
			int rH = 1+findHeght(root.right);
			return (lH>rH)?lH:rH;
		}
	}
	
	public TNode insert(int data, TNode root) {

		if (root == null) {
			root = new TNode(data);
			return root;
		} else {
			TNode temp = new TNode(data);
			if (temp.data < root.data) {
				 root.left = insert(data, root.left);
				 root.left.parent = root;
			} else {
				 root.right = insert(data, root.right);
				 root.right.parent=root;
			}
		}
		
		root.height = 1+Math.max(findHeght(root.left), findHeght(root.right));
		
		int bFactor = findHeght(root.left) - findHeght(root.right);
		
		if(bFactor>1 && data <root.left.data) {
			return RRRotation(root);
		}else if(bFactor>1 && data >root.left.data) {
			root.left = LLRotation(root.left);
			return RRRotation(root);
		}else if(bFactor<-1 && data >root.right.data) {
			return LLRotation(root);
		}else if(bFactor<-1 && data <root.right.data) {
			root.right = RRRotation(root.right);
			return LLRotation(root);
		}
		
		return root;
	}

	public TNode findNode(TNode root, TNode node) {
		
		if(root!=null) {
			if(root.data==node.data) {
				return root;
			}else if(node.data>root.data) {
				return findNode(root.right,node);
			}else {
				 return findNode(root.left,node);
			}
		}
		return null;
	}
	
	public void inOrder(TNode root) {
		
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data + "--> ");
			inOrder(root.right);
		}
	}
	
	public TNode LLRotation(TNode node) {
		
		TNode temp = node.right;
		node.right = temp.left;
		temp.left = node;
		
		temp.parent=node.parent;
		node.parent=temp;
		
		temp.left.height= 1+ Math.max(findHeght(temp.left.left), findHeght(temp.left.right));
		temp.height= 1+ Math.max(findHeght(temp.left), findHeght(temp.right));
		
		return temp;
	}
	
	public TNode RRRotation(TNode node) {
		
		TNode temp  = node.left;
		node.left = temp.right;
		temp.right = node;
		
		temp.parent=node.parent;
		node.parent=temp;
		
		temp.right.height= 1+ Math.max(findHeght(temp.right.left), findHeght(temp.right.right));
		temp.height= 1+ Math.max(findHeght(temp.left), findHeght(temp.right));
		
		return temp;
	}
	
}
