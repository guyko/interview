package com.guyko

import junit.framework.TestCase
import java.util.*

class TestLinked : TestCase() {


    fun testReverse() {
        val list = LinkedNode(1, LinkedNode(2, LinkedNode(3, LinkedNode(4, LinkedNode(5)))))
        println(list)
        println(reverse(list, 12))
    }


    private fun reverse(node: LinkedNode, k: Int): LinkedNode {
        return reverse(node, k, 0, arrayOfNulls(k))!!
    }

    private fun reverse(node: LinkedNode?, k: Int, i: Int, buffer: Array<LinkedNode?>): LinkedNode? {
        if (node == null) {
            return buffer[0]
        }
        val next = node.next

        buffer[i] = node
        if (i + 1 == k) {
            buffer[0]!!.next = reverse(next, k, 0, arrayOfNulls(k))

            (0 until k - 1).forEach {
                val i = k - it - 1
                val item = buffer[i - 1]
                val item2 = buffer[i]
                if (item2 != null) {
                    item2.next = item
                }
            }
            return buffer[k - 1]
        }

        return reverse(next, k, i + 1, buffer)

    }

    private fun reverse(node: LinkedNode): LinkedNode {

        var prev: LinkedNode? = null
        var current: LinkedNode? = node
        var next: LinkedNode?
        while (current != null) {
            next = current.next

            current.next = prev

            prev = current
            current = next
        }
        return prev!!

    }


    private data class LinkedNode(val n: Int, var next: LinkedNode? = null)
}