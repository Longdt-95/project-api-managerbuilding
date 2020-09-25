/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Search;

/**
 *
 * @author Admin
 */
public class BinarySearch {

    /*
        Binary Search sử dụng cho mảng đã sắp xếp
     */
    public static int binarySearch(int arr[], int left, int right,int x) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, left, mid - 1, x);//search in left subarray  
            } else {
                return binarySearch(arr, mid + 1, right, x);//search in right subarray  
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,5,8,9};
        int right = arr.length - 1;
        int x = 3;
        System.out.println(binarySearch(arr, 0, right, x));
    }
}
