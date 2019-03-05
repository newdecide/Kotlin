package com.example.basicstep3.step3

import com.example.basicstep3.TestClass
import java.util.*

class DslTest( p: (Any) -> Unit) : TestClass(p) {
    override fun doTest() {
        // Domain-specific language(도메인 특정 언어)
        // 1. 반복되고 제한된 환경을 위한 간이언어
        // 2. 확장함수를 이용함.

        println("DSLtest")
        var p0 = Player()
        p0.name = "Player 0"
        p0.status = Status()
        p0!!.status!!.job = "Wizard"
        p0!!.status!!.level = 20
        println(p0)

        // Data class로 정의(제일 간단함)
        val p1 = Player("Player 1", Status("Archer", 23))
        println(p1)

        // DSL 구조(Json과 유사한 구조, 팀단위 작업시 사용할지 의논하고 사용하길 추천)
        val p2 = MakePlayer {
            // Java Random함수 사용 1~200, 1~70의 숫자 중 랜덤하게 불러온다.
            name = "Player 2 - " + Random().nextInt(200).toString()
            status {
                job = "Paladin"
                level = Random().nextInt(70)
            }
        }
        println(p2)
        println("")
    }

    fun MakePlayer(block: Player.() -> Unit): Player {
        return Player().apply(block)
    }

    fun Player.status(block: Status.() -> Unit) {
        status = Status().apply(block)
    }

    data class Player(
        var name: String? = null,
        var status: Status? = null
    )

    data class Status(
        var job: String? = null,
        var level: Int? = null
    )
}


