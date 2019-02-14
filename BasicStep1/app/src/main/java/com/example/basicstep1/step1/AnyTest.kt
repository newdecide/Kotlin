package com.example.basicstep1.step1

import com.example.basicstep1.TestClass
import java.util.*

class AnyTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // 동적타입을 지원한다. 어떠한 형을 대입시켜도 처리가능한 변수형이다.
        // 최종 대입된 값으로 형이 결정된다.
        // null은 엄격히 구분한다. ?로 정의해야한다.
        println("AnyTest")

        var everybody: Any

        everybody = 1111
        everybody = "문자열테스트"
        everybody = 221.01010
        everybody = 12.00f

        // 좌측의 있는 변수가 우측의 형인지 알아보는 연산자 같은형인지 보는것
        // String이 아닐경우
        if (everybody !is String) {
            if (everybody is Float) {
                println("float입니다.")
            }
        }

        // everybody = null

        println(everybody == 12.00f)
        println(everybody.equals(12.00f))

        // Unit형은 값이 없음을 정의하는 형

        // () 입력은 지울수 있으나 출력(리텬)은 생략 못한다.
        var pFunc: (String) -> Unit = { println(it) }
        pFunc("HiHiHiHiHi")

        // Nothing형은 미래가 없음을 알리는 형 Unit과 유사
        // 할일을 에러로 알려준다.
        // TODO("이거 구현해야 해요.. 일단 실행했으니 종료합니다.")

        // 각 다른 형도 출력 가능
        AllPrint(1234)
        AllPrint("hello")
        AllPrint(Date())
        AllPrint("")
    }

    fun AllPrint(a: Any) = println(a.toString())
}
