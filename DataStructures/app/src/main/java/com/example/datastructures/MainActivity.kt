package com.example.datastructures

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var stacklist = StackWithList()
        println("is Stack empty : " + stacklist.isStackEmpty())
        stacklist.push("karthiq")
        println("peek is : " +stacklist.peek())
        stacklist.push(false)
        stacklist.push(5)
        stacklist.push(12.22)
        println("pop elements is : " + stacklist.pop())
        println("size is : " + stacklist.size())
        println("stack empty : " + stacklist.isStackEmpty())
    }
}

class StackWithList{
    val elements: MutableList<Any> = mutableListOf()

    fun isEmpty() = elements.isEmpty()

    // 목록 요소가 있는지 확인
    fun isStackEmpty() = elements.isEmpty()
    // 크기
    fun size() = elements.size
    // 푸시
    fun push(item: Any) = elements.add(item)
    // 팝
    fun pop(): Any? {
        val item= elements.lastOrNull()
        if(!isEmpty()){
            elements.removeAt(elements.size -1)
        }
        return item
    }

    // 엿보기
    fun peek() : Any? = elements.lastOrNull()

    override fun toString(): String = elements.toString()
}