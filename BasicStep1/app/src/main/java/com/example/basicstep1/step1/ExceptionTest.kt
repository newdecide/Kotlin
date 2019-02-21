package com.example.basicstep1.step1

import com.example.basicstep1.TestClass
import java.io.File
import java.io.PrintWriter

class ExceptionTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // kotlin에서 예외처리는 선택사항 논리적인 코드를 좋아함.
        // val f = File("")
        // val pw = PrintWriter(f)

        // Java Exception
        //    try {
        //        PrintWriter pw = new PrintWriter(f);
        //    } catch (FileNotFoundException e){
        //        e.printStackTrace();
        //    }

        println("ExceptionTest")

        // java와 달리 try catch가 필수가 아나다.
        var divNumber = 0
        try {
            707 / divNumber
        } catch (e: Exception) {
            println(e)
        } finally {
            println("Last")
        }

        // 1. Kotlin Style (예외처리는 소스크드에서 로직으로! 아니면 종료)
        // var zerodivided = 707 / divNumber
        // println(zerodivided)

        // null checking은 까다로움
        var addNumber: Int? = null
        println("addNumber의 값은? $addNumber")
        // 에러(null 값에 더 할 수 없어서 에러
        // var sum = addNumber + 100

        // 처리방법 1
        if (addNumber != null) {
            var sum1 = addNumber + 100
            println("sum1은? $sum1")
        }
        println("a값이 null이어서 조건문이 만족하지 않아 실행되지 않았다.")
        // 처리방법 2 (종료) !! null일 때 종료
        // var sum2 = addNumber!! + 200
        println("!! 코드를 사용하면 널포인트익센셥뜨면서 앱 종료가 된다.")

        // 처리방법 3 (실행안됨) ? 실행하지 않는다.
        var sum3 = addNumber?.let {
            it + 100
        }
        println("?는 실행 되지 않는다. sum3의 값은? $sum3 이다. 계산이 수행되지 않았다.")

        println("")
    }
}