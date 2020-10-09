package javacoding;

public class Exercise09 {
	public int sum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += (x % 10);
			x = x / 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int x = 3425623;
		System.out.println(new Exercise09().sum(x));
	}
}
