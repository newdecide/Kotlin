package com.example.basicstep3.step3

import com.example.basicstep3.TestClass
import java.util.*

class LazyLateTest (p : (Any) -> Unit) : TestClass(p){
    override fun doTest() {
        println("LazyLateTest")
        var l : LateInitTest = LateInitTest()
        l.Test()
        var l2 : LazyInitTest = LazyInitTest()
        l2.Test()
        println("")
    }

// 코틀린에서는 java와 달리 멤버필드를 반드시 초기화해야 한다.
// 아니면 abstract나 lateinit으로 선언해주어야 한다.

// 1. var만 사용가능.
// 2. 늦은초기화이므로 초기화전에 사용불가
// 3. primitive 형은 불가능함.

    class LateInitTest {
        // 일반 변수 사용방법
        var normalValue: Int = 3

        // init으로 초기화해야 에러가 안난다.
        var initTest: Int

        // "선언 = 초기화"를 안해도 된다.
        lateinit var late : String

        init {
            initTest = 0
        }

        fun Test(){
            this.late = "LateInit 초기화"
            println(this.late)
        }
    }

// 1. val로 선언
// 2. 사용하는 시점에서 초기화가 1회 발생
// 3. primitive 형도 가능ㄴ
    class LazyInitTest{
        val lazy1: String by lazy {
            "LazyInit 초기화"
        }

        val lazy2: Int by lazy {
            println("한 번만 실행")
            "JAVA Random함수"
            Random().nextInt(100)
        }

        fun Test() {
            println(lazy1)
            println(lazy2)
            println(lazy2)
        }
    }
}