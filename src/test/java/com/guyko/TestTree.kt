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

    private fun reverse(tree: Node?): Node? {
        if (tree == null) {
            return null
        }
        val reversed = Node(tree.value)
        reversed.right = reverse(tree.left)
        reversed.left = reverse(tree.right)
        return reversed
    }

    private fun toString(tree: Node?): String {
        if (tree == null) {
            return ""
        }
        return "(${tree.value}L${toString(tree.left)}R${toString(tree.right)})"
    }

    private fun dser(s: String): Node? {
        val map = mutableMapOf<Int, Node>()
        val tokens = s.split(",")
        if (tokens.isEmpty()) {
            return null
        }
        val root = Node(tokens[0].toInt())
        map[root.value] = root
        (1 until tokens.size).map { tokens[it] }.forEach {
            when {
                it.contains("R") -> {
                    val parentId = it.substringBefore("R").toInt()
                    val node = Node(it.substringAfter("R").toInt())
                    map[node.value] = node
                    map[parentId]!!.right = node
                }
                it.contains("L") -> {
                    val parentId = it.substringBefore("L").toInt()
                    val node = Node(it.substringAfter("L").toInt())
                    map[node.value] = node
                    map[parentId]!!.left = node
                }
            }
        }
        return root
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