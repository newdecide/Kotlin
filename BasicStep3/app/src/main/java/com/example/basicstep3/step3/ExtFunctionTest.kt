package com.example.basicstep3.step3

import com.example.basicstep3.TestClass

class ExtFunctionTest ( p : (Any) -> Unit) : TestClass(p){
    /*
     1.let
     2.apply()
     3.run()
     4.also
     */

    override fun doTest() {
        println("ExtFunctionTest")
        // 1.let : 결과값을 받아 넘긴다. 이름없는 함수를 더 간결하게 사용할 수 있다.
        f1().let { value -> println("f1()은 $value 입니다.") } // f1() 함수의 10을 받아 출력한다.
        // 변수명 지정하지 않으면 it으로 지정된다.
        f1().let { println(it) }

        1233.let { it + 1 }.let { it * 3 }.let { println(it) } // (1233+1)*3 =3702

        var add = { a: Int, b: Int -> a + b }
        add(1, 2).let { println(it) }

        var bug: () -> Any? = { 348794237 }
        // ?가 있으면 뒤에가 실행이 안된다.
        bug()?.let { println(it) }

        //    if( bug == null){
        //        println(bug())
        //    }

        // 2. apply : 객체 생성과 동시에 초기화 할때 많이 사용한다. 메서드호출
        var obj = Test().apply { sName = "박모씨"; nAge = 49 }
        obj.aboutMe()

        // 3.run : 실행함수. 생성된 객체만 사용할수있다.
        obj.run { sName = "김모씨"; aging(); sName }.let { println(it) }
        obj.aboutMe()

        // 실행결과를 리턴 변수없이 안전하게 넘길때 쓰인다.
        run { 333 + 4 }.let { println(it) }

        // 4.also : 결과값을 넘기지 않는다. let에서 받은 값을 사용한다.
        100.let { println(it); it } // 100
            .also { println(it + 1000) } // 1100
            .also { println(it + 20) } // 120
            .let { println(it) } // 100
        println("")
    }

    fun f1() = 10
    class Test {
        var sName: String = "무명씨"
        var nAge: Int = 49
        fun aboutMe() = println("이름은 \"$sName\"이고 나이는 $nAge 입니다. ")
        fun aging() = nAge++
    }
}