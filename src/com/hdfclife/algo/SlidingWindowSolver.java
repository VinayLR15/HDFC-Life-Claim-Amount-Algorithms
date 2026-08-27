package com.hdfclife.algo;

import com.hdfclife.exception.InvalidWindowException;

public class SlidingWindowSolver {

    public static int maxSumOfSizeK(int[] arr, int k) {

        if (k <= 0 || k > arr.length) {
            throw new InvalidWindowException(
                    "Invalid window size: " + k
            );
        }

        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }

        int maxSum = currentSum;

        for (int right = k; right < arr.length; right++) {

            currentSum += arr[right];
            currentSum -= arr[right - k];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}