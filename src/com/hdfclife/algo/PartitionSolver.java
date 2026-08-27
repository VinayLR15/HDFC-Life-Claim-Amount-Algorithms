package com.hdfclife.algo;

public class PartitionSolver {

    /*
     * Time Complexity: O(n)
     * Extra Space: O(1) besides the copy of the input array.
     */
    public static int[] partition(int[] arr, int pivot) {

        int[] result = arr.clone();

        int left = 0;
        int right = result.length - 1;

        while (left <= right) {

            while (left <= right && result[left] <= pivot) {
                left++;
            }

            while (left <= right && result[right] > pivot) {
                right--;
            }

            if (left < right) {

                int temp = result[left];
                result[left] = result[right];
                result[right] = temp;

                left++;
                right--;
            }
        }

        return result;
    }
}