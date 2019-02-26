package com.example.basicstep2.step2

import com.example.basicstep2.TestClass

class PolymorphTest ( p : (Any) -> Unit) : TestClass(p){

    /*
     * 다형성: 메서드와 클래스를 다양한 방법으로 동작하게 만들 수 있는 것을 의미한다.
     * 상속 클래스 메서드와 필드를 open으로 정의한다.
     * 상속 받은 클래스에서 사용시 override 해서 사용 가능 메서드, 변수 재정의
     * private에서 외부 사용 금지
     * 오버로딩(overloading)은 자바와 같다. 파라메터 값을 다르게 정의하면 된다.
     * 코틀린은 연산자 오버로딩을 지원한다. operator로 정의 가능 ex) plus, inc, dec
     * */
    override fun doTest() {
        println("PolymorphTest")
        var obj1 = baseClass()
        obj1.f1()
        var obj2 = childClass()
        obj2.f1()
        obj2.f2()
        obj2.f2("문자열 파라메터")
        obj2.f2("문자열 파라메터", 100)
        println("")
        println("overroding")
        var s = Student("박모씨")
        (0..99).forEach{s++}
        s.printMe()

        var s2 = Student("김모씨")
        s2.nScore = 50
        s2.printMe()

        println("두 학생의 점수는 ${s + s2}")
        println("")
    }
    open class baseClass{
        // 상속 받은 클래스를 override 하려면 부모클래스에서 open으로 정의.
        open var name = "base"
        open fun f1() = println (this.toString())
        // 외부사용금지 메소드 사용 못함.
        private fun onlyMyFunc() = println("클래스 내부에서 만 사용")
        constructor(){
            onlyMyFunc()
        }
    }

    class childClass : baseClass(){
        // 오버라이드
        override var name =""
        override fun f1() = println(this.toString()+ " 재정의함.")
        fun f2() = println("f2")
        // 오버로딩
        fun f2(s:String) = println("f2:$s ")
        fun f2(s:String, num : Int) = println("f2:$s, $num ")

    }

    class Student(s : String){
        var name : String = s
        var nScore : Int = 0

        operator fun plus(student: Student) : Int{
            return student.nScore + this.nScore
        }

        operator fun inc() : Student{
            this.nScore++
            return this
        }

        fun printMe () = println("${name}는 점수가 $nScore")
    }
}