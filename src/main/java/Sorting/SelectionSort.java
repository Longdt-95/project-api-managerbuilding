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
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i; j < n; j++) {
                if(arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                int temp = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,3,5,8};
        SelectionSort.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
