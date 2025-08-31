package com.guyko

import junit.framework.TestCase

class TestSearchRotatedArray : TestCase() {

    fun testSearchRotatedArray() {
        assertEquals(4, searchRotated(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        assertEquals(-1, searchRotated(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
        assertEquals(-1, searchRotated(intArrayOf(1), 0))
    }

    /**
     * LeetCode #33: Search in Rotated Sorted Array
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * 
     * There is an integer array nums sorted in ascending order (with distinct values).
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private fun searchRotated(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] == target) return mid
            
            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            }
        }
        
        return -1
    }
}