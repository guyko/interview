package com.guyko

import junit.framework.TestCase

class TestMergeIntervalsBasic : TestCase() {

    fun testMergeIntervals() {
        val intervals1 = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        val result1 = merge(intervals1)
        assertEquals(3, result1.size)
        assertArrayEquals(intArrayOf(1, 6), result1[0])
        assertArrayEquals(intArrayOf(8, 10), result1[1])
        assertArrayEquals(intArrayOf(15, 18), result1[2])

        val intervals2 = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
        val result2 = merge(intervals2)
        assertEquals(1, result2.size)
        assertArrayEquals(intArrayOf(1, 5), result2[0])
    }

    /**
     * LeetCode #56: Merge Intervals
     * https://leetcode.com/problems/merge-intervals/
     * 
     * Given an array of intervals where intervals[i] = [starti, endi], 
     * merge all overlapping intervals.
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    private fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()
        
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        var current = intervals[0]
        
        for (i in 1 until intervals.size) {
            val next = intervals[i]
            
            if (current[1] >= next[0]) {
                // Overlapping intervals, merge them
                current[1] = maxOf(current[1], next[1])
            } else {
                // Non-overlapping interval
                result.add(current)
                current = next
            }
        }
        
        result.add(current)
        return result.toTypedArray()
    }

    private fun assertArrayEquals(expected: IntArray, actual: IntArray) {
        assertEquals("Arrays have different lengths", expected.size, actual.size)
        for (i in expected.indices) {
            assertEquals("Arrays differ at index $i", expected[i], actual[i])
        }
    }
}