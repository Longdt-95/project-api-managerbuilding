package javacoding;

import java.util.Arrays;

public class Exercise14 {
	
	public static int[] filterSameNumber(int[] arr) {
		int length = arr.length;
		int[] result = new int[length];
		int index = 1;
		result[0] = arr[0];
		for (int i = 1; i < length; i++) {
			boolean flag = false;
			for (int j = 0; j < length; j++) {
				if (arr[i] == result[j]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				result[index] = arr[i];
				index++;
			}
		}
		return result;
	}

	public static int[] findNumAppearOdd(int[] arr) {
		int length = arr.length;
		int[] result = new int[length];
		int index = 0;
		int[] kq = Exercise14.filterSameNumber(arr);
		System.out.println(Arrays.toString(kq));
		for (int i = 0; i < kq.length ; i++) {
			int count = 0;
			for (int j = 0; j < length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count % 2 != 0) {
				result[index] = arr[i];
				index++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,2,4,4,4};
		int[] result = Exercise14.findNumAppearOdd(arr);
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) {
				System.out.println(result[i]);
			}
		}
		
		
	}
}
