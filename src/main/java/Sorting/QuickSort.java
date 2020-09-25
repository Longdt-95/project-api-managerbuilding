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
public class QuickSort {
    int partition(int Array[], int left, int right) { 
        int pi = Array[right];  
        int i = (left-1); 
        for (int j=left; j<right; j++) { 
            if (Array[j] <= pi) { 
                i++; 
                int temp = Array[i]; 
                Array[i] = Array[j]; 
                Array[j] = temp; 
            } 
        } 
        int temp = Array[i+1]; 
        Array[i+1] = Array[right]; 
        Array[right] = temp; 
        return i+1; 
    } 
    
    void quick_sort(int Array[], int left, int right) { 
        if (left < right) { 
            int pi = partition(Array, left, right); 
            quick_sort(Array, left, pi-1); 
            quick_sort(Array, pi+1, right); 
        } 
    } 
    public static void main(String[] args) {
        int intArray[] = {4,-1,6,8,0,5,-3}; 
        int n = intArray.length; 
        System.out.println("Original Array: " + Arrays.toString(intArray));
        QuickSort obj = new QuickSort(); 
        obj.quick_sort(intArray, 0, n-1); 
        System.out.println("\nSorted Array: " + Arrays.toString(intArray)); 
    }
}
