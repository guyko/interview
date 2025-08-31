package com.guyko

import junit.framework.TestCase

class TestInsertInterval : TestCase() {

    fun testInsertInterval() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(6, 9))
        val newInterval = intArrayOf(2, 5)
        val result = insert(intervals, newInterval)
        assertEquals(2, result.size)
        assertArrayEquals(intArrayOf(1, 5), result[0])
        assertArrayEquals(intArrayOf(6, 9), result[1])
    }

    /**
     * LeetCode #57: Insert Interval
     * https://leetcode.com/problems/insert-interval/
     * 
     * You are given an array of non-overlapping intervals and a new interval to insert.
     * Insert the new interval and merge if necessary.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        
        // Add all intervals that end before newInterval starts
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }
        
        // Merge overlapping intervals
        var start = newInterval[0]
        var end = newInterval[1]
        
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            start = minOf(start, intervals[i][0])
            end = maxOf(end, intervals[i][1])
            i++
        }
        
        result.add(intArrayOf(start, end))
        
        // Add remaining intervals
        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }
        
        return result.toTypedArray()
    }

    private fun assertArrayEquals(expected: IntArray, actual: IntArray) {
        assertEquals("Arrays have different lengths", expected.size, actual.size)
        for (i in expected.indices) {
            assertEquals("Arrays differ at index $i", expected[i], actual[i])
        }
    }
}