package com.guyko

import junit.framework.TestCase

class TestCoinChange : TestCase() {

    fun testCoinChange() {
        assertEquals(2, coinChange(intArrayOf(1, 3, 4), 6))
        assertEquals(-1, coinChange(intArrayOf(2), 3))
        assertEquals(0, coinChange(intArrayOf(1), 0))
    }

    /**
     * LeetCode #322: Coin Change
     * https://leetcode.com/problems/coin-change/
     * 
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
}