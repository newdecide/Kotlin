package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

class LableTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        println("LableTest")
        ExitLoop()

        println(lambdaReturn())

        (0..10).forEach { if (it > 3) return@forEach else println(it) }

        println("")
    }

    fun ExitLoop() {
        // 레이블
        HereToExit@ for (i in 0..2) {
            for (j in 0..10) {
                if (j == 5) break@HereToExit
                println("i -> $i, j -> $j")
            }
            println("j loop end")
        }
        println("i loop end")
    }

    var lambdaReturn = Exit@{
        if (false) {
            return@Exit 3
        }
        // return과 똑같은 효과
        1000
    }
}