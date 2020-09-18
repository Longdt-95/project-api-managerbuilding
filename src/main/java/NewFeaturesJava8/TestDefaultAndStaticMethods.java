package NewFeaturesJava8;

public class TestDefaultAndStaticMethods {
	
	public static void main(String[] args) {
		DefaultAndStaticMethodExample.method3(" world");
		Example example = new Example();
		example.method2("world");
	}

}

class Example implements DefaultAndStaticMethodExample, DefaultAndStaticMethod1Example {

	@Override
	public String method1(String str) {
		return str;
	}

	// Nếu 1 class implements 2 hay nhiều interface có những phương thức default trùng tên thì class đó phải Override lại method default đó
	@Override
	public void method2(String str) {
		DefaultAndStaticMethod1Example.super.method2(str);
	}
	
	
//	@Override
//	public void method2(String str) {
//		System.out.println("hello1 " + str);
//	};
	
}
