package com.guyko

import junit.framework.TestCase

class TestClimbingStairsBasic : TestCase() {

    fun testClimbStairs() {
        assertEquals(2, climbStairs(2))
        assertEquals(3, climbStairs(3))
        assertEquals(5, climbStairs(4))
        assertEquals(8, climbStairs(5))
    }

    /**
     * LeetCode #70: Climbing Stairs
     * https://leetcode.com/problems/climbing-stairs/
     * 
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
}