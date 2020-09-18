package NewFeaturesJava8;


/* Functional interfaces are new concept introduced in Java 8. An interface with exactly one abstract method becomes Functional Interface.
 * a functional interface may still have multiple default methods
 * */

/*Java 8 has defined a lot of functional interfaces in java.util.function package.
 *  Some of the useful java 8 functional interfaces are Consumer, Supplier, Function and Predicate.
 * */
@FunctionalInterface
public interface FuntionalInterfaceExample {
	
	void display(String str);
	default void showMessenge(String str) {
		
	}
	static void showMessenger2(String str2) {
		
	}
}
