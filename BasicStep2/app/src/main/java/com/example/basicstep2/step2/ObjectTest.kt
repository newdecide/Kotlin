package com.example.basicstep2.step2

import com.example.basicstep2.TestClass

class ObjectTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        println("ObejctTest")
        // 1. 클래스 전체를 싱글톤으로 사용할 때, 마치 java의 static class
        Singleton.showMessage("싱글톤입니다.!")
        // obj 객체 생성 후 처리
        val obj = StaticTest()
        println(obj.msg)

        // 2. companion object
        println(StaticTest.staticVar)
        StaticTest.staticFunc()

        // 3. Android에서 자주 사용됨(온클릭 구현) object class override 구조
        var obj2 = object : fakeClikeHandler() {
            override fun onClik() {
                println("Click!!")
            }
        }
        obj2.onClik() // 온클릭 실행
        println("")
    }

    // object는 선언과 동시에 객체가 생성이 된다 바로 사용가능.
    object Singleton
    {
        // 함수형 변수
        var showMessage = { msg: String -> println(msg) }
    }

    class StaticTest {
        var msg: String = "일반객체로 생성하면 이 변수를 액세스 가능함"

        // companion object{} 안에서 구현해야 static 가능 static 변수와 함수
        companion object {
            var staticVar = "StaticTest.staticVar"
            fun staticFunc() = println("StaticTest.staticFunc")
        }
    }
    // 객체로 만들면 onClick을 반드시 구현해야 된다.
    abstract class fakeClikeHandler {
        abstract fun onClik()
    }
}
