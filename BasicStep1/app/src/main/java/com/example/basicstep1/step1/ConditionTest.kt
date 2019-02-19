package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

class ConditionTest(p: (Any) -> Unit) : TestClass(p) {
    /*
    * if문은 자바와 유사 자바와 달리 Any타입과, in, is를 함께 사용해 더 유연함
    * for ( i in 1..9) 배열 or 범위만큼 반복한다.
    * while(조건)
    * case 문도 Any타입과 사용되어 상당히 유연해짐.
    * */
    override fun doTest() {
        println("ConditionTest if문")

        ifTest("Test")
        ifTest(17.0f)
        ifTest(7)
        ifTest(null)
        println(if ("AAA".length > 3) true else "짧아요")
        println("")

        println("ConditionTest for, while문")
        loopTest(4)
        println("")

        println("ConditionTest when문 cast")
        caseTest("kotlin study")
        caseTest(10.1f)
        caseTest(3)
        caseTest("")
        var a = "ABCDE"
        println(a)
        val result = when (a) {
            is String -> {
                true
            }
            else -> {
                false
            }
        }
        println(result)
        println("")
    }

    fun ifTest(a: Any?) {
        if (a == "Test") {
            println("a는 " + a)
        } else if (a is Float) {
            println("a는 " + "Float")
        } else if (a in (0..9)) {
            println("a는 " + "0-10까지 숫자 : $a")
        } else {
            println("a는 " + "null")
        }
    }

    fun loopTest(count: Int) {
        for (i in 0..count) {
            println("i -> " + i)
        }
        (0..count).forEach { println("$it ->" + it) }
        var i: Int = 0
        while (i < count) {
            i++; println("i는 " + "$i 입니다.")
        }
    }

    fun caseTest(o: Any?) {
        when (o) {
            is String -> {
                println("문자: " + o)
            }
            is Float -> {
                println("Float: " + o)
            }
            in 0..9 -> {
                println("0부터 9까지 숫자: $o")
            }
            else -> {
                println("???")
            }
        }
    }
}