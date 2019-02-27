package com.example.basicstep3

open class TestClass( f : (Any) -> Unit){
    companion object {
        var println: (Any) -> Unit = {}
    }

    init {
        println = f
    }

    open fun doTest(){}
}