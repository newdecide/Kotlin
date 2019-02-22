package com.example.basicstep2

open class TestClass( func : (Any) -> Unit){

    companion object {
        var println : (Any) -> Unit = {}
    }

    init{
        println = func
    }

    open fun doTest(){}
}