package com.amazon.interview;

import com.amazon.interview.extra.AVLTree;
import com.amazon.interview.extra.Print2DBST;
import com.amazon.interview.extra.TNode;

public class NextHighestNodeBST {

	public static void main(String[] args) {

		TNode root = null;
		AVLTree tree = new AVLTree();
		root = tree.insert(10, root);
		root = tree.insert(20, root);
		root = tree.insert(30, root);
		root = tree.insert(40, root);
		root = tree.insert(50, root);
		root = tree.insert(25, root);

		TNode inOrderSuc = null;
		TNode node = new TNode(25);
		TNode temp = tree.findNode(root, node);
		if (temp != null) {
			inOrderSuc = findInorderSuc(root, temp,null);
			if (inOrderSuc != null) {
				System.out.println("InOrder Suc of " + node.data + " is " + inOrderSuc.data);
			} else {
				System.out.println("Successor is not present for " + node.data);
			}

		} else {
			System.out.println(node.data + " is not present");
		}

		Print2DBST.printTree(root);
		tree.inOrder(root);

	}

	static TNode findInorderSuc(TNode root, TNode node, TNode lastLeftNode) {

		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		} else {
			if(node.data==root.data) {
				return lastLeftNode;
			}else if(node.data>root.data) {
				return findInorderSuc(root.right,node,lastLeftNode);
			}else {
				lastLeftNode = root;
			return findInorderSuc(root.left,node,lastLeftNode);
			}
				/*while (node.parent != null && node.parent.data < node.data) {
					node = node.parent;
				}
				return node.parent;*/
			}
	}

}
