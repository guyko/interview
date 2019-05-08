package com.guyko

import junit.framework.TestCase

class TestYearWithMaxPeople : TestCase() {


    fun testIt() {
        val list = listOf(1800 to 1880, 1870 to 1885, 1875 to 1884, 1887 to 1888)
        println(findMax(list))
    }

    fun findMax(dates: List<Pair<Int, Int>>): Int {
        val map = mutableMapOf<Int, Int>()
        dates.forEach {
            map[it.first] = (map[it.first] ?: 0) + 1
            map[it.second] = (map[it.second] ?: 0) - 1
        }

        // sot sure it's smart to sort. there is a goog chance that nlogn > years range
        val years = map.keys.sorted()
        var max = 0
        var current = 0
        var maxY = 0
        years.forEach {
            current += map[it]!!
            if (max < current) {
                max = current
                maxY = it
            }
        }
        return maxY
    }
}