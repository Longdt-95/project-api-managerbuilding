package javacoding;

public class Exercise04 {

	public void searchAndCount(String str) {
		char[] chars = str.toCharArray(); 
		char flag = ' ';
		for (char c : chars) {
			int count = 0;
			for (char d : chars) {
				if (c == d && c != ' ') {
					count++;
					flag = d;
				}
			}
			if (count >= 2) {
				System.out.println("kí tự " + c + " lặp :" + (count - 1));
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "do thanh long";
		new Exercise04().searchAndCount(str);
	}
}
