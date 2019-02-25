package com.example.basicstep2.step2

import com.example.basicstep2.TestClass

class DataClassTest(p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        /*
        * data class는 상속불가, data처리에 특화된 클래스
        * () 안에 필드 정의가능, {}안에 멤버, 메소드 정의 가능
        * data class도 멀티리턴처럼 보일 수 있다.(Destructuring Declarations)
        * 클래스의 필드를 쪼개서 대입한다.
        * copy함수도 유용함.
        * */
        println("Dataclass")
        // 1. 일반 클래스로 데이터값을 할당해보기
        var a = A()
        a.power = 3
        a.name = "snake"

        println("${a.name.toString()}, ${a.power.toString()}")

        // 2. data class 사용해보기
        var d0 = DataA("AAA", 3)
        var d = DataA(nLevel = 3)

        println(d0)
        println(d)

        // 3. data class에서 body 적용해보기
        var d3 = DataA(nLevel = 11)
        d3.job = "궁수(archer)"
        println(d3)
        d3.name = "철수"
        println(d3)
        println("철수의 job은? " + d3.job)

        // 4. data class에서 copy 메소드
        var d4 = d3.copy(name = "동작구짱구")
        println(d4)

        // 5. data class에서 destruction
        // (name) = d4를 하게 되면 DataA data class의 맨 처음 변수가 복사 된다.
        var (name) = d4
        println(name)

        var (name2, power) = d4
        println("$name2 $power ")
        println("")
    }

    class A {
        var name: String = ""
        var power: Int = 0
    }

    // 데이터 클래스 네임 초기값 "이름없음"으로 설정
    data class DataA(var name: String = "이름없음", var nLevel: Int) {
        var job: String = ""
        // 연산자 오버로딩
        operator fun plus(d: DataA) {
            this.nLevel + d.nLevel
        }
    }
}