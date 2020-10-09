package javacoding;

public class Exercise02 {
	public boolean isUnique(String str) {
		int length = str.length();
		
		for (int i = 0; i < length; i++) {
			int count = 0;
			for (int j = 0; j < length; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count == 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String str1 = "aabbcc";
		System.out.println(new Exercise02().isUnique(str1));
	}
}
