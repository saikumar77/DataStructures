import java.util.*;

class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
	}
	public Node() {

	}
}

class Queuemethods {
	Node root;
	public Queuemethods() {
		root = null;
	}

	public void add(int data) {
		Node nptr = new Node(data);
		if(root == null) {
			root = nptr;
			return ;
		}
		Node n = root;
		while(n.next != null)  {
			n = n.next;
		}
		n.next = nptr;
	}

	public int remove() {
		Node d = root;
		root = root.next;
		return d.data;
	}

	public int peek() {
		return root.data;
	}

	public void printQueue() {
		Node dummy = root;
		while(dummy != null) {
			System.out.print(dummy.data + "->");
			dummy = dummy.next;
		}

	}

	public boolean isEmpty() {
		if(root == null)
			return true;
		else
			return false;
	}
}

class Queuelist {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Queuemethods obj = new Queuemethods();
		while (true) {
			System.out.println("1.add");
			System.out.println("2.remove");
			System.out.println("3.peek");
			System.out.println("4.printQueue");
			System.out.println("5.isEmpty");
			System.out.println("6.exit");
			int i = s.nextInt();
			if(i == 1) {
				int l = s.nextInt();
				obj.add(l);
			} else if (i == 2) {
				System.out.println(obj.remove());
			} else if (i == 3) {
				System.out.println(obj.peek());
			} else if (i==4) {
				obj.printQueue();
			} else if (i == 5) {
				System.out.println(obj.isEmpty());
			} else if (i == 6) {
				break;
			}
		}
	}
}