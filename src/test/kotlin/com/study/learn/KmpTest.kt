package com.study.learn

import kotlin.test.Test

/**
 * @Classname KmpTest
 * @Description
 * @Date 2023/12/26 22:49
 * @author by fengww
 */
class KmpTest {

    fun nextArray(arry: List<String>): MutableList<Int> {
        val nextArry: MutableList<Int> = MutableList(arry.size) { -1 }
        nextArry[0] = -1
        nextArry[1] = 0
        for (i in 2 until arry.size) {
            val i1 = nextArry[i - 1]
            if (arry[i - 1] == arry[i1]) {
                nextArry[i] = i1 + 1
            } else if (nextArry[i1] > 0) {
                var i2 = nextArry[i1]
                while (i2 > 0) {
                    if (arry[i - 1] == arry[i2]) {
                        nextArry[i] = i2 + 1
                        break
                    } else {
                        i2 = nextArry[i2]
                    }
                }

            } else {
                nextArry[i] = 0
            }
        }
        return nextArry

    }


    fun kmp(arry: List<String>, target: List<String>): Int {
        val nextArry = nextArray(arry)
        var i = 0
        var j = 0
        while (i < arry.size && j < target.size) {
            if (arry[i] == target[j]) {
                i++
                j++
            } else if (nextArry[j] >= 0) {
                j = nextArry[j]
            } else {
                i++
            }
            if (j == target.size) {
                break
            }
        }

        return if (j == target.size) {
            i - j
        } else {
            -1
        }
    }

    @Test
    fun test_nextArry() {
        val nextArry = nextArray(listOf("a", "a", "a", "a", "a", "a", "a", "a"))
        println(nextArry)
    }

    @Test
    fun test_next_array_two() {
        val nextArry = nextArray(listOf("a", "b", "a", "b", "a", "b", "a", "b"))
        println(nextArry)
    }

    @Test
    fun test_next_array_three() {
        val nextArry = nextArray(listOf("a", "b", "c", "a", "b", "c", "a", "b", "c"))
        println(nextArry)
    }

    @Test
    fun test_next_array_four() {
        val nextArry = nextArray(listOf("a", "c", "d", "b", "s", "t", "a", "c", "d", "t", "x", "e", "a", "c", "d", "b", "s", "t", "a", "c", "d", "b"))
        println(nextArry)
    }


    @Test
    fun test_kmp() {
        val kmp = kmp(listOf("a", "b", "c", "a", "b", "c", "a", "b", "c"), listOf("a", "b"))
        println(kmp)
    }

    @Test
    fun test_kmp_two() {
        val kmp = kmp(listOf("a", "b", "c", "a", "b", "c", "a", "b", "c"), listOf( "b","c","a"))
        println(kmp)
    }
  @Test
    fun test_kmp_three() {
        val kmp = kmp(listOf("a", "b", "c", "a", "b", "c", "a", "b", "c"), listOf( "b","c","e"))
        println(kmp)
    }

}