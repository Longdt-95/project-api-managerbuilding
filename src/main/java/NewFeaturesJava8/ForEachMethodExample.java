package NewFeaturesJava8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ForEachMethodExample {
	
	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("java");
		str.add("php");
		str.add("ruby");
		
		/* loop List use Iterator
		 * */
		Iterator<String> it = str.iterator();
		while(it.hasNext()) {
			System.out.println("this is language " + it.next());
		}
		
		System.out.println("----------------------");
		/* loop List use ForEach method in java 8 + lambda Expression
		 * */
		str.forEach(item -> doget(item));
		System.out.println("----------------------");
		// traversing through forEach method of Iterable with anonymous class
		  
		str.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("this is language " + t);
			}
			
		});
		System.out.println("----------------------");
		// traversing with Consumer interface implementation
		MyConsumer action = new MyConsumer();
		str.forEach(action);
	}

	private static String doget(String item) {
		System.out.println(item);
		return item;
	}
}

class MyConsumer implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println("this is language " + t);
		
	}
	
}
