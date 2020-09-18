package ExerciseLambdaAndStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortArrayString {

	public static void main(String[] args) {
		
		String[] arrString = new String[] {"java", "php", "C#", "ruby", "e"};
		// sort asc by length of element in array
		Comparator<String> comparator = (a,b) ->  a.length() - b.length(); 
		ArrayList<String> arrStringSortByLength = (ArrayList<String>) Arrays.stream(arrString).sorted(comparator).collect(Collectors.toList());
		System.out.println(arrStringSortByLength.toString());
		
		Arrays.sort(arrString, (a,b) -> a.length() - b.length());
		// sort desc by length of element in array
		ArrayList<String> arrStringSortByLength1 = (ArrayList<String>) Arrays.stream(arrString)
							.sorted((a,b) -> b.length() - a.length()).collect(Collectors.toList());
		System.out.println(arrStringSortByLength1.toString());
		
		// sort by alphabetically by the first character only
		Arrays.sort(arrString, (a,b) -> sortCharat(a,b));
		System.out.println(Arrays.toString(arrString));
	}

	private static int sortCharat(String a, String b) {
		int a1 = a.charAt(0);
		int b1 = b.charAt(0);
 		return a1-b1;
	}
}
