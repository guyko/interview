package com.guyko

import junit.framework.TestCase

class TestTree : TestCase() {

    fun testReversed() {
        val tree = Node(value = 5,
                left = Node(value = 4,
                        left = Node(value = 3),
                        right = Node(value = 17,
                                left = Node(value = 54))),
                right = Node(value = 8,
                        right = Node(value = 16, left = Node(44), right = Node(88))))
        println(toString(tree))
        val reversed = reverse(tree)
        println(toString(reversed))
        val reversedBack = reverse(reversed)
        println(toString(reversedBack))
        assertEquals(tree, reversedBack)
    }

    fun testSame() {
        val tree = Node(value = 5,
                left = Node(value = 4,
                        left = Node(value = 3),
                        right = Node(value = 17,
                                left = Node(value = 54))),
                right = Node(value = 8,
                        right = Node(value = 16, left = Node(44), right = Node(88))))
        assertTrue(same(tree, tree))
        assertFalse(same(tree, tree.copy(left = tree.left!!.copy(value = 2))))
        assertFalse(same(tree, tree.copy(left = null)))
    }

    fun testSerialization() {
        val tree = Node(value = 5,
                left = Node(value = 4,
                        left = Node(value = 3),
                        right = Node(value = 17,
                                left = Node(value = 54))),
                right = Node(value = 8,
                        right = Node(value = 16)))
        val s = ser(tree)
        val parsed = dser(s)
        println(s)
        assertEquals(tree, parsed)
    }

    private fun same(tree1: Node?, tree2: Node?): Boolean {
        if (tree1 == null && tree2 == null) {
            return true
        }
        if (tree1 == null || tree2 == null) {
            return false
        }
        return tree1.value == tree2.value &&
                same(tree1.left, tree2.left) &&
                same(tree1.right, tree2.right)

    }

    private fun reverse(tree: Node): Node {
        val reversed = Node(tree.value)
        if (tree.left != null) {
            reversed.right = reverse(tree.left!!)
        }
        if (tree.right != null) {
            reversed.left = reverse(tree.right!!)
        }
        return reversed
    }

    private fun toString(tree: Node?): String {
        if (tree == null) {
            return ""
        }
        return "(${tree.value}L${toString(tree.left)}R${toString(tree.right)})"
    }

    private fun dser(s: String): Node {
        val map = mutableMapOf<Int, Node>()
        var root: Node? = null
        val tokens = s.split(",")
        tokens.forEach {
            val beforeL = it.substringBefore("L")
            val beforR = it.substringBefore("R")
            if (it != beforR) {
                val parentId = beforR.toInt()
                val node = Node(it.substringAfter("R").toInt())
                map[node.value] = node
                map[parentId]!!.right = node
            } else if (it != beforeL) {
                val parentId = beforeL.toInt()
                val node = Node(it.substringAfter("L").toInt())
                map[node.value] = node
                map[parentId]!!.left = node
            } else {
                root = Node(it.toInt())
                map[root!!.value] = root!!
            }
        }
        return root!!
    }


    private fun ser(tree: Node): String {
        var s = "${tree.value}"
        if (tree.left != null) {
            s += ",${tree.value}L${ser(tree.left!!)}"
        }
        if (tree.right != null) {
            s += ",${tree.value}R${ser(tree.right!!)}"
        }
        return s
    }


    data class Node(val value: Int,
                    var left: Node? = null,
                    var right: Node? = null)
}