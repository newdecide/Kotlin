package com.example.basicstep1.step1

import com.example.basicstep1.TestClass
import java.util.*

class StringTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        println("StringTest")
        var sName = "김모씨"
        // 1.문자열을 추가하는 것은 + 연산자로 가능함 <- Java와 동일
        println(sName + " - The Gamer")

        // 2. """ 이 안에 줄넘김 문자열이 들어갈 수 있다. """
        // Python에도 있는 기능
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

        // 3. 문자열 내의 포멧팅 방법
        // linux의 bash와 비슷함.

        // $쓰고 뒤에 변수명을 쓰면 사용가능
        var sFormatter = "$sName <-- sName의 값"
        println(sFormatter)

        // ${}안에
        // 함수호출이나 수식처리도 가능함.
        var sBash = "${"지금시각은 - " + Date()}"
        var sBash2 = "지금시각은 - "+Date()
        println(sBash)
        println(sBash2)
        println("")
    }
}