package com.guyko

import junit.framework.TestCase

class TestLinked : TestCase() {


    fun testReverse() {
        val list = LinkedNode(1, LinkedNode(2, LinkedNode(3, LinkedNode(4, LinkedNode(5)))))
        println(list)
        println(reverse(list, list, 0, 2))
        //println(reverse(list, 12))
    }


    private fun reverse(parent: LinkedNode?,
                        node: LinkedNode?): LinkedNode? {
        if (node == null) {
            return parent
        }
        val next = node.next
        node.next = parent
        return reverse(node, next)
    }


    private fun reverse(head: LinkedNode?,
                        node: LinkedNode?,
                        i: Int,
                        k: Int): LinkedNode? {
        if (node == null || head == null) {
            return head
        }
        val next = node.next
        return if (i + 1 == k) {
            node.next = null
            val sub = reverse(null, head)
            head.next = reverse(next, next, 0, k)
            sub
        } else {
            reverse(head, next, i + 1, k)
        }
    }

    private data class LinkedNode(val n: Int,
                                  var next: LinkedNode? = null)
}