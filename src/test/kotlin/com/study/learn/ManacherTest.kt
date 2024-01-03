package com.study.learn

import kotlin.test.Test

class ManacherTest {


    fun manacher(str: String): String {
        val charArray = str.toCharArray()
        val handlerArray = handlerArray(charArray)
        var radiusList = MutableList(handlerArray.size) { 0 }
        var remoteIndex = 0
        var centerIndex = 0
        for (i in handlerArray.indices) {
            if(i%2==1){
                continue
            }
            if (i < remoteIndex) {
                if (radiusList[centerIndex * 2 - i] != remoteIndex - i) {
                    radiusList[i] = radiusList[centerIndex * 2 - i]
                    continue
                }
                var b = 1
                while (remoteIndex+b < handlerArray.size && handlerArray[remoteIndex + b] == handlerArray[i - (remoteIndex - i) - b]) {
                    b++
                }
                radiusList[i] = b + radiusList[centerIndex * 2 - i]
            }
            val remote = getRadius(handlerArray, i)
            if (remote + i > remoteIndex) {
                remoteIndex = remote + i
                centerIndex = i
            }
            radiusList[i] = remote
        }
        return radiusList.toString()

    }

    private fun getRadius(handlerArray: CharArray, i: Int): Int {
        var j = i
        var radius = 0
        while (j >1 && j < handlerArray.size-1 && handlerArray[j - radius] == handlerArray[j + radius]) {
            radius++
        }
        return radius-1
    }

    private fun handlerArray(charArray: CharArray): CharArray {
        val handlerArray = CharArray(charArray.size * 2 + 1)
        for (i in charArray.indices) {
            handlerArray[2 * i] = charArray[i]
            handlerArray[2 * i + 1] = '#'
        }
        return handlerArray
    }


    @Test
    fun manacher_test() {
        val str = "abc1234321ab"
        println(handlerArray(str.toCharArray()))
        println(manacher(str))
    }



    @Test
    fun manacher_test2(){
        val str = "efaba1234321aba12"
        println(manacher(str))
    }



}