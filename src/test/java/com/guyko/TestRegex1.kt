package com.guyko

import junit.framework.TestCase

class TestRegex1 : TestCase() {

    fun testIt() {
        assertFalse(match("aa", "a"))
        assertTrue(match("aa", "aa"))
        assertFalse(match("aaa", "aa"))
        assertTrue(match("aa", "a*"))
        assertTrue(match("aa", ".*"))
        assertTrue(match("ab", ".*"))
        assertTrue(match("aab", "c*a*b"))
    }


    private fun match(s: String, p: String): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        }

        if (p.length == 1 || p[1] != '*') {
            if (s.isEmpty()) {
                return false
            }
            if (s[0] != p[0] && p[0] != '.') {
                return false
            }
            return match(s.substring(1), p.substring(1))
        }

        if (match(s, p.substring(2))) {
            return true
        }

        for (i in 0 until s.length) {
            if (s[i] != p[0] && p[0] != '.') {
                break
            }
            if (match(s.substring(i + 1), p.substring(2))) {
                return true
            }
        }
        return false
    }
}