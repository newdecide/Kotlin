package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

class ConditionTest (p : (Any) -> Unit): TestClass(p){
    override fun doTest() {
        println("ConditionTest if문")

        ifTest("Test")
        ifTest(17.0f)
        ifTest(7)
        ifTest(null)
    }

    fun ifTest(a: Any?) {
        if (a == "Test") {
            println("a는 "+a)
        } else if (a is Float) {
            println("a는 "+"Float")
        } else if (a in (0..9)) {
            println("a는 "+"0-10까지 숫자 : $a")
        } else if (a == null)
            println("a는 "+"null")
    }
}