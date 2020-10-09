package javacoding;

public class Exercise11 {
	
	public int max(int[] arr) {
		int flag = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (flag < arr[i]) {
				flag = arr[i];
			}
		}
		return flag;
	}
	
	public int min(int[] arr) {
		int flag = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (flag > arr[i]) {
				flag = arr[i];
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1,4,3,7,5,9,4,7};
		System.out.println("max :" + new Exercise11().max(arr));
		System.out.println("min :" + new Exercise11().min(arr));
	}
}
