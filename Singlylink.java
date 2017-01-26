import java.util.Scanner;
import java.util.Hashtable;
class Node {
	private int data;
	private Node next;

	public Node(int n) {
		data = n;
	}

	public Node() {

	}

	public void setData(int n) {
		data = n;
	}
	public void setLink(Node n) {
		next = n;
	}
	public int getData(){
		return data;
	}
	public Node getLink(){
		return next;
	}
}

class Singlylink {
	Node head;
	void insertAtStart(int n) {
		Node nptr = new Node(n);
		if(head == null) {
			head = nptr;
			return ;
		}
		nptr.setLink(head);
		head = nptr;
	}

	void insertAtEnd(int n) {
		Node nptr = new Node(n);
		if(head == null) {
			head = nptr;
			return ;
		}
		Node tmp = head;
		while(tmp.getLink() != null) {
			tmp = tmp.getLink();
		}
		tmp.setLink(nptr);
	}

	void insertAtPos(int i,int n) {
		Node nptr = new Node(n);
		if(i == 0){
			insertAtStart(n);
			return ;
		}
		Node tmp = head;
		for(int j = 0; j < i-1;j++)
			tmp = tmp.getLink();
		Node tmp2 = tmp.getLink();
		tmp.setLink(nptr);
		nptr.setLink(tmp2);
	}

	void delete(int n) {
		//deleting the first occurenec of integer
		Node tmp = head;
		Node tmp2 = tmp;
		if(n == tmp.getData()) {
			head = head.getLink();
			return ;
		}
		while(tmp != null) {
			if(tmp.getData() == n){
				tmp2.setLink(tmp.getLink());
			}
			tmp2 = tmp;
			tmp = tmp.getLink();
		}
	}

	void deleteAtPos(int i) {
		//deleting the first elment
		if(i == 0) {
			head = head.getLink();
			return ;
		}
		Node tmp = head;
		for(int j = 0; j < i - 1;j++) {
			if(tmp == null) {
				System.out.println("check for the element");
				return ;
			}
			tmp = tmp.getLink();
		}
		if(tmp.getLink() != null && tmp.getLink().getLink() == null) {
			tmp.setLink(null);
			return ;
		}
		//deleting the last element
		if(tmp.getLink() == null || tmp.getLink().getLink() == null) {
			System.out.println("check for the element");
			return ;
		}
		tmp.setLink(tmp.getLink().getLink()); 
	}

	void print() {
		Node tmp = head;
		while (tmp.getLink() != null) {
			System.out.print(tmp.getData() + "->" );
			tmp = tmp.getLink();
		}
		System.out.println(tmp.getData());
	}

