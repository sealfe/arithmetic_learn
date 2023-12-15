package com.study.learn

import org.junit.jupiter.api.Test
import java.util.*
import org.study.Node as Node

class StackTest {
    @Test
    fun test_get_left_min_and_right_min() {
        val list: List<Int> = mutableListOf(3, 4, 2, 6, 5, 7, 1, 9, 8)
        val stack: Stack<Node?> = Stack()
        val leftMin: MutableList<Int?> = ArrayList()
        val rightMin: List<Int> = ArrayList()
        for (i in list.indices) {
            val peek: Node? = stack.peek()
            if (peek == null) {
                leftMin.add(null)
            } else if (peek <= list[i]) {
                leftMin.add(peek)
            } else {
                stack.pop()
            }
            stack.push(list[i])
        }
    }
}

