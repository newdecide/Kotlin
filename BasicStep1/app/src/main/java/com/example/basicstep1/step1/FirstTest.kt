package com.example.basicstep1.step1

import com.example.basicstep1.TestClass
// 1. 종결자를 사용하지 않아도 된다.
// 2. 형을 선언하지않았다면 변수 대입시 형이 결정된다.
// 3. 변수는 읽기전용과 읽기쓰기 상태로 선언된다.
// 4. null은 엄격히 구분한다. -> null을 허용하는 변수는 ?로 정의
// 5. scope는 java와 유사하다.
// psvm 치면 자동입력 public static void main(앞글자 딴거)
// fun main(args: Array<String>) {
//
//}

// 변수 Any 파라미터 받는다.
// ->
// Unit 값이 없음을 정의하는 형
class FirstTest (p : (Any) ->Unit): TestClass(p){
    // controll + o = Override
    override fun doTest() {
        println("FirstTest")
        println("종결자(;) 없어도 됩니다.")
        println("var는 읽기 쓰기, val 읽기 전용")

        // 형이 결정되면 다른 형으로 변환 불가
        var nCount : Int = 0
        var nCnt = 0
        // 0만 입력하면 Int형으로 자동 생성

        // String 형 생략
        var name = "psw"

        // 읽기전
        val age = 0
        // age ++ 안됨

        // null이 가능하려면 ?(엘비스)를 붙여야 된다.
        var MyMoney : Int? = null

        // 먼저 선언되어있어야 호출 가능
        // println (message)

        var message = "위에서는 엑세스 불가함"
        println(hiMessage)
        println("")
    }
    val hiMessage : String = "Hi"
}
