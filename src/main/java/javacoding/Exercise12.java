package javacoding;import java.util.Arrays;

public class Exercise12 {
	
	int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        {
            if (arr[j] < pivot) 
            { 
                i++;                
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
  
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
	
	public int numberMiss(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i -1] + 1) {
				return arr[i - 1] + 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {-1,1,2,3};
		Exercise12 exercise12 = new Exercise12();
		exercise12.sort(arr, 0, arr.length -1);;
		System.out.println(Arrays.toString(arr));
		System.out.println(exercise12.numberMiss(arr));
	}
}
