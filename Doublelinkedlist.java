import java.util.*;

class Node {
	int data;
	Node prev;
	Node next;

	public Node(int data) {
		this.data = data;
		prev = null;
		next = null;
	}
}

class DLLmethods {
	Node root;

	public DLLmethods() {
		root = null;
	}

	public void insertAtend(int data) {
		Node nptr = new Node(data);
		if(root == null) {
			root = nptr;
			return ;
		}
		Node n = root;
		while(n.next != null) {
			n = n.next;

		}
		n.next = nptr;
		nptr.prev = n;
		return ;
	}

	public void insertAtStart(int data) {
		Node nptr = new Node(data);
		if(root == null) {
			root = nptr;
			return ;
		}
		nptr.next = root;
		root.prev = nptr;
		root = nptr;
		return ;
	}

	public void printList() {
		Node n = root;
		while(n!=null) {
			System.out.print(n.data + "<->");
			n = n.next;
		}
	}

	public void deleteFirst() {
		root = root.next;
		root.prev = null;
		return;
	}

	public void deleteLast() {
		Node n = root;
		while(n.next != null) {
			n = n.next;
		}
		Node n2 = n.prev;
		n2.next = null;
		n.prev = null;
		return;
	}
}

class Doublelinkedlist {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		DLLmethods obj = new DLLmethods();
		while (true) {
			System.out.println("1.insertAtStart");
			System.out.println("2.insertAtend");
			System.out.println("3.deleteFirst");
			System.out.println("4.deleteLast");
			System.out.println("5.printlist");
			int i = s.nextInt();
			if(i == 1) {
				int l1 = s.nextInt();
				obj.insertAtStart(l1);
			} else if (i==2) {
				int l2 = s.nextInt();
				obj.insertAtend(l2);
			} else if (i == 3) {
				obj.deleteFirst();
			} else if (i==4) {
				obj.deleteLast();
			} else if (i==5) {
				obj.printList();
			} else{
				break;
			}
		}
	}
}