package javacoding;

import java.util.Arrays;

public class Exercise13 {

	public static int secondMax (int[] arr) {
		int length = arr.length;
		if (length <= 1) {
			return 0;
		} else if (length == 2) {
			return Math.min(arr[0], arr[1]);
		}else {
			int max = Integer.MIN_VALUE;
			int secondMax = Integer.MIN_VALUE;
			int index = 0;
			for (int i = 0; i < length; i++) {
				if (max < arr[i]) {
					max = arr[i];
					index = i;
				}
			}
			arr[index] = Integer.MIN_VALUE;
			for (int i = 0; i < length; i++) {
				if (secondMax < arr[i]) {
					secondMax = arr[i];
				}
			}
			return secondMax;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,67,4,8};
		System.out.println(Exercise13.secondMax(arr));
	}
}
