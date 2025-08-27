package com.guyko

import junit.framework.TestCase

class TestMergeIntervals : TestCase() {

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

    fun testInsertInterval() {
        val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(6, 9))
        val newInterval = intArrayOf(2, 5)
        val result = insert(intervals, newInterval)
        assertEquals(2, result.size)
        assertArrayEquals(intArrayOf(1, 5), result[0])
        assertArrayEquals(intArrayOf(6, 9), result[1])
    }

    /**
     * LeetCode #56: Merge Intervals
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

    /**
     * LeetCode #57: Insert Interval
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