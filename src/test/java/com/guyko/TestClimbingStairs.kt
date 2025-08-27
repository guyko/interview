package com.guyko

import junit.framework.TestCase

class TestClimbingStairs : TestCase() {

    fun testClimbStairs() {
        assertEquals(2, climbStairs(2))
        assertEquals(3, climbStairs(3))
        assertEquals(5, climbStairs(4))
        assertEquals(8, climbStairs(5))
    }

    fun testCoinChange() {
        assertEquals(2, coinChange(intArrayOf(1, 3, 4), 6))
        assertEquals(-1, coinChange(intArrayOf(2), 3))
        assertEquals(0, coinChange(intArrayOf(1), 0))
    }

    fun testLongestIncreasingSubsequence() {
        assertEquals(4, lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
        assertEquals(4, lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
        assertEquals(1, lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
    }

    /**
     * LeetCode #70: Climbing Stairs
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    private fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        
        var prev2 = 1 // ways to reach step 1
        var prev1 = 2 // ways to reach step 2
        
        for (i in 3..n) {
            val current = prev1 + prev2
            prev2 = prev1
            prev1 = current
        }
        
        return prev1
    }

    /**
     * LeetCode #322: Coin Change
     * You are given an integer array coins representing coins of different denominations
     * and an integer amount representing a total amount of money.
     * Return the fewest number of coins that you need to make up that amount.
     * 
     * Time Complexity: O(S * n) where S is the amount, n is denomination count
     * Space Complexity: O(S)
     */
    private fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { Int.MAX_VALUE }
        dp[0] = 0
        
        for (i in 1..amount) {
            for (coin in coins) {
                if (coin <= i && dp[i - coin] != Int.MAX_VALUE) {
                    dp[i] = minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }
        
        return if (dp[amount] == Int.MAX_VALUE) -1 else dp[amount]
    }

    /**
     * LeetCode #300: Longest Increasing Subsequence
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