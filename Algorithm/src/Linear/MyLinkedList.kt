package Linear

import java.lang.IndexOutOfBoundsException
import java.util.*

// 08:20
// 단일 연결 리스트는 헤드 노드와 일반 노드로 이루어진다.
class MyLinkedList {
    private val headNode: Node // 제일 첫번째의 노드로, '연결리스트'의 기준점이 될 뿐 데이터를 저장하진 않는다.

    private var size: Int

    init {
        // 생성시 Head Node 생성
        // head 는 일반적으로 데이터를 저장하지 않음
        // 첫번째 노드 주소를 가르키기 위한 용도
        headNode = Node()
        size = 0
    }

    // 첫번째 노드에 데이터를 저장하기 위한 Method
    fun addFisrt(data: Any) {
        // 새로운 Node 생성
        var newNode = Node(data)
        // 새로운 Node의 next Node의 주소값
        newNode.nextNode = headNode.nextNode
        headNode.nextNode = newNode
        // size 증가
        size++

    }

    // 특정한 Node의 data값 가져오기
    fun get(index: Int): Any? {
        return getNode(index).data
    }

    private fun getNode(index: Int): Node {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("index:" + index + "size : " + size) as Throwable
        } else {
            var node = headNode.nextNode!!
            for (i in 0 until index) {
                node = node.nextNode!!
            }
            return node
        }
    }

    // add Node: 원하는 위치에 데이터를 넣는 메소드이다. addLast:'연결리스트'의 마지막 위치에 데이터를 넣는 메소드이다.
    fun add(index: Int, data: Any) {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("index:" + index + "size : " + size)
        }
        val newNode: Node = Node(data)
        val preNode: Node = getNode(index - 1)

        newNode.nextNode = preNode.nextNode
        preNode.nextNode = newNode
        size++
    }

    fun addLast(data: Any) {
        add(size - 1, data)
    }

    // 첫번째 Node 삭제
    fun removeFirst(): Any? {
        var node = headNode.nextNode
        headNode.nextNode = node!!.nextNode
        val result = node.data
        node = null
        size--
        return result
    }

    // 특이한 Node 삭제
    fun remove(index: Int): Any? {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("index:" + index + "size : " + size)
        }

        if (index == 0) {
            return removeFirst()
        } else {
            var preNode: Node = getNode(index - 1)
            var removeNode: Node? = preNode.nextNode
            var postNode: Node = removeNode!!.nextNode!!
            preNode.nextNode = postNode
            var result = removeNode.data
            removeNode = null
            size--
            return result
        }
    }

    fun size(): Int {
        return size
    }

    // 모든 데이터 출력
    override fun toString(): String {
        var result = StringBuffer("[")
        var node = headNode.nextNode
        if (node == null) {
            result.append("No Data")
        } else {
            result.append(node.data)
            node = node.nextNode
            while (node != null) {
                result.append(", ")
                result.append(node.data)
                node = node.nextNode
            }
        }
        result.append("]")
        return result.toString()
    }

    private inner class Node {
        var nextNode: Node? = null
        var data: Any? = null

        internal constructor() {}
        internal constructor(data: Any) {
            // 새로 추가한 node의 next 초기값은 null 로 설정
            this.nextNode = null
            this.data = data
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = MyLinkedList()
            list.addFisrt(500)
            list.addFisrt(400)
            list.addFisrt(300)
            list.addFisrt(200)
            list.addFisrt(100)
            print("단방향 연결리스트 추가: ")
            println(list.toString()) // 100 200 300 400 500
            print("리스트의 1 인덱스에 150 추가: ")
            list.add(1, 150)
            println(list.toString()) // 100 150 200 300 400 500
            print("리스트의 1 인덱스 삭제: ")
            list.remove(1)
            print("리스트 추가: ")
            println(list.toString()) // 100 200 300 400 500
            print("리스트 길이 출력: ")
            println(list.size()) // 5
            print("헤드 리스트 제거: ")
            list.removeFirst()
            println(list.toString()) // 200 300 400 500
            print("리스트 2 인덱스 데이터 출력: ")
            println(list.get(2)) // 400
        }
    }
}