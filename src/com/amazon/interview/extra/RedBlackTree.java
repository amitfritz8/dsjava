package com.amazon.interview.extra;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import com.amazon.interview.extra.RBTNode.Color;

public class RedBlackTree {

	public static void main(String[] args) {
		RBTNode root = insert(null, 10);
		root = insert(root, 15);
		root = insert(root, -10);
		root = insert(root, 20);
		root = insert(root, 30);
		root = insert(root, 40);
		root = insert(root, 50);
		root = insert(root, -15);
		root = insert(root, 25);
		root = insert(root, 17);
		root = insert(root, 21);
		root = insert(root, 24);
		root = insert(root, 28);
		root = insert(root, 34);
		root = insert(root, 32);
		root = insert(root, 26);
		root = insert(root, 35);
		root = insert(root, 19);
		printRedBlackTree(root, 0);

		root = delete(root, 50);
		System.out.println(validateRBT(root) + " " +  50);
		printRedBlackTree(root, 0);

		root = delete(root, 40);
		System.out.println(validateRBT(root)+ " " +  40);
		printRedBlackTree(root, 0);

		root = delete(root, -10);
		System.out.println(validateRBT(root)+ " " +  -10);
		printRedBlackTree(root, 0);

		root = delete(root, 15);
		System.out.println(validateRBT(root)+ " " +  15);
		printRedBlackTree(root, 0);

		root = delete(root, 17);
		System.out.println(validateRBT(root)+ " " +  17);
		printRedBlackTree(root, 0);

		root = delete(root, 24);
		System.out.println(validateRBT(root)+ " " +  24);
		printRedBlackTree(root, 0);

		root = delete(root, 21);
		System.out.println(validateRBT(root)+ " " +  21);
		printRedBlackTree(root, 0);

		root = delete(root, 32);
		System.out.println(validateRBT(root)+ " " +  32);
		printRedBlackTree(root, 0);

		root = delete(root, 26);
		System.out.println(validateRBT(root)+ " " +  26);
		printRedBlackTree(root, 0);

		root = delete(root, 19);
		System.out.println(validateRBT(root)+ " " +  19);
		printRedBlackTree(root, 0);

		root = delete(root, 25);
		System.out.println(validateRBT(root)+ " " +  25);
		printRedBlackTree(root, 0);

		root = delete(root, 17);
		System.out.println(validateRBT(root)+ " " +  17);
		printRedBlackTree(root, 0);

		root = delete(root, -15);
		System.out.println(validateRBT(root)+ " " +  -15);
		printRedBlackTree(root, 0);

		root = delete(root, 20);
		System.out.println(validateRBT(root)+ " " +  20);
		printRedBlackTree(root, 0);

		root = delete(root, 35);
		System.out.println(validateRBT(root)+ " " +  35);
		printRedBlackTree(root, 0);

		root = delete(root, 34);
		System.out.println(validateRBT(root)+ " " +  34);
		printRedBlackTree(root, 0);

		root = delete(root, 30);
		System.out.println(validateRBT(root)+ " " +  30);
		printRedBlackTree(root, 0);

		root = delete(root, 28);
		System.out.println(validateRBT(root)+ " " +  28);
		printRedBlackTree(root, 0);

		root = delete(root, 10);
		System.out.println(validateRBT(root)+ " " +  10);
		printRedBlackTree(root, 0);

	}

