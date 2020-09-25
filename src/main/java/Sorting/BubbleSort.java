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
public class BubbleSort {

    public static void BubbleSort(int[] arr) {
        int temp = 0;
        boolean swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }
    }
    
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "-");
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,5,8,4,3,9};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
