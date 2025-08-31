package com.guyko

import junit.framework.TestCase
import java.util.*

class TestValidParentheses : TestCase() {

    fun testValidParentheses() {
        assertTrue(isValid("()"))
        assertTrue(isValid("()[]{}"))
        assertFalse(isValid("(]"))
        assertTrue(isValid("{[]}"))
        assertFalse(isValid("([)]"))
        assertTrue(isValid(""))
    }

    /**
     * LeetCode #20: Valid Parentheses
     * https://leetcode.com/problems/valid-parentheses/
     * 
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
     * determine if the input string is valid.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val pairs = mapOf(')' to '(', '}' to '{', ']' to '[')
        
        for (char in s) {
            when (char) {
                '(', '{', '[' -> stack.push(char)
                ')', '}', ']' -> {
                    if (stack.isEmpty() || stack.pop() != pairs[char]) {
                        return false
                    }
                }
            }
        }
        
        return stack.isEmpty()
    }
}