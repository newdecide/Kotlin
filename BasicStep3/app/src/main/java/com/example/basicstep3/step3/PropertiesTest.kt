package com.example.basicstep3.step3

import com.example.basicstep3.TestClass

class PropertiesTest (p: (Any) -> Unit) : TestClass(p){
    override fun doTest() {
        println("PropertiesTest")
        // password 프로퍼티로 사용
        password = "123456789123456789"
        println(password)

        // 내가 만든 클래스에 확장 프로퍼티(newProp) 추가
        val empty = EmptyClass()
        empty.newProp = "안녕"
        empty.newProp = "반가워요"
        empty.newProp = "새로운 클래스"
        println(empty.newProp)

        // mutableList에 확장 프로퍼티 추가
        // Queue와 흡사한 Log처리
        val mLog = mutableListOf<String>("success:100", "pass:203", "fail:001")
        println(mLog)

        mLog.firstHead = "success:200"
        mLog.firstHead = "shutdown:-1"
        mLog.firstHead = "첫번째 원소로 추가"
        mLog.forEach { println(">${it}") } // mLog 기존 데이터 3개와 추가한 3개 데이터 추가
        println("0번째 데이터: "+mLog.firstHead) // mLog 리스트 0번째 원소 출력

        println("")
    }
    // String 타입의 password 변수 선언
    var password: String = ""
        get() {
            // set으로 저장한 정보를 가져와서 비교함
            // field(자기자신)의 길이가 5를 넘으면 길이를 초과했다고로 텍스트를 변
            if (field.length > 5) {
                field = "암호는 5자리를 넘으면 안됩니다."
            }
            return field
        }
        // password 함수 사용시 첫번째로 저장함
        set(s: String) {
            println("\"${s}\"을 저장함")
            // field는 자기자신에게 값을 저장함
            field = s
        }

    // 변수만 있는 클래스 생성
    class EmptyClass {
        var message: String = ""
    }

    // EmptyClass 확장 새 프로퍼티 추가
    var EmptyClass?.newProp: String
        get() {
            // 메시지 변수를 가져온다.
            return this!!.message
        }
        set(value) {
            // 값을 입력받아 메시지에 추가한다.
            this!!.message = value + "-" + this!!.message
        }

    var MutableList<String>?.firstHead: String
        get() {
            // 리스트의 0번째 값을 가져온다.
            return this!!.get(0)
        }
        set(value) {
            // mutableList 0번째에 받은 값을 추가
            this!!.add(0, value)
        }
}