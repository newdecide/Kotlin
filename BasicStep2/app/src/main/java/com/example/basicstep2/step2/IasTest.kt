package com.example.basicstep2.step2

import com.example.basicstep2.TestClass

class IasTest(p: (Any) -> Unit) : TestClass(p) {
    /*
     * interface 클래스 상속과 달리 open을 정의안해도 override가 가능하다.
     * abstract로 만들면 메소드도 abstract로 정의해야 된다. 구현시 override로 정의해야 사용할 수 있다.
     * static은 companion object{}이 안에 변수와 함수를 static으로 정의 해야 한다.
     * */

    override fun doTest() {
        println("InterfaceAbstractStaticTest")
        // 구현하고 설정하는 곳
        var WhatYouWant = 0
        var inter: InterTest = if (WhatYouWant == 1) InterImp2() else InterImp()
        // 넘겨진 값을 신경안쓰고 사용하는 곳
        interfaceTest(inter)

        // 추상화
        var obj2 = TestAbstractImp()
        obj2.TestFunc()
        obj2.abstractFunc()

        // static
        println(TestAbstractImp.staticVar)
        TestAbstractImp.staticFunc()

        println("")
    }
//    interface 설명 간단 예제
//    interface A {
//        fun doA()
//    }
//
//    interface A1 {
//        fun doA1()
//    }
//
//    class B : A, A1{
//        override fun doA() {
//
//        }
//
//        override fun doA1() {
//
//        }
//    }


    fun interfaceTest(pInter: InterTest) {
        pInter.TestFunc()
    }

    // interface는 open을 정의안해도 override 가능
    interface InterTest {
        fun TestFunc()
    }

    class InterImp : InterTest {
        override fun TestFunc() = println("InterImp InterTest")
    }

    class InterImp2 : InterTest {
        override fun TestFunc() = println("InterImp InterTest2")
    }


    // abstract(추상화) 구현하면 메소드도 abstract로 정의 구현시 override로 정의
    abstract class TestAbstract {
        fun TestFunc() = println("abstract TestFunc")
        abstract fun abstractFunc()
    }

    class TestAbstractImp : TestAbstract() {
        override fun abstractFunc() = println("TestAbstractImp abstractFunc")

        // companion object {} 안에서 구현해야 static 가능
        companion object {
            var staticVar = "companion staticVar"
            fun staticFunc() = println("companion staticFunc")
        }

    }
}