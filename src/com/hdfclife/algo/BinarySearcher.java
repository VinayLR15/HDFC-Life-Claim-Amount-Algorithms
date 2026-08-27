package com.hdfclife.algo;

public class BinarySearcher {

    /*
     * Time Complexity: O(log n)
     * Extra Space: O(log n) because of the recursive call stack.
     */
    public static boolean search(int[] arr, int target) {

        return searchRecursive(
                arr,
                target,
                0,
                arr.length - 1
        );
    }

    private static boolean searchRecursive(
            int[] arr,
            int target,
            int left,
            int right) {

        if (left > right) {
            return false;
        }

        int middle = left + (right - left) / 2;

        if (arr[middle] == target) {
            return true;
        }

        if (target < arr[middle]) {
            return searchRecursive(
                    arr,
                    target,
                    left,
                    middle - 1
            );
        }

        return searchRecursive(
                arr,
                target,
                middle + 1,
                right
        );
    }
}