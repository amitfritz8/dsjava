package com.amazon.interview.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Print2DBST {

	static String[][] res = null;
	public static void main(String[] args) {
		TNode root = new TNode(10);
		
		root.left = new TNode(5);
		root.right = new TNode(15);
		root.left.left =  new TNode(4);
		
		printTree(root);
		   for(String[] str : res) {
		    	 System.out.println(Arrays.asList(str));
		      }
	}
	
	
  public static List<List<String>> printTree(TNode root) {

      int height = getHeight(root);

     res = new String[height][(1 << height) - 1];

      for(String[] arr:res)

          Arrays.fill(arr,"");

      List<List<String>> ans = new ArrayList<>();

      fill(res, root, 0, 0, res[0].length);

      for(String[] arr:res)

          ans.add(Arrays.asList(arr));
      
      for(String[] str : res) {
	    	 System.out.println(Arrays.asList(str));
	      }      
      return ans;

  }

 public static void fill(String[][] res, TNode root, int i, int l, int r) {

     if (root == null)

         return;

     res[i][(l + r) / 2] = "" + root.data;

     fill(res, root.left, i + 1, l, (l + r) / 2);

     fill(res, root.right, i + 1, (l + r + 1) / 2, r);

 }

 public static int getHeight(TNode root) {

     if (root == null)

         return 0;

     return 1 + Math.max(getHeight(root.left), getHeight(root.right));

    }

}
