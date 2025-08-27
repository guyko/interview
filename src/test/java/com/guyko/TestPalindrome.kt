package com.guyko

import junit.framework.TestCase

class TestPalindrome : TestCase() {

    fun testIsPalindrome() {
        assertTrue(isPalindrome(121))
        assertFalse(isPalindrome(-121))
        assertFalse(isPalindrome(10))
        assertTrue(isPalindrome(0))
        assertTrue(isPalindrome(1))
    }

    fun testLongestPalindrome() {
        assertEquals("bab", longestPalindrome("babad"))
        assertEquals("bb", longestPalindrome("cbbd"))
        assertEquals("a", longestPalindrome("ac"))
        assertEquals("", longestPalindrome(""))
    }

    /**
     * LeetCode #9: Palindrome Number
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

    /**
     * LeetCode #5: Longest Palindromic Substring
     * Given a string s, return the longest palindromic substring in s.
     * 
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    private fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        
        var start = 0
        var maxLen = 1
        
        for (i in s.indices) {
            // Check for odd length palindromes
            val len1 = expandAroundCenter(s, i, i)
            // Check for even length palindromes
            val len2 = expandAroundCenter(s, i, i + 1)
            val len = maxOf(len1, len2)
            
            if (len > maxLen) {
                maxLen = len
                start = i - (len - 1) / 2
            }
        }
        
        return s.substring(start, start + maxLen)
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var l = left
        var r = right
        
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }
        
        return r - l - 1
    }
}