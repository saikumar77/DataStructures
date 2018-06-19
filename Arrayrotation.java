import java.util.*;

class Arrayrotation {
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n;i++)
			array[i] = s.nextInt();
		int d = s.nextInt();
		Arrayrotation obj = new Arrayrotation();
		obj.leftrotate(array,d,n);
	}

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
	}
}