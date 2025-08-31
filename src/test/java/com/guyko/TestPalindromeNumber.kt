package com.guyko

import junit.framework.TestCase

class TestPalindromeNumber : TestCase() {

    fun testIsPalindrome() {
        assertTrue(isPalindrome(121))
        assertFalse(isPalindrome(-121))
        assertFalse(isPalindrome(10))
        assertTrue(isPalindrome(0))
        assertTrue(isPalindrome(1))
    }

    /**
     * LeetCode #9: Palindrome Number
     * https://leetcode.com/problems/palindrome-number/
     * 
     * Given an integer x, return true if x is palindrome integer.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        
        var original = x
        var reversed = 0
        
        while (original > 0) {
            reversed = reversed * 10 + original % 10
            original /= 10
        }
        
        return x == reversed
    }
}