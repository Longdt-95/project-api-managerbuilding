package javacoding;

public class Exercise01 {
	
	public static String reverse(String str) {
		char[] result = new char[str.length()];
		for (int i = str.length() - 1, j = 0; i >= 0; i--) {
			result[j] = str.charAt(i);
			j++;
		}
		return String.copyValueOf(result);
	}
	
	public static void main(String[] args) {
		String str = "1231412";
		System.out.println(Exercise01.reverse(str));
	}

}
