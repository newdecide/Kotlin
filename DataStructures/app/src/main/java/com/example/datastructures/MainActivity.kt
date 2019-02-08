package com.example.datastructures

import android.os.Build.VERSION_CODES.P
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception
import java.util.*
import java.util.jar.JarEntry

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var stacklist = StackWithList()
//        println("is Stack empty : " + stacklist.isStackEmpty())
//        stacklist.push("karthiq")
//        println("peek is : " + stacklist.peek())
//        stacklist.push(false)
//        stacklist.push(5)
//        stacklist.push(12.22)
//        println("pop elements is : " + stacklist.pop())
//        println("size is : " + stacklist.size())
//        println("stack empty : " + stacklist.isStackEmpty())
//
//
//        val stack = StackUsingArray(5)
//        stack.push(1)
//        stack.push(7)
//        stack.push(5)
//        stack.push(3)
//        stack.push(2)
//        println("is stack empty : "+stack.isStackEmpty())
//        println("size of stack : " +stack.size())
//        println("peek : " + stack.peek())
//        println("pop : "+ stack.pop())
//        println("size of stack : " +stack.size())

//        var a = Queue(mutableListOf("karthiq", 2, 3, "four"))
//
//        // queue 7 추가
//        println(a.enqueue(7))
//        println(a) // print all
//
//        // queue 제거
//        println(a.dequeue())
//        println(a)
//
//        // queue 나갈 수 있는거 엿보기
//        println(a.peek())
//        println(a)
//
//        // queue 다음 대상 확인
//        print(a.size())
//
//        // 비어있는지 확인
//        println(a.isEmpty()

//        val queue = DynamicQueueArray()
//        queue.enqueue(4)
//        println(queue.size())
//        queue.dequeue()
//        println(queue.size())
//        queue.enqueue(56)
//        println(queue.size())
//        queue.enqueue(67)
//        println(queue.size())
//        println(queue.dequeue())
//        println(queue.size())
//        println(queue.peek())
//        println(queue.size())
//        println(queue.isQueueEmpty())

        var deq = Deque()
        println(deq.isDequeEmpty())
        println(deq.addFirst("karthiq"))
        println(deq.isDequeEmpty())
        println(deq.addLast(false))
        println(deq.getLast())
        println(deq.size())
        println(deq.peekFirst())
        println(deq.peekLast())
        deq.removeLast()
        deq.removeFirst()
    }

    class StackWithList {
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
            val item = elements.lastOrNull()
            if (!isEmpty()) {
                elements.removeAt(elements.size - 1)
            }
            return item
        }

        // 엿보기
        fun peek(): Any? = elements.lastOrNull()

        override fun toString(): String = elements.toString()
    }

    class StackUsingArray(size: Int) {
        private var stackSize = size
        private var stackArr = IntArray(stackSize)
        private var top = -1

        fun push(entry: Int) {
            if (this.isStackFull()) {
                println("Stack is full. Increasing the capacity.")
                this.increaseStackCapacity()
            }

            top += 1
            println("Adding: $entry")
            this.stackArr[top] = entry
        }

        fun pop(): Any {
            if (this.isStackEmpty()) {
                throw Exception("Stack is empty. Can not remove element.")
            }
            var entry = this.stackArr[top--]
            println("Removed entry: $entry")
            return entry
        }

        fun size(): Any {
            return top + 1
        }

        fun peek(): Any {
            return stackArr[top]
        }

        private fun increaseStackCapacity() {
            val newStack = IntArray(this.stackSize * 2)
            for (i in 0 until stackSize) {
                newStack[i] = this.stackArr[i]
            }
            this.stackArr = newStack
            this.stackSize = this.stackSize * 2
        }

        fun isStackEmpty(): Boolean {
            return top === -1
        }

        private fun isStackFull(): Boolean {
            return top === stackSize - 1
        }
    }
}

class Queue(list: MutableList<Any>) {
    var items: MutableList<Any> = list
    fun isEmpty(): Boolean = items.isEmpty()
    fun size(): Int = items.count()
    override fun toString() = items.toString()
    fun enqueue(element: Any) {
        items.add(element)
    }

    fun dequeue(): Any? {
        if (this.isEmpty()) {
            return null
        } else {
            return items.removeAt(0)
        }
    }

    fun peek(): Any? {
        return items[0]
    }
}

class DynamicQueueArray {
    private val capacity = 6
    private var queueArr: IntArray = IntArray(this.capacity)
    private var front = 0
    private var rear = -1
    private var currentSize = 0

    fun enqueue(item: Int) {
        if (isQueueFull()) {
            println("Queue is full, increase capacity...")
            increaseCapacity()
        }
        rear++
        if (rear >= queueArr.size && currentSize !== queueArr.size) {
            rear = 0
        }
        queueArr[rear] = item
        currentSize++
        println("Adding: $item")
    }

    fun dequeue() {
        if (isQueueEmpty()) {
            println("Underflow ! Unable to remove element from Queue")
        } else {
            front++
            if (front > queueArr.size - 1) {
                System.out.println("remove: " + queueArr[front - 1])
                front = 0
            } else {
                System.out.println("remove: " + queueArr[front - 1])
            }
            currentSize--
        }
    }

    fun peek(): Int? {
        if(isQueueEmpty()){
            println("Underflow ! Unable to remove element from Queue")
            return null
        } else {
            return queueArr[front]
        }
    }

    fun size(): Int {
        return currentSize
    }

    private fun isQueueFull(): Boolean {
        var status = false
        if (currentSize == queueArr.size) {
            status = true
        }
        return status
    }

    fun isQueueEmpty(): Boolean {
        var status = false
        if (currentSize === 0) {
            status = true
        }
        return status
    }

    private fun increaseCapacity() {
        val newCapacity = this.queueArr.size * 2
        val newArr = IntArray(newCapacity)

        var tmpFront = front
        var index = -1
        while(true){
            newArr[++index] = this.queueArr[tmpFront]
            tmpFront++
            if(tmpFront == this.queueArr.size) {
                tmpFront = 0
            }
            if(currentSize === index + 1){
                break
            }
        }

        this.queueArr = newArr
        System.out.println("New array capacity: " + this.queueArr.size)

        this.front = 9
        this.rear = index
    }
}

class Deque() {
    var backingList: MutableList<Any> = arrayListOf()
    fun addFirst(element: Any) {
        backingList.add(0, element)
    }

    fun getFirst(): Any? {
        if (backingList.isEmpty()) {
            return null
        }
        val value = backingList.first()
        removeFirst()
        return value
    }

    fun removeFirst() {
        if (backingList.isNotEmpty()) backingList.removeAt(0)
    }

    fun peekFirst(): Any? {
        return backingList.firstOrNull()
    }

    fun addLast(element: Any) {
        backingList.add(element)
    }

    fun getLast(): Any? {
        if (backingList.isEmpty()) {
            return null
        }
        val value = backingList.last()
        removeLast()
        return value
    }

    fun removeLast() {
        if (backingList.isNotEmpty()) backingList.removeAt(backingList.size - 1)
    }

    fun peekLast(): Any? {
        return backingList.lastOrNull()
    }

    fun size(): Int {
        return backingList.size
    }

    fun isDequeEmpty(): Boolean {
        return backingList.isEmpty()
    }
}

