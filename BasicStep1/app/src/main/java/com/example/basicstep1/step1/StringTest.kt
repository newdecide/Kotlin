package com.example.basicstep1.step1

import com.example.basicstep1.TestClass
import java.util.*

class StringTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        println("StringTest")
        var sName = "김모씨"
        // 1.문자열을 추가하는 것은 + 연산자로 가능함 <- Java와 동일
        println(sName + " - The Gamer")

        var sLines = """
1
2
3
4
5
6
7
8
9
    """.trimIndent()

        println(sLines)

        // $쓰고 뒤에 변수명을 쓰면 사용가능
        var sFormatter = "$sName <-- sName의 값"
        println(sFormatter)

        var sBash = "${"지금시각은 - " + Date()}"
        println(sBash)
        println("")
    }
}