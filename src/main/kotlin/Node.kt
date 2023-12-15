package org.study

import lombok.Data

@Data
class Node() {
    var value: Int = 0
    var indexs: MutableList<Int> = mutableListOf()

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

}