	public static void inOrder(RBTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + "-->");
			inOrder(root.right);
		}
	}

	public static RBTNode delete(RBTNode node, int key) {

		AtomicReference<RBTNode> root = new AtomicReference<RBTNode>(node);
		delete(node, key, root);
		
		
		if (root.get() == null) {
			return null;
		} 
		return node;
	}

	public static void delete(RBTNode node, int key, AtomicReference<RBTNode> root) {
		boolean doubleBlack = false;
		if (node == null) {
			return;
		} else {
			if (key > node.data) {
				delete(node.right, key, root);
			} else if (key < node.data) {
				delete(node.left, key, root);
			}
		}
		if (key == node.data) {

			if (node.left != null && node.right != null) {
				RBTNode temp = getSuccessor(node);
				int data = node.data ;
				node.data = temp.data;
				temp.data= data;
				delete(node.right, key,root);
			} else {

				if(node.parent==null && node.left!=null && node.right==null 
						&& node.left.color==Color.RED) {
					node.data=node.left.data;
					node.left=null;
					return;
				}
				
				if(node.parent==null && node.right!=null && node.left==null 
						&& node.right.color==Color.RED) {
					node.data=node.right.data;
					node.right=null;
					return;
				}
				
				if(node.parent==null && node.right==null && node.left==null) {
					if (node.parent == null) {
						node =null;
						root.set(node);
						return;
					}
				}
				
				if (node.left == null && node.right == null && node.color == Color.BLACK) {
					doubleBlack = true;
					if (node.parent.left == node) {
						checkDoubleBlack(doubleBlack, node, key, root);
						return;
					} else {
						checkDoubleBlack(doubleBlack, node, key, root);
						return;
					}
				}
				if (node.parent!=null && node.parent.right == node && node.left != null && node.right == null && node.color == Color.BLACK
						&& node.left.color == Color.RED) {
					doubleBlack = false;
					node.parent.right = node.left;
					node.left.parent=node.parent;
					node.parent.right.color = Color.BLACK;
					return;
				}
				if (node.parent!=null && node.parent.right == node && node.right != null && node.left == null && node.color == Color.BLACK
						&& node.right.color == Color.RED) {
					doubleBlack = false;
					node.parent.right = node.right;
					node.right.parent=node.parent;
					node.parent.right.color = Color.BLACK;
					return;
				} else if (node.left == null && node.right == null && node.color == Color.RED) {
					doubleBlack = false;
					if (node.parent.left == node) {
						node.parent.left = null;
						return;
					} else {
						node.parent.right = null;
						return;
					}
				} else if (node.left == null) {
					if (node.right != null && node.right.color == Color.RED) {
						node.parent.left = node.right;
						node.right.color = Color.BLACK;
					} else if (node.right != null && node.right.color == Color.BLACK) {
						node.parent.left = node.right;
						doubleBlack = true;
						checkDoubleBlack(doubleBlack, node, key, root);
					}
					return;
				} else if (node.parent!=null && node.parent.left == node && node.right == null && node.left != null
						&& node.left.color == Color.RED) {
					node.parent.left = node.left;
					node.left.parent=node.parent;
					node.parent.left.color = Color.BLACK;
					return;
				} else if (node.right != null && node.left.color == Color.BLACK) {
					node.parent.right = node.left;
					doubleBlack = true;
					checkDoubleBlack(doubleBlack, node, key, root);
				}
			}
		}
	}

	public static void deleteOneChild() {

	}

	public static void checkDoubleBlack(boolean doubleBlack, RBTNode node, int key, AtomicReference<RBTNode> root) {
		if (doubleBlack) {

			if (node.parent == null) {
				root.set(node);
				return;
			}

			if (node.parent.left == node && node.parent.color == Color.RED
					&& (getSibling(node) == null || (getSibling(node).color == Color.BLACK
							&& (getSibling(node).left == null || getSibling(node).left.color == Color.BLACK)
							&& (getSibling(node).right == null || getSibling(node).right.color == Color.BLACK)))) {

				if (getSibling(node) != null) {
					getSibling(node).color = Color.RED;
				}
				if (node.parent != null) {
					node.parent.color = Color.BLACK;
				}
				return;

			} else if (node.parent.right == node && node.parent.color == Color.RED
					&& (getSibling(node) == null || (getSibling(node).color == Color.BLACK
							&& (getSibling(node).left == null || getSibling(node).left.color == Color.BLACK)
							&& (getSibling(node).right == null || getSibling(node).right.color == Color.BLACK)))) {

				if (getSibling(node) != null) {
					getSibling(node).color = Color.RED;
				}
				if (node.parent != null) {
					node.parent.color = Color.BLACK;
					if(node.left==null && node.right==null) {
						node.parent.right=null;
					}
					
				}
				return;

			} else if (node.parent.left == node && node.parent.color == Color.BLACK
					&& (getSibling(node) == null || (getSibling(node).color == Color.BLACK
							&& (getSibling(node).left == null || getSibling(node).left.color == Color.BLACK)
							&& (getSibling(node).right == null || getSibling(node).right.color == Color.BLACK)))) {
				if (getSibling(node) != null) {
					getSibling(node).color = Color.RED;
				}
				if (node.parent != null) {
					node.parent.color = Color.BLACK;
					if(node.left==null && node.right==null) {
						node.parent.left = null;
					}
					
				}
				doubleBlack = true;
				checkDoubleBlack(doubleBlack, node.parent, key, root);

			} else if (node.parent.right == node && node.parent.color == Color.BLACK
					&& (getSibling(node) == null || (getSibling(node).color == Color.BLACK
							&& (getSibling(node).left == null || getSibling(node).left.color == Color.BLACK)
							&& (getSibling(node).right == null || getSibling(node).right.color == Color.BLACK)))) {

				if (getSibling(node) != null) {
					getSibling(node).color = Color.RED;
				}
				if (node.parent != null) {
					node.parent.color = Color.BLACK;
					if(node.left==null && node.right==null) {
						node.parent.right=null;
					}
					
				}
				doubleBlack = true;
				checkDoubleBlack(doubleBlack, node.parent, key, root);

			} else if (getSibling(node) != null && getSibling(node).color == Color.RED) {
				if (getSibling(node) == node.parent.right) {
					LLrotation(getSibling(node), true);
				} else {
					RRrotation(getSibling(node), true);
				}
				doubleBlack = true;
				checkDoubleBlack(doubleBlack, node, key, root);
			} else if (node.parent.left == node && (getSibling(node).color == Color.BLACK)
					&& getSibling(node).right != null && getSibling(node).right.color == Color.RED) {
				// node.parent.left=null;
				RBTNode temp = getSibling(node);
				RBTNode temp1 = LLrotation(temp, true);
				if(temp1.parent.right==temp1.left) {
					temp1.parent.right = temp1;
				}else {
					temp1.parent.left = temp1;
				}
				temp.right.color = Color.BLACK;
				node.parent.left = null;
				return;

			} else if (node.parent.right == node && (getSibling(node) == null || getSibling(node).color == Color.BLACK)
					&& getSibling(node).left != null && getSibling(node).left.color == Color.RED) {
				RBTNode parent = node.parent;
				RBTNode sibling = getSibling(node);
				RBTNode temp = RRrotation(sibling, true);
				sibling.left.color = Color.BLACK;
				parent.right = null;
				temp.parent.right = temp;
				return;

			} else if (node.parent.left == node && (getSibling(node) == null || getSibling(node).color == Color.BLACK)
					&& (getSibling(node).right == null
							|| getSibling(node).right != null && getSibling(node).right.color == Color.BLACK)
					&& getSibling(node).left != null && getSibling(node).left.color == Color.RED) {
				RBTNode temp = RRrotation(getSibling(node).left, true);
				temp.parent.right = temp;
				doubleBlack = true;
				checkDoubleBlack(doubleBlack, node, key, root);

			} else if (node.parent.right == node && (getSibling(node) == null || getSibling(node).color == Color.BLACK)
					&& (getSibling(node).left == null
							|| getSibling(node).left != null && getSibling(node).left.color == Color.BLACK)
					&& getSibling(node).right != null && getSibling(node).right.color == Color.RED) {
				LLrotation(getSibling(node).right, true);
				doubleBlack = true;
				checkDoubleBlack(doubleBlack, node, key, root);
			}
		}
	}

	public static RBTNode getSuccessor(RBTNode node) {
		RBTNode temp = node.right;
		if (temp.left == null) {
			return temp;
		}
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp;
	}

	public static RBTNode insert(RBTNode node, int key) {

		RBTNode root = insert(null, node, key);
		root.color = Color.BLACK;
		return root;
	}

	public static RBTNode insert(RBTNode parent, RBTNode root, int key) {
		RBTNode left = null, right = null;
		if (root == null && parent == null) {
			return new RBTNode(key, Color.BLACK);
		} else if (root == null) {
			RBTNode newNode = new RBTNode(key, Color.RED);
			newNode.parent = parent;
			return newNode;
		} else if (key < root.data) {
			left = insert(root, root.left, key);
			if (left.right == root) {
				return left;
			}
			root.left = left;
		} else if (key > root.data) {
			right = insert(root, root.right, key);
			if (right.left == root) {
				return right;
			}
			root.right = right;
		} else {
			return root;
		}

		if (root.color.equals(Color.RED) && getSibling(root) != null && getSibling(root).color.equals(Color.RED)) {
			root.color = Color.BLACK;
			getSibling(root).color = Color.BLACK;
			if (root.parent != null) {
				root.parent.color = Color.RED;
			}
		} else if (left != null && root.parent != null && root.parent.left == root && key < root.data
				&& root.color.equals(Color.RED) && root.color.equals(left.color)
				&& (getSibling(root) == null || getSibling(root).color.equals(Color.BLACK))) {

			return RRrotation(root, true);

		} else if (right != null && root.parent != null && root.parent.left == root && key > root.data
				&& root.color.equals(Color.RED) && root.color.equals(right.color)
				&& (getSibling(root) == null || getSibling(root).color.equals(Color.BLACK))) {

			return RRrotation(LLrotation(right, false), true);

		} else if (right != null && root.parent != null && root.parent.right == root && key > root.data
				&& root.color.equals(Color.RED) && root.color.equals(right.color)
				&& (getSibling(root) == null || getSibling(root).color.equals(Color.BLACK))) {

			return LLrotation(root, true);

		} else if (left != null && root.parent != null && root.parent.right == root && key < root.data
				&& root.color == Color.RED && root.color.equals(left.color)
				&& (getSibling(root) == null || getSibling(root).color.equals(Color.BLACK))) {

			return LLrotation(RRrotation(left, false), true);
		}

		return root;
	}

	public static RBTNode getSibling(RBTNode node) {
		if (node.parent == null) {
			return null;
		} else if (node.parent.right == null) {
			return null;
		} else {
			if (node.parent.left == node) {
				return node.parent.right;
			} else {
				return node.parent.left;
			}
		}
	}

	public static RBTNode RRrotation(RBTNode node, boolean colorChange) {

		RBTNode temp = node.right;
		RBTNode parentTemp = node.parent.parent;
		node.right = node.parent;
		node.parent.left = temp;
		node.parent.parent = node;
		if (temp != null) {
			temp.parent = node.parent;
		}
		node.parent = parentTemp;

		if (colorChange) {
			Color colorTemp = node.color;
			node.color = node.right.color;
			node.right.color = colorTemp;
		}
		return node;
	}

	public static RBTNode LLrotation(RBTNode node, boolean colorChange) {

		RBTNode temp = node.left;
		RBTNode parentTemp = node.parent.parent;
		node.left = node.parent;
		node.parent.right = temp;
		node.parent.parent = node;
		if (temp != null) {
			temp.parent = node.parent;
		}
		node.parent = parentTemp;

		if (colorChange) {
			Color colorTemp = node.color;
			node.color = node.left.color;
			node.left.color = colorTemp;
		}
		return node;

	}

	public static boolean validateRBT(RBTNode root) {

		return isRedNodeAdjacent(root);
	}

	public static boolean blackNodeCount(RBTNode root, AtomicInteger blackCount, int curCount) {

		if (root == null) {
			return true;
		}
		if (root.color == Color.BLACK) {
			curCount++;
		}
		if (root.left == null && root.right == null) {
			if (blackCount.get() == 0) {
				blackCount.set(curCount);
				return true;
			} else {
				return curCount == blackCount.get();
			}
		}
		return blackNodeCount(root.left, blackCount, curCount) && blackNodeCount(root.right, blackCount, curCount);
	}

	public static boolean isRedNodeAdjacent(RBTNode root) {

		if (root == null) {
			return true;
		}

		if (root != null && root.parent != null && root.color == Color.RED && root.color.equals(root.parent.color)) {
			return false;
		}

		return isRedNodeAdjacent(root.left) && isRedNodeAdjacent(root.right);
	}

	private static void printRedBlackTree(RBTNode root, int space) {
		if (root == null) {
			return;
		}
		printRedBlackTree(root.right, space + 5);
		for (int i = 0; i < space; i++) {
			System.out.print(" ");
		}
		System.out.println(root.data + " " + (root.color == Color.BLACK ? "B" : "R"));
		printRedBlackTree(root.left, space + 5);
	}

}

class RBTNode {
	enum Color {
		RED, BLACK;
	}

	int data;
	boolean isLeaf;
	RBTNode left;
	RBTNode right;
	RBTNode parent;
	Color color;

	RBTNode(int data) {
		this.data = data;
		this.color = Color.RED;
	}

	RBTNode(int data, Color color) {
		this.data = data;
		this.color = color;
	}

	public String toString() {
		return data + " " + (color.equals(Color.RED) ? "R" : "B");
	}
}