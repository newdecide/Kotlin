package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

// p 변수는 Any형을 받는 리턴이 없는 함수다. 테스트 클래스를 상속받는다.
class NumberTest(p: (Any) -> Unit) : TestClass(p) {

    override fun doTest() {
        // 숫자형 DataType
        var doubleV: Double = 110.1111
        var floatV: Float = 110.0f
        var longV: Long = 110
        var intV: Int = 20
        var shortV: Short = 30
        var byteV: Byte = 10

        println(doubleV)
        println(floatV)
        println(intV)

        // 캐스팅
        doubleV = intV.toDouble()
        // doubleV = intV as Double
        // as로 캐스팅하면 올리면 에러는 안뜨지만 성공못할거라 컴파일러가 말해준다.
        // 메서드로 toInt 해줘야 된다.
        // 숫자나 프라이머리는 as로 하지 않고 toDouble로 해줘야 된다.
        intV = doubleV.toInt()
        // 문자열로 변환
        println(byteV.toString())
        // 문자를 숫자로 변환
        var num = "123".toInt() + 10
        println(num)
        println("")
    }
}