package com.guyko

import junit.framework.TestCase

class TestTwoSum : TestCase() {

    fun testTwoSum() {
        assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(2, 7, 11, 15), 9))
        assertArrayEquals(intArrayOf(1, 2), twoSum(intArrayOf(3, 2, 4), 6))
        assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(3, 3), 6))
    }

    /**
     * LeetCode #1: Two Sum
     * https://leetcode.com/problems/two-sum/
     * 
     * Given an array of integers nums and an integer target, return indices of the two numbers
     * such that they add up to target.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        
        throw IllegalArgumentException("No two sum solution")
    }

    private fun assertArrayEquals(expected: IntArray, actual: IntArray) {
        assertEquals("Arrays have different lengths", expected.size, actual.size)
        for (i in expected.indices) {
            assertEquals("Arrays differ at index $i", expected[i], actual[i])
        }
    }
}