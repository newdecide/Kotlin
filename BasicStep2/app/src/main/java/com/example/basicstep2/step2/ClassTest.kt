package com.example.basicstep2.step2

import com.example.basicstep2.TestClass

class ClassTest(p: (Any) -> Unit) : TestClass(p) {
    /*
    * 코틀린 클래스는 파일명과 달라도 상관없다. 자바는 일치해야 한다.
    * class name{} 형태
    * 생성자는 constructor(매개변수){} 형태 constructor(변수명: 데이터형, ..){}
    * 부모클래스에 open class로 선언해야 사용 가능
    * */

    override fun doTest() {
        println("ClassTest")
        Test1().showInfo()
        Test1("How old are you", 30).showInfo()
        Test2("클래스테스트").showInfo()
        Test2("코틀린 학습중", 10).showInfo()

        // 상속받은 부모의 sayHello 함수 사용.
        ChildClass("Nice to meet you").sayHello()
        println("")
    }

    class Test1 {
        var sName: String = "test1"
        var nAge: Int = 10

        // 생성자1(this 패키지)
        constructor() {
            println("class 경로: "+this.toString())
        }

        // 생성자2
        constructor(name: String, age: Int) {
            sName = name
            nAge = age
        }

        fun showInfo() = println("${sName} : ${nAge}")
    }

    // 변수를 가진 class
    class Test2(name: String) {
        var sName: String = name
        var nAge: Int = 10

        // constructor와 비슷, 변수 초기화에 사용한다.
        init {
            sName = name
        }

        constructor(name: String, age: Int) : this(name) {
            sName = name
            nAge = age
        }

        fun showInfo() = println("${sName} : ${nAge}")

    }

    // 상속을 시키기 위해서 open으로 정의 아니면 빨간줄생김
    open class ParentClass(msg: String) {
        var message = msg
        fun sayHello() = println(message)
    }

    class ChildClass(m: String) : ParentClass(m) {

    }
}