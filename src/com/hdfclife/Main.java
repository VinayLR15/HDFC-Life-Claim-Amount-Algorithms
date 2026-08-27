package com.hdfclife;

import com.hdfclife.algo.BinarySearcher;
import com.hdfclife.algo.PairSumSolver;
import com.hdfclife.algo.PalindromeChecker;
import com.hdfclife.algo.PartitionSolver;
import com.hdfclife.algo.SlidingWindowSolver;
import com.hdfclife.algo.UniqueSubstringSolver;
import com.hdfclife.exception.InvalidIndexException;
import com.hdfclife.exception.PairNotFoundException;
import com.hdfclife.store.ClaimAmountStore;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ClaimAmountStore store = createSeedStore();

        int[] seed = store.toArray();

        System.out.println("==============================================");
        System.out.println("       HDFC LIFE CLAIM AMOUNT ALGORITHMS");
        System.out.println("==============================================");

        System.out.println("\n1. Seed Array");
        System.out.println("------------------------------");
        System.out.println(format(seed));

        System.out.println("\n2. Array Insert");
        System.out.println("------------------------------");
        store.insert(2, 22000);
        System.out.println(format(store.toArray()));

        System.out.println("\n3. Elements Shifted");
        System.out.println("------------------------------");
        System.out.println(store.getLastShiftCount());

        System.out.println("\n4. Array Delete");
        System.out.println("------------------------------");
        store.delete(2);
        System.out.println(format(store.toArray()));

        System.out.println("\n5. Pair Sum - Brute Force");
        System.out.println("------------------------------");
        int[] bruteForcePair = PairSumSolver.bruteForce(seed, 57000);
        System.out.println(bruteForcePair[0] + " + " + bruteForcePair[1]);

        System.out.println("\n6. Pair Sum - Two Pointer");
        System.out.println("------------------------------");
        int[] twoPointerPair = PairSumSolver.twoPointer(seed, 57000);
        System.out.println(twoPointerPair[0] + " + " + twoPointerPair[1]);

        System.out.println("\n7. Palindrome - 12321");
        System.out.println("------------------------------");
        System.out.println(PalindromeChecker.isPalindrome(12321));

        System.out.println("\n8. Palindrome - 18500");
        System.out.println("------------------------------");
        System.out.println(PalindromeChecker.isPalindrome(18500));

        System.out.println("\n9. Partition Around Pivot 20000");
        System.out.println("------------------------------");
        int[] partitioned = PartitionSolver.partition(seed, 20000);
        System.out.println(format(partitioned));

        System.out.println("\n10. Sliding Window Maximum Sum");
        System.out.println("------------------------------");
        int maxSum = SlidingWindowSolver.maxSumOfSizeK(seed, 3);
        System.out.println(maxSum);

        System.out.println("\n11. Longest Unique Substring");
        System.out.println("------------------------------");
        int longestUnique =
                UniqueSubstringSolver.longestUniqueSubstring("TERMULIPTERM");
        System.out.println(longestUnique);

        System.out.println("\n12. Binary Search - 15000");
        System.out.println("------------------------------");
        int[] sortedSeed = Arrays.copyOf(seed, seed.length);
        Arrays.sort(sortedSeed);

        System.out.println(
                BinarySearcher.search(sortedSeed, 15000)
                        ? "found"
                        : "not found"
        );

        System.out.println("\n13. Binary Search - 999");
        System.out.println("------------------------------");
        System.out.println(
                BinarySearcher.search(sortedSeed, 999)
                        ? "found"
                        : "not found"
        );

        System.out.println("\n14. Invalid Insert Index");
        System.out.println("------------------------------");
        try {
            store.insert(99, 1);
        } catch (InvalidIndexException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n15. Pair Sum - Target 1");
        System.out.println("------------------------------");
        try {
            PairSumSolver.bruteForce(seed, 1);
        } catch (PairNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n==============================================");
        System.out.println("             EXECUTION COMPLETED");
        System.out.println("==============================================");
    }

    private static ClaimAmountStore createSeedStore() {

        ClaimAmountStore store = new ClaimAmountStore();

        store.add(25000);
        store.add(18000);
        store.add(42000);
        store.add(15000);
        store.add(31000);
        store.add(9000);

        return store;
    }

    private static String format(int[] values) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            if (i > 0) {
                result.append(", ");
            }

            result.append(values[i]);
        }

        return result.toString();
    }
}