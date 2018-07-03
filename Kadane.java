import java.util.*;

class Kadane {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcases = s.nextInt();
		for(int j = 0;j < testcases;j++) {
			int n = s.nextInt();
			int[] array = new int[n];	
		for(int i = 0;i<n;i++)
			array[i] = s.nextInt();
		System.out.println(method2(array));
		}
	}

	static int method1(int[] array) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for(int i = 0;i < array.length;i++) {
			cur = cur + array[i];
			if(cur < 0)
				cur =0;
			else if(cur > max) {
				max = cur;
			}
		}
		return max;
	}

	static int method2(int[] array) {
		int cur = array[0];
		int max = array[0];
		for(int i = 1;i<array.length;i++) {
			cur = Math.max(array[i],cur+array[i]);
			max = Math.max(max,cur);
		}
		return max;
	}
}