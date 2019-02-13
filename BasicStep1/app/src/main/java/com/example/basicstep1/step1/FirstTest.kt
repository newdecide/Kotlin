package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

// psvm 치면 자동입력 public static void main(앞글자 딴거)
//fun main(args: Array<String>) {
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

        // 0만 입력하면 Int형으로 자동 생성
        var nCount : Int = 0
        // String 형 생략
        var name = "psw"

        val age = 0
        // age ++ 안됨

        var MyMoney : Int? = null
//         println (message)
        var message = "위에서는 엑세스 불가함"
        println(hiMessage)
        println("")
    }
    val hiMessage : String = "Hi"
}
