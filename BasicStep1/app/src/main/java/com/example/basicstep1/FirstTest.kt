package com.example.basicstep1

// psvm 치면 자동입력
//fun main(args: Array<String>) {
//
//}


// 변수 Any 파라미터 받는다.
// ->
// Unit
class FirstTest (p : (Any) ->Unit): TestClass(p){
    // controll + o Override
    override fun doTest() {
        println("Hi")
    }
}
