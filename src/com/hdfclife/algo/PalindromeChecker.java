package com.hdfclife.algo;

public class PalindromeChecker {

    public static boolean isPalindrome(int number) {

        if (number < 0) {
            return false;
        }

        if (number == 0) {
            return true;
        }

        int temp = number;
        int digits = 0;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        int[] digitArray = new int[digits];

        temp = number;

        for (int i = digits - 1; i >= 0; i--) {
            digitArray[i] = temp % 10;
            temp /= 10;
        }

        int left = 0;
        int right = digitArray.length - 1;

        while (left < right) {

            if (digitArray[left] != digitArray[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}