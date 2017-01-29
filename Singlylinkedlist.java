import java.util.*;
import java.io.*;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public Node() {
	}
}

class Singly {
	Node root;

	public Singly() {
		root = null;
	}

	public void insertAtStart(int data) {
		Node nptr = new Node(data);
		if(root == null) {
			root = nptr;
			return ;
		}
		nptr.next = root;
		root = nptr;
		return ;
	}

	public void insertAtEnd(int data) {
		Node nptr = new Node(data);
		if(root == null) {
			root=nptr;
			return ;
		}
		Node dummy = root;

		while (dummy.next != null) {
			dummy = dummy.next;
		}
		dummy.next = nptr;
		return ;
	}

	public void reverseList() {
		Node prev = null;
		Node curr = root;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		root = prev;
	}

	public void print() {
		Node dummy = root;
		while (dummy != null) {
			System.out.print(dummy.data + "->");
		}
	}
}

class Singlylinkedlist {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

	}
}