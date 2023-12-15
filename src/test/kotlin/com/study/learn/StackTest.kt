package com.study.learn

import org.junit.jupiter.api.Test
import org.study.ResultInfo
import java.util.*
import org.study.Node as Node

class StackTest {
    @Test
    fun test_get_left_min_and_right_min() {
        val list: List<Int> = mutableListOf(3, 4, 2, 6, 5, 7, 1, 9, 8)
        val stack: Stack<Node?> = Stack()
        val results: MutableList<ResultInfo> = mutableListOf()
        for (i in list.indices) {
            val node = Node(mutableListOf(i), list[i])
            while (stack.isNotEmpty() && stack.peek()!! > node) {
                stack.pop()?.let { poppedNode ->
                    addResultInfo(results, poppedNode, stack.peek(), node)
                }
            }
            stack.push(node)
        }

        while (stack.isNotEmpty()) {
            stack.pop()?.let { poppedNode ->
                addResultInfo(results, poppedNode, stack.peek(), null)
        }
        }

        results.sortBy { it.index }
        println(results)
    }

    private fun addResultInfo(results: MutableList<ResultInfo>, poppedNode: Node, leftNode: Node?, rightNode: Node?) {
        results.add(ResultInfo(poppedNode.indexs[0], poppedNode.value, leftNode, rightNode))
    }
}

