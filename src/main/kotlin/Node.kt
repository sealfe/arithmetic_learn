package org.study

import lombok.Data
import lombok.ToString

@Data
class Node(var indexs: MutableList<Int> = mutableListOf(), var value: Int = 0) {

    operator fun compareTo(node: Node): Int {
        return this.value - node.value
    }

    operator fun plus(node: Node): Node {
        this.indexs.addAll(node.indexs)
        return this
    }

    operator fun compareTo(value: Int): Int {
        return this.value - value
    }

    override fun toString(): String {
        return "Node(indexs=$indexs, value=$value)"
    }


}