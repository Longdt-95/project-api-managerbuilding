package javacoding;

public class Exercise14 {
	
	public static int[] filterSameNumber(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					arr[i] = arr[length - 1];
					length--;
					i--;
					break;
				}
			}
		}
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = arr[i];
		}
		return result;
	}

	public static int[] findNumAppearOdd(int[] arr) {
		int length = arr.length;
		int[] temp = new int[length];
		int index = 0;
		for (int i = 0; i < length ; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count % 2 != 0) {
				temp[index] = arr[i];
				index++;
			}
		}
		int[] result = Exercise14.filterSameNumber(temp);
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,2,2,5,2,2,2,2,2,2};
		int[] result = Exercise14.findNumAppearOdd(arr);
		for (int i = 0; i < result.length; i++) {
				System.out.println(result[i]);
		}		
	}
}
