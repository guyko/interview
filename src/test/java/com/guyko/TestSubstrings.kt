package com.guyko

import junit.framework.TestCase

class TestSubstrings : TestCase() {

    fun testIt() {
        println(permutations(mutableListOf("go", "west", "life"), 0))

        println(findSubstring("afargobgofar", listOf("far", "go")))
    }


    fun findSubstring(s: String, words: List<String>): List<Int> {
        val permutations = permutations(words.toMutableList(), 0)

        val totalLength = permutations[0].length
        var tmp = s
        var offset = 0
        val substrings = mutableListOf<Int>()
        while (tmp.length >= totalLength) {
            val idx = minIndex(tmp, permutations)
            if (idx < 0) {
                break
            }

            substrings.add(offset + idx)
            offset += (idx + totalLength)
            tmp = tmp.substring(idx + totalLength)

        }

        return substrings
    }

    private fun minIndex(tmp: String, permutations: List<String>): Int {
        var minNonZeroIdx = -1
        for (p in permutations) {
            val idx = tmp.indexOf(p)
            if (idx < 0) {
                continue
            }
            if (idx == 0) {
                return idx
            }
            if (minNonZeroIdx == -1 || idx < minNonZeroIdx) {
                minNonZeroIdx = idx
            }
        }
        return minNonZeroIdx
    }


    fun permutations(words: MutableList<String>, i: Int): List<String> {
        if (i == words.size) {
            return listOf(words.joinToString(""))
        }

        val permutations = mutableListOf<String>()
        for (j in i until words.size) {
            val temp = words[i]
            words[i] = words[j]
            words[j] = temp

            permutations.addAll(permutations(words, i + 1))
        }

        return permutations

    }
}

