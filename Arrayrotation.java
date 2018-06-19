import java.util.*;

class Arrayrotation {

	void leftrotate(int[] array,int d,int n) {
		for(int i = 0;i < d;i++)
			leftrotatebyone(array,n);
	}

	void leftrotatebyone(int[] array,int n) {
		int temp = array[0];
		for(int i = 0;i < n-1;i++){
			array[i] = array[i+1];
		}
		array[n-1] = temp;
	}
	void printArray(int[] array,int n) {
		for(int i = 0;i < n;i++)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	void rightroatate(int[] array,int d,int n){
		for(int i = 0;i < d;i++)
			rightroatatebyone(array,n);
	}

	void rightroatatebyone(int[] array,int n) {
		int temp = array[n-1];
		for(int i = n-1;i > 0;i--)
			array[i] = array[i-1];
		array[0] = temp;

	}
	void reverseArray(int[] array,int st,int ed) {
		int start = st;
		int end = ed;
		int temp;
		while(start < end) {
			temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

	void reversalalgo(int [] array,int d,int n) {
		reverseArray(array,0,d-1);
		reverseArray(array,d,n-1);
		reverseArray(array,0,n-1);
	}

	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n;i++)
			array[i] = s.nextInt();
		int d = s.nextInt();
		Arrayrotation obj = new Arrayrotation();
		obj.printArray(array,n);
		obj.reversalalgo(array,d,n);
		obj.printArray(array,n);
		
	}
}