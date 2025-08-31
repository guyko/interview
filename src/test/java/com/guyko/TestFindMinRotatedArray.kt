package com.guyko

import junit.framework.TestCase

class TestFindMinRotatedArray : TestCase() {

    fun testFindMin() {
        assertEquals(1, findMin(intArrayOf(3, 4, 5, 1, 2)))
        assertEquals(0, findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
        assertEquals(11, findMin(intArrayOf(11, 13, 15, 17)))
    }

    /**
     * LeetCode #153: Find Minimum in Rotated Sorted Array
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * 
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
     * Find the minimum element.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    private fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        
        while (left < right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        
        return nums[left]
    }
}