package com.hdfclife.algo;

import java.util.HashMap;
import java.util.Map;

public class UniqueSubstringSolver {

    /*
     * Time Complexity: O(n)
     * Extra Space: O(n)
     */
    public static int longestUniqueSubstring(String value) {

        Map<Character, Integer> lastSeen = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < value.length(); end++) {

            char current = value.charAt(end);

            if (lastSeen.containsKey(current)
                    && lastSeen.get(current) >= start) {

                start = lastSeen.get(current) + 1;
            }

            lastSeen.put(current, end);

            int currentLength = end - start + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        return maxLength;
    }
}