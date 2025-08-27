package com.guyko

import junit.framework.TestCase

class TestBinarySearch : TestCase() {

    fun testBinarySearch() {
        assertEquals(4, search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        assertEquals(-1, search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
        assertEquals(0, search(intArrayOf(5), 5))
    }

    fun testSearchRotatedArray() {
        assertEquals(4, searchRotated(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
        assertEquals(-1, searchRotated(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
        assertEquals(-1, searchRotated(intArrayOf(1), 0))
    }

    fun testFindMin() {
        assertEquals(1, findMin(intArrayOf(3, 4, 5, 1, 2)))
        assertEquals(0, findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
        assertEquals(11, findMin(intArrayOf(11, 13, 15, 17)))
    }

    /**
     * LeetCode #704: Binary Search
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

    /**
     * LeetCode #33: Search in Rotated Sorted Array
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

    /**
     * LeetCode #153: Find Minimum in Rotated Sorted Array
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