package com.example.basicstep3.step3

import com.example.basicstep3.TestClass

class LambdasTest(p: (Any) -> Unit) : TestClass(p) {
    /*
    * lambdas 이름없는 함수
    * {변수 정의 -> 함수 구현}
    * 고차함수 함수 덩어리를 받고 넘겨주는
    * */

    override fun doTest() {
        println("LambdasTest")

        // 1. 람다식으로 정의한 함수형 변수(리턴이 따로 없어도 리턴이 된다.
        var pfunc = { a: Int, b: Int -> a + b }
        println(pfunc(10, 30))

        // 2. 고차함수에 람다식을 넘기기
        fn1(pfunc)
        // 함수를 넘길때 ()를 해줘야 하나 함수 하나만 넘길때 ()없이 넘길수 있다.
        fn2 { n, n2 -> n + n2 }

        // 3. 고차함수에 람다식과 값을 같이 넘기기
        fn3({ n, n2 -> n + n2 }, 100, 210)

        // 4. 함수에 주소값을 직접대입시키는 방법
        fn4(::Add)

        // 5. 람다식의 간소화
        // 함수원형의 포인터를 대입시키는 방법
        var funParameter = { a: Int -> Add(a) }
        fn4(funParameter)

        // 위의 코딩을 점점 더 단순화
        fn4({ a: Int -> Add(a) })
        fn4 { a: Int -> Add(a) }
        fn4 { a -> Add(a) }
        println("")
    }

    fun fn1(func: (Int, Int) -> Int) {
        // 한글로도 변수 사용가능
        func(10, 10).let { 결과값 -> println("결과값은 $결과값 입니다.") }
        // func(10, 10).let { println("결과값은 $it 입니다.") }
    }

    fun fn2(func: (Int, Int) -> Int) {
        println(func(10, 10))
    }

    fun fn3(func: (Int, Int) -> Int, a: Int, b: Int) {
        println(func(a, b))
    }

    fun fn4(func: (Int) -> Int) {
        println(func(1))
    }

    fun Add(i: Int): Int {
        return i + 100
    }
}