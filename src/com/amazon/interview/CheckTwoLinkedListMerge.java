package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class CheckTwoLinkedListMerge {

	public static void main(String[] args) {
		Node node =  new Node(20);
		node.next =  new Node(30);
		node.next.next =  new Node(40);
		node.next.next.next = new Node(50);
		
		Node node1 =  new Node(2);
		 node1.next =  new Node(3);
		 node1.next.next =  new Node(4);
		 node1.next.next.next =  new Node(5);
		 node1.next.next.next.next =  new Node(6);
		 
		 node.next.next.next.next = node1.next.next;
		 
		 //System.out.println(findMerginPointUsingHash(node,node1).data);
		 
		 //System.out.println(findMergingPointUsingLenght(node,node1).data);
		 System.out.println(findMergingPointUsingCircularLink(node,node1).data);

	}
	
	public static Node findMergingPointUsingCircularLink(Node l1, Node l2) {
		
		int count=0;
		
		Node temp = l1; Node last=null;
		
		while(temp!=null) {
			count++;
			last = temp;
			temp =  temp.next;
		}
		
		last.next=l1;
		temp = l2;
		while(temp!=null && count!=0) {
			count--;
			temp=temp.next;
		}
		
		while (temp!=null && l2!=null) {
			if(temp==l2)
				return temp;
			temp=temp.next;
			l2 = l2.next;
		}
		return null;
	}
	
	public static Node findMergingPointUsingLenght(Node l1, Node l2) {
		
		int count =0; int len1=0; int len2=0;
		Node temp = l1;
		while(temp!=null) {
			count++;
			temp =  temp.next;
		}
		
		len1= count;
		count=0;
		temp=l2;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		len2= count; 
		
		if(len1>len2) {
			count = len1-len2;
			while(l1!=null && count!=0) {
				count--;
				l1=l1.next;
			}
		}else if(len2>len1) {
			count = len2-len1;
			while(l2!=null && count!=0) {
				count--;
				l2=l2.next;
			}
		}
		
		while(l1!=null && l2!=null) {
			if(l1==l2)
				return l1;
			else {
				l1=l1.next;
				l2=l2.next;
			}
		}
		return null;
	}
	
	
	public static Node findMerginPointUsingHash(Node l1, Node l2) {
		
		if(l1==null || l2==null) {
			return null;
		}
		
		Map<Node,Node> map = new HashMap<>();
		
		while(l1!=null) {
			map.put(l1, l1);
			l1=l1.next;
		}
		
		while(l2!=null) {
			if(map.get(l2)!=null)
				break;
			l2=l2.next;
		}
		
		if(map.get(l2)==l2)
		return l2;
		else
			return null;
		
	}
	
}

class Node {
	
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
	}
}