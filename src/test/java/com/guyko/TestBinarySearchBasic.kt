package com.guyko

import junit.framework.TestCase

class TestBinarySearchBasic : TestCase() {

    fun testBinarySearch() {
        assertEquals(4, search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        assertEquals(-1, search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
        assertEquals(0, search(intArrayOf(5), 5))
    }

    /**
     * LeetCode #704: Binary Search
     * https://leetcode.com/problems/binary-search/
     * 
     * Given an array of integers nums which is sorted in ascending order, and an integer target,
     * write a function to search target in nums. If target exists, then return its index.
     * Otherwise, return -1.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        
        return -1
    }
}