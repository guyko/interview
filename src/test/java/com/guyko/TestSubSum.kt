package com.guyko

import junit.framework.TestCase

class TestSubSum : TestCase() {


    fun testIt() {
        assertEquals(16, maxsubsum(arrayOf(1, -2, 3, 4, 5, -2, 6).toIntArray()))
    }


    private fun maxsubsum(arr: IntArray): Int {
        var maxEndingHere = arr[0]
        var maxSoFar = arr[0]

        for (i in 1 until arr.size) {
            maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i])
            maxSoFar = Math.max(maxEndingHere, maxSoFar)
        }
        return maxSoFar
    }
}