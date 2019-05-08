package com.guyko

import junit.framework.TestCase

class TestKakuro : TestCase() {

    fun testIt() {
        assertEquals(listOf(listOf(1, 5), listOf(2, 4)), kakuro(6, 2, 6))
        assertEquals(listOf(listOf(1, 3, 6), listOf(1, 4, 5), listOf(2, 3, 5)), kakuro(10, 3, 6))
    }


    private fun kakuro(s: Int, n: Int, p: Int): List<List<Int>> {
        if (s <= 0) {
            return emptyList()
        }
        if (p == 0) {
            return emptyList()
        }
        if (n == 1) {
            return if (s <= p) {
                listOf(listOf(s))
            } else {
                emptyList()
            }
        }


        val withP = kakuro(s - p, n - 1, p - 1).map { it + p }
        val withoutP = kakuro(s, n, p - 1)
        return withP + withoutP
    }
}