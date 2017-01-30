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

class Stackmethods {
	Node root;

	public Stackmethods() {
		root = null;
	}

	public boolean isEmpty() {
		if(root == null)
			return true;
		else
			return false;
	}

	public void push(int data) {
		Node nptr = new Node(data);
		if(root == null) {
			root = nptr;
			return;
		}
		nptr.next = root;
		root = nptr;
		return ;
	}

	public void pop() {
		root = root.next;
		return ;
	}

	public int peek() {
		return root.data;
	}

	public void printStack() {
		Node n = root;
		while(n != null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
}

class Stacklist {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Stackmethods obj = new Stackmethods();
		while (true) {
			System.out.println("1.push");
			System.out.println("2.pop");
			System.out.println("3.peek");
			System.out.println("4.printStack");
			System.out.println("5.isEmpty");
			System.out.println("6.exit");
			int i = s.nextInt();
			if(i == 1) {
				int l = s.nextInt();
				obj.push(l);
			} else if (i == 2) {
				obj.pop();
			} else if (i == 3) {
				obj.peek();
			} else if (i == 4) {
				obj.printStack();
			} else if (i == 5) {
				obj.isEmpty();
			} else if (i == 6) {
				break;
			}
		}
	}
}