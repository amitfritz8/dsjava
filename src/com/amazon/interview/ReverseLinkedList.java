package com.amazon.interview;

public class ReverseLinkedList {
 
	static Node root;
	
	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.next =  new Node(2);
		node.next.next =  new Node(3);
		node.next.next.next =  new Node(4);
		node.next.next.next.next =  new Node(5);
		node.next.next.next.next.next =  new Node(6);
		node.next.next.next.next.next.next =  new Node(7);
		
		//Node head = reverListUsingRec(node);
		Node head = reverListUsingIterative(node);
		//Node head = reverse(node);
		print(head);
	}
	
	static Node reverse(Node head) {
		  // if head is null or only one node, it's reverse of itself.
		  if ( (head==null) || (head.next == null) ) return head;

		  // reverse the sub-list leaving the head node.
		  Node reverse = reverse(head.next);

		  // head.next still points to the last element of reversed sub-list.
		  // so move the head to end.
		  head.next.next = head;

		  // point last node to nil, (get rid of cycles)
		  head.next = null;
		  return reverse;
		}
	
	public static Node reverListUsingIterative(Node node) {
		
		Node curr; Node prev; Node next;
		prev=null;
		curr=node;
		next=null;
		while(curr!=null) {
			next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			
		}
		
		return prev;
	}
	public static Node reverListUsingRec(Node head) {
		
		if(head==null ||  head.next==null) {
			return head;
		}
		
		
		Node reverse = reverListUsingRec(head.next);
		
		head.next.next=head;
		head.next=null;
		return reverse;
	}
	
	
	public static void print(Node head) {
		
		while (head!=null) {
			System.out.print(head.data + "-->" );
			head=head.next;
		}
	}
}