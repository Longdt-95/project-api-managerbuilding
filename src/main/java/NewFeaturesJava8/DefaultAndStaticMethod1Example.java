package NewFeaturesJava8;

public interface DefaultAndStaticMethod1Example {
	String method1(String str);
	default void method2(String str) {
		System.out.println("hello " + str);
	};
	static void method3(String str) {
		System.out.println("hello " + str);
	};
}
