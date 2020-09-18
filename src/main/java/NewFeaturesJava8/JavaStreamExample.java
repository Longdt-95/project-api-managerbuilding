package NewFeaturesJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamExample {

	/*
	 * 1. java Stream is a data structure that is computed on-demand. ( java Stream
	 * là một cấu trúc dữ liệu được tính toán theo yêu cầu )
	 *
	 * 2. Java Stream doesn’t store data, it operates on the source data structure
	 * (collection and array) and produce pipelined data - that we can use and
	 * perform specific operations. Such as we can create a stream from the list and
	 * filter it based on a condition ( Java Stream không lưu trữ dữ liệu, nó hoạt
	 * động trên cấu trúc dữ liệu nguồn ( Collection and array) và tạo ra dữ liệu
	 * tổng thể mà chúng tôi có thể sử dụng và thực hiện các hoạt động cụ thể. chẳng
	 * hạn như chúng ta có thể tạo một Stream from list và lọc nó dựa trên 1 điều
	 * kiện
	 *
	 * 3. Java 8 Stream support sequential as well as parallel processing, parallel
	 * processing can be very helpful in achieving high performance for large
	 * collections. ( Java Stream hỗ trợ tuần tự và song song. xử lí song song rất
	 * hữu ích đối với những collection lớn)
	 */

	/*
	 * the several ways create a java Stream from arrays or collection 1. use
	 * Stream.of() with similar type of data
	 */
	Stream<String> streamString = Stream.of("php", "java", "ruby");
	Stream<Integer> streamInterge = Stream.of(1, 2, 3, 4);
	/*
	 * 2. We can use Stream.of() with an array of Objects to return the
	 * stream.(chúng ta có thể khởi tạo stream với một đối tưởng của mảng) Note that
	 * it doesn’t support autoboxing, so we can’t pass primitive type array (lưu ý
	 * nó không tự động chuyển dổi kiểu dữ liệu.
	 */

	Stream<Integer> stream = Stream.of(new Integer[] { 1, 2, 3, 4 });
	// works fine

	// Compile time error, Type mismatch: cannot convert from Stream<int[]> to
	// Stream<Integer>
	// Stream<Integer> stream1 = Stream.of(new int[]{1,2,3,4});

	public static void main(String[] args) {
		// 3.We can use Collection stream() to create sequential stream and
		// parallelStream() to create parallel stream
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			myList.add(i);
		}

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// 4. use Stream.generate() and Stream.iterate() methods to create Stream
		Supplier<String> supplier = () -> "abc";
		// System.out.println(supplier.get());
		Stream<String> stream1 = Stream.generate(supplier);
		
		UnaryOperator<String> unaryOperator = UnaryOperator.identity();
		String str = unaryOperator.apply("abc");
		
		Stream<String> stream2 = Stream.iterate(str, unaryOperator);
		
		// 5. Using Arrays.stream() and String.chars() methods
		
		DoubleStream doubleStream = Arrays.stream(new double[] {1,2,3});
		IntStream intStream = "hello".chars();
		//convert from IntStream to Stream<Chacracter>
		Stream<Character> stream = intStream.mapToObj(item -> (char) item);
		
	}

}
