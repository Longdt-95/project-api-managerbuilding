package javacoding;

public class Exercise15 {
	
	public static void result(int[] arr, int x) {
		int length = arr.length;
		int maxSum = Integer.MIN_VALUE;
		int index1 = -1;
		int index2 = -2;
		for (int i = 0; i < length; i++) {
			int flag = x - arr[i];
			for (int j = 0; j < length; j++) {
				int sum = arr[i] + arr[j];
				if (i != j && arr[j] < flag && maxSum < sum) {
					maxSum = sum;
						index1 = i;
						index2 = j;
				}
			}
		}
		System.out.println(arr[index1] + " " + arr[index2]);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-40,-5,1,3,20,7,8,6};
		int x = 10;
		Exercise15.result(arr, x);
	}
}
