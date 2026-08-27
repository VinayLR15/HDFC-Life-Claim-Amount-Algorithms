package com.hdfclife.algo;

import com.hdfclife.exception.PairNotFoundException;

import java.util.Arrays;

public class PairSumSolver {

    public static int[] bruteForce(int[] arr, int target) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {

                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);

                    return new int[]{first, second};
                }
            }
        }

        throw new PairNotFoundException(
                "No pair found for target: " + target
        );
    }

    public static int[] twoPointer(int[] arr, int target) {

        int[] sorted = Arrays.copyOf(arr, arr.length);

        Arrays.sort(sorted);

        int left = 0;
        int right = sorted.length - 1;

        while (left < right) {

            int sum = sorted[left] + sorted[right];

            if (sum == target) {
                return new int[]{
                        sorted[left],
                        sorted[right]
                };
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        throw new PairNotFoundException(
                "No pair found for target: " + target
        );
    }
}