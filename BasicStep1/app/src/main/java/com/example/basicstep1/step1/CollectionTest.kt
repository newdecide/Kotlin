package com.example.basicstep1.step1

import com.example.basicstep1.TestClass

class CollectionTest(p: (Any) -> Unit) : TestClass(p) {
    /*
    * 읽기전용 List -> listOf. 항목의 데이터형을 혼합해도 됨.
    * 수정가능 List -> mutableListOf. 제너릭( <> )으로 데이터형을 반드시 선언. 각종 메소드(add, remove,...)
    * Map은 hashMapOf(키 to 값, ... ) 형식
    * */
    override fun doTest() {
        println("CollectionTest")
        // 읽기전용 - list. 데이터형을 마구 섞어도 된다.
        val list = listOf(1, "A", 12.00f, false, true)
        for (i in 0..list.size - 1) {
            println(list.get(i).toString())
        }
        println(">")
        // 수정가능 - list. 데이터형을 미리 정해야 하는 듯.
        var listEditable = mutableListOf<String>()
        listEditable.add("A")
        listEditable.add("B")
        listEditable.add("C")

        for (s in listEditable) {
            println(s)
        }
        println(">")

        // remove 메소드로 삭제
        listEditable.removeAt(0)

        for (s in listEditable) {
            println(s)
        }

        var m = hashMapOf("A" to 1, "B" to 2)
        println(m["A"])

        println("")
    }

}