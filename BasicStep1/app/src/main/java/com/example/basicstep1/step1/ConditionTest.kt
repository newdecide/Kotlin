package com.example.basicstep1.step1

import com.example.basicstep1.TestClass
import kotlin.math.sign

class ConditionTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        println("ConditionTest if문")

        ifTest("Test")
        ifTest(17.0f)
        ifTest(7)
        ifTest(null)
        println("")

        println("ConditionTest for, while문")
        loopTest(4)
        println("")

    }

    fun ifTest(a: Any?) {
        if (a == "Test") {
            println("a는 " + a)
        } else if (a is Float) {
            println("a는 " + "Float")
        } else if (a in (0..9)) {
            println("a는 " + "0-10까지 숫자 : $a")
        } else if (a == null)
            println("a는 " + "null")
    }

    fun loopTest(count: Int) {
        for (i in (0..count)) {
            println("i -> " + i)
        }
        (0..count).forEach { println("$it ->" + it) }
        var i: Int = 0
        while (i < count) {
            i++; println("i는 "+"$i 입니다.")
        }
    }
}