package javacoding;

public class Exercise05 {
	
	public char FirstCharNotLoopInString(String str) {
		int length = str.length();
		for (int i = 0; i < length; i++) {
			int count = 0;
			for (int j = 0; j < length; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
			if (count == 1 && str.charAt(i) != ' ') {
				return str.charAt(i);
			}
		}
		return 0;
	}
	
	public static void main(String args[]) {
		String str ="12312354231";
		System.out.println(new Exercise05().FirstCharNotLoopInString(str));
	}

}
