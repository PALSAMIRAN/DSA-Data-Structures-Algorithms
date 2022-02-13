package com.inclass;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {7, 9 ,1, 3, 5, 2, 4};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort (int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge (int[] left, int[] right) {
        int[] mix = new int[left.length + right.length];

        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mix[i + j] = left[i];
                i++;
            } else {
                mix[i + j] = right[j];
                j++;
            }
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < left.length) {
            mix[i + j] = left[i];
            i++;
        }

        while (j < right.length) {
            mix[i + j] = right[j];
            j++;
        }

        return mix;
    }
}