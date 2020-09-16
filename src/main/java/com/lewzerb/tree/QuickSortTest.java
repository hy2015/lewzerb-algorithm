package com.lewzerb.tree;

public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
        for(int a : arr){
            System.out.print(a + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low > high) return;
        int benchmark = arr[low];
        int temp;

        int i = low, j = high;
        while(i < j){
            while (i < j && arr[j] >= benchmark) j--;
            while (i < j && arr[i] <= benchmark) i++;

            if(i < j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[i];
        arr[i] = benchmark;

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }
}
