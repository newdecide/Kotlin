package com.example.basicstep3.step3

import com.example.basicstep3.TestClass

class ClosureTest ( p : (Any) -> Unit) : TestClass(p){
    override fun doTest() {
        println("ClosureTest")
        // 변수에 초기값 10을 선언한다.
        // 메모리에 저장되어 있어 20, 30, 40으로 더한 값이 나온다.
        var fn = Closure1(10)
        println( fn(10))
        println( fn(10))
        println( fn(10))

        // num 함수를 공식으로 넘겨줌 공식이 적용된 함수를 넘겨준다.
        var decByOne = Closure2({num -> num -1})
        println(decByOne())
        println(decByOne())

        // 특정함수의 공식으로 관리할 경우 clouser이 편리하다.
        fun Add(num : Int) = num + 10
        var addByTen = Closure2(::Add)
        println(addByTen())
        println(addByTen())
        println("")
    }

    // 파라미터로 인트로 넘버 받고 인트형 받는 인트를 함수로 넘긴다 정의
    // 객체지향처럼 함수 내의 변수들을 계속 유지할 수 있다.
    fun Closure1 (num : Int) : (Int) -> Int{
        var sum : Int = num

        // 전역변수처럼 이름없는 함수로 만듦
        return fun (num2: Int) :Int{
            sum = sum+num2
            return sum
        }
    }

    // 더 많이 사용하는 closure

    fun Closure2 (pFunc : (Int) -> Int) : () -> Int{
        var result : Int = 0

        return {
            result = pFunc(result)
            result
        }
    }
}