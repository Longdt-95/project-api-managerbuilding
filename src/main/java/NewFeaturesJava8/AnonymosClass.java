package NewFeaturesJava8;

public class AnonymosClass {
	
	public static void main(String[] args) {
		
		// use anonymus Class
		DefaultAndStaticMethodExample test2 = new DefaultAndStaticMethodExample() {
			
			@Override
			public String method1(String str) {
				System.out.println("use anonymos Class");
				return str;
			}
		};
		
		test2.method1("abc");
		
		// use lambda expression 
		DefaultAndStaticMethodExample test1 = item -> {
			item += "world";
			System.out.println("use lambda expression");
			return item;
		};
		test1.method1("hello");
	}
}
