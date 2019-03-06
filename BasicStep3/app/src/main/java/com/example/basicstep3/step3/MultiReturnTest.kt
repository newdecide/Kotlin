package com.example.basicstep3.step3

import com.example.basicstep3.TestClass

class MultiReturnTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
//    ()안에 변수를 나열한다.
//    - 일반적으로 Data class, List, Pair Collection의 반환값
//    순서대로 특정범위까지 가져올 수 있다.
//        partion 메소드 사용법

        println("MultiReturnTest")
        val (v1, v2, v3) = listOf("Kotlin", 32, 123.0f)
        println("${v1}, ${v2}, ${v3}")

//    데이터 클래스 사용만 아래처럼 편하게 사용가능
//    val (name, grade) = StudentA("name",21)


        // 2. List의 파티션 기능 0~10까지 숫자 it은 0~10까지 출력한다. it%3은 3으로 나눠지는 값 + 1씩 증가
        val lst = (0..10).map { StudentA("name - ${it}", (it % 3) + 1) }
        println(lst)

        println("l1")
        val (l1, l2) = lst.partition { it.grade == 2 }
        l1.map { println(it) }
        println("l2")
        l2.map { println(it) }

        // 3. 순위별로 가져오기
        val (n1, n2, n3) = (0..100) // 0~100의 숫자 3가지 가져오기
            .filter { it % 2 == 0 } // 2로 나눠서 0일때 (짝수만)
            .sortedByDescending { it } // 내림차순

        println(n1.toString() + ", " + n2.toString() + ", " + n3.toString())
        println("")
    }

    data class StudentA(var name: String, var grade: Int)

    class StudentB() {
        var name: String = ""
        var grade: Int = 0
    }
}