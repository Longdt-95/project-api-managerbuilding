/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    j--;
            }
            arr[j + 1] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,6,8,4,2};
        InsertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