	void reverse() {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null) {
			next = curr.getLink();
			curr.setLink(prev);
			prev = curr;
			curr = next;	
		}
		head = prev;
		
	}

	int length() {
		Node temp = head;
		int count = 0;
		while(temp != null){
			temp = temp.getLink();
			count++;
		}
		return count;
	}

	int lengthusingrecurr(Node temp) {
		if(temp == null)
			return 0;
		else {
			return 1 + lengthusingrecurr(temp.getLink());
		}
	}

	void swapNodesgivenData(int n1,int n2) {
		if(n1 == n2)
			return;
		Node temp1 = head;
		Node temp2 = head;
		Node prev1 = null;
		Node prev2 = null;
		while(temp1 != null && temp1.getData() != n1) {
			prev1 = temp1;
			temp1 = temp1.getLink();
		}
		while(temp2 != null && temp2.getData() != n2) {
			prev2 = temp2;
			temp2 = temp2.getLink();
		}
		if(temp1.getData() != n1 || temp2.getData() != n2) {
			System.out.println("Nodes do not exist");
			return;
		}
		if(temp1.getLink().getData() == n2) {
			Node d2 = temp2.getLink();
			prev1.setLink(temp2);
			temp2.setLink(temp1);
			temp1.setLink(d2);
			return;
		}
		if(temp2.getLink().getData() == n1) {
			Node d2 = temp1.getLink();
			prev2.setLink(temp1);
			temp1.setLink(temp2);
			temp2.setLink(d2);
			return;
		}
		Node d = temp2.getLink();
		if(prev1 == null)
			head = temp2;
		else
			prev1.setLink(temp2);
		if(prev2 == null)
			head = temp1;
		else
			prev2.setLink(temp1);
		temp2.setLink(temp1.getLink());
		temp1.setLink(d);
	}

	public int countTokens(int l) {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			if(temp.getData() == l)
				count++;
			temp = temp.getLink();
		}
		return count;
	}

	public int getNthnode(int i) {
		Node temp = head;
		int count = 0;
		while(temp != null && count < i) {
			temp = temp.getLink();
			count++;
		}
		if(count == i)
			return temp.getData();
		else
			return -1;
	}

	public Node getMiddlenode() {
		Node slow = head;
		Node fast = head;
		while(fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
		}
		return slow;
	}

	public Node getNthfromlast(int i) {
		Node ref_ptr = head;
		Node main_ptr = head;
		for(int j = 0; j < i;j++)
			ref_ptr = ref_ptr.getLink();
		while(ref_ptr != null) {
			main_ptr = main_ptr.getLink();
			ref_ptr = ref_ptr.getLink();
		}
		return main_ptr;
	}

	public void deletelist() {
		head = null;
	}

	public void detectloop() {
		Node slow = head;
		Node fast = head;
		while(slow != null && fast.getLink() != null && fast.getLink().getLink() != null) {
			slow = slow.getLink();
			fast = fast.getLink().getLink();
			if(slow == fast) {
				System.out.println("loop detected");
			}
		}
	}

	public void printReverse(Node temp) {
		if(temp == null)
			return;
		printReverse(temp.getLink());
		System.out.print(temp.getData() + "->");
	}

	public void removedupinsortedlist() {
		Node temp = head;
		while(temp != null && temp.getLink() != null) {
			Node temp1 = temp.getLink();
			if(temp.getData() == temp1.getData()) {
				temp.setLink(temp1.getLink());
			} 
			else
				temp = temp.getLink();
		}
	}

	public void removeDupInUnSortedList() { //using two while loops
		Node temp = head;
		while(temp != null) {
			Node temp1 = temp.getLink();
			while(temp1 != null) {
				if(temp.getData() == temp1.getData()) {
					temp.setLink(temp1.getLink());
				}
				temp1 = temp1.getLink();
			}
			temp = temp.getLink();
		}
	}

	// public void removeDupInUnSortedListHashing() { //using hashing or sets
	// 	Hashtable<Node> ht = new Hashtable<Node>();
	// 	Node temp = head;
	// }

	public void pairwiseswap() {
		Node temp = head;
		while(temp != null && temp.getLink() != null) {
			int d1 = temp.getData();
			int d2 = temp.getLink().getData();
			temp.getLink().setData(d1);
			temp.setData(d2);
			temp = temp.getLink().getLink();
		}
	}

	public void printAlternates(Node temp) {
		if(temp == null)
			return;
		System.out.print(temp.getData() + "->");
		printAlternates(temp.getLink().getLink());
		System.out.print(temp.getData() + "->");
	}

	public void movelastoFirst() {
		Node temp = head;
		Node prev = null;
		while(temp.getLink() != null) {
			prev = temp;
			temp = temp.getLink();
		}
		prev.setLink(null);
		temp.setLink(head);
		head = temp;
	}

	public Node mergesortedLists(Node head1,Node head2) {
		Node result = null;
		Node dummy = null;
		while(head1 != null && head2 != null) {
			if(head1.getData() < head2.getData()) {
				if(result == null) {
					result = head1;
					dummy = head1;
				} else {
					dummy.setLink(head1);
					dummy = dummy.getLink();
				}
				head1 = head1.getLink();
			} else {
				if(result == null) {
					result = head2;
					dummy = head2;
				} else {
					dummy.setLink(head2);
					dummy = dummy.getLink();
				}
				head2 = head2.getLink();
			}
		}
		while(head1 != null) {
			if(result == null) {
				result = head1;
				dummy = head1;
			} else {
				dummy.setLink(head1);
				dummy = dummy.getLink();
			}
			head1 = head1.getLink();
		}
		while(head2 != null) {
			if(result == null) {
				result = head2;
				dummy = head2;
			} else {
				dummy.setLink(head2);
				dummy = dummy.getLink();
			}
			head2 = head2.getLink();
		} 
		return result;
	}
	void printbygivingHead(Node head) {
		Node tmp = head;
		while (tmp.getLink() != null) {
			System.out.print(tmp.getData() + "->" );
			tmp = tmp.getLink();
		}
		System.out.println(tmp.getData());
	}

	void sortedIntersect(int l) {
		Node nptr = new Node(l);
		Node temp = head;
		Node prev = null;
		while(temp != null) {
			prev = temp;
			if(temp.getData() > l) {
				Node d = prev.getLink();
				prev.setLink(nptr);
				nptr.setLink(d);
			}
			temp = temp.getLink();
		}
	}

	public static void main(String[] args) {
		Singlylink obj = new Singlylink();
		Scanner s = new Scanner(System.in);
		obj.insertAtEnd(s.nextInt());
		obj.insertAtEnd(s.nextInt());
		obj.insertAtEnd(s.nextInt());
		obj.insertAtEnd(s.nextInt());
		obj.print();
		obj.sortedIntersect(2);
		obj.sortedIntersect(3);
		obj.print();
		
	}
}