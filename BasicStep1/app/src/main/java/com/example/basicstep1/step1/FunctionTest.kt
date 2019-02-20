package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

class FunctionTest ( p : (Any)-> Unit): TestClass(p){
    /*
        fun 함수명 ( 변수명 : 데이터크기 , ...) : 리턴값 { return; }
        한 줄로 표현가능한 함수는 {} 대신 = 로 정의 가능하다 .
        함수형 변수의 값 : { 변수정의 → 코드구현 }
        함수형 변수의 형 : ( 입력정의 ) → 리턴정의
    * */

    override fun doTest() {
        println("FunctionTest")
        // fun function의 약자
        // (변수명 : 데이터크기) :리턴값
        // = 한줄로 할 때 사용
        fun Three (n : Int) = 3 * n
        println(Three(3).toString())

        // 파라미터 없이 사용하는 함수
        funByNoParam()
        // int, String형 파라미터를 인자로 사용
        funByParameter(31 , " 숫자입니다")
        // 문자열 데이터를 받고 문자열 반환
        println(funByReturn("Parameter"))
        // 인라인 함수로(int형 데이터 2개 받음)
        println(funByInLine(31,10))

        // 람다식
        funVar ("Function Variable 1")
        println(funcVarType("Function Variable 2"))

        HigherFunc {println("Higher Function")}
        HigherFunc (::funByNoParam)

        println("")
    }
    fun funByReturn( s: String) : Any?{
        return s
    }

    fun funByParameter(i: Int, s: String){
        println(i.toString() + s)
    }

    // 인라인 함수
    fun funByInLine(i: Int, i1: Int) = i * i1

    fun funByNoParam(){
        println("funByNoParam")
    }

    // 고차원 함수 입력값을 함수로 결과를 함수로 넘겨주는 것을 고차함수라 한다.
    fun HigherFunc( f : () -> Unit){
        f()
    }

    // 람다식 이름없는 함수로 바로 print로 넘긴다.
    val funVar = { s: String -> println (s)}

    // :: 함수 주소를 넘기는것 c의 포인터와 같음.
    var funcVarType : (String) -> Any? = ::funByReturn
}