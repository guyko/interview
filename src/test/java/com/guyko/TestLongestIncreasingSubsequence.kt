package com.guyko

import junit.framework.TestCase

class TestLongestIncreasingSubsequence : TestCase() {

    fun testLongestIncreasingSubsequence() {
        assertEquals(4, lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
        assertEquals(4, lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
        assertEquals(1, lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
    }

    /**
     * LeetCode #300: Longest Increasing Subsequence
     * https://leetcode.com/problems/longest-increasing-subsequence/
     * 
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(n)
     */
    private fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        
        val dp = IntArray(nums.size) { 1 }
        
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                if (nums[j] < nums[i]) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }
        
        return dp.maxOrNull() ?: 0
    }
}