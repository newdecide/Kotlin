package Linear

import java.lang.IndexOutOfBoundsException
import java.util.*

// 08:20

class MyLinkedList {
    private var headNode: Node? = null
    private var size: Int = 0

    fun MyLinkedList() {
        headNode = Node()
        size = 0
    }

    fun addFisrt(data: Objects) {
        var newNode: Node = Node(data)
        newNode.nextNode = headNode!!.nextNode
        headNode!!.nextNode = newNode
        size++

    }

    fun get(index: Int): Objects? {
        return getNode(index).data
    }

    private fun getNode(index: Int): Node {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index:" + index + "size : " + size)
        } else {
            var node: Node = headNode!!.nextNode!!
            for (i in 0..index-1) {
                node = node.nextNode!!
            }
            return node
        }
    }

    fun add(index: Int, data: Objects) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index:" + index + "size : " + size)
        }
        var newNode: Node = Node(data)
        var preNode: Node = getNode(index - 1)

        newNode.nextNode = preNode.nextNode
        preNode.nextNode = newNode
        size++
    }

    fun addLast(data: Objects) {
        add(size - 1, data)
    }

    fun removeFirst(): Objects? {
        var node: Node? = headNode!!.nextNode
        headNode!!.nextNode = node!!.nextNode
        var result: Objects = node!!.data!!
        node = null
        size--
        return result
    }

    fun remove(index: Int): Objects? {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index:" + index + "size : " + size)
        }

        if (index == 0) {
            return removeFirst()
        } else {
            var preNode: Node = getNode(index - 1)
            var removeNode: Node? = preNode.nextNode
            var postNode: Node = removeNode!!.nextNode!!
            preNode.nextNode = postNode
            var result: Objects = removeNode.data!!
            removeNode = null
            size--
            return result
        }
    }

    fun size(): Int {
        return size
    }

    override fun toString(): String {
        var result: StringBuffer = StringBuffer("[")
        var node: Node = headNode!!.nextNode!!
        if (node == null) {
            result.append("No Data")
        } else {
            result.append(node.data)
            node = node.nextNode!!
            while (node != null) {
                result.append(", ")
                result.append(node.data)
                node = node.nextNode!!
            }
        }
        result.append("]")
        return result.toString()
    }

    private class Node() {
        var nextNode: Node? = null
        var data: Objects? = null

        constructor(data: Objects) : this() {
            // 새로 추가한 node의 next 초기값은 null 로 설정
            this.nextNode = null
            this.data = data
        }
    }

}