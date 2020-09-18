package NewFeaturesJava8;


class MethodReferenceExample1 {
	void saySomeThing() {
		System.out.println("hello java");
	}
}

class SayHello {
	void print(String string) {
		System.out.println(string);
	}
}

public class MethodReferenceExample {
	
	static void saySomeThing() {
		System.out.println("hello world");
	}
	
	public static void main(String[] args) {
		
		// there are three types of method references in java
		//1. Reference to a static method.
		// use lambda expression 
		InterfaceDemoReferenceMethod test = () -> MethodReferenceExample.saySomeThing();;
		// use Reference to a static method.
		InterfaceDemoReferenceMethod test1 = MethodReferenceExample::saySomeThing;
		test.say();
		System.out.println("-----");
		test1.say();
		
		//2. Reference to an instance method.
		// use lambda expression
		MethodReferenceExample1 method = new MethodReferenceExample1();
		InterfaceDemoReferenceMethod test3 = () -> method.saySomeThing(); 
		// use Reference to an instance method.
		InterfaceDemoReferenceMethod test4 = method::saySomeThing;
		
		
		System.out.println("*************************");
		//3. Reference to a Constructor
		// use lambda expression 
		Demo demo = () -> new SayHello();
		demo.getSayHello().print("hello");
		// use Reference to a Constructor
		Demo demo1 = SayHello::new;
		demo1.getSayHello().print("hello Java");
		
	}
}
