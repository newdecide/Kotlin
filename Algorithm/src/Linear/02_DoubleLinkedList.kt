package Linear

import java.util.*
// 이중 연결 리스트
// 장점: 노드를 탐색하는 방향이 양쪽으로 가능하다. 단일연결리스트는 맨끝의 데이터를 가져올때 처음노드부터 탐색한다. 많은 연산을 필요로함
// 이중 연결 리스트는 뒤부터 탐색을 할 수 있다.
// 단점: 포인터를 2군대 두어야 한다. 이전 노드를 지정하기 위한 변수를 하나 더 사용해야 한다. 메모리를 더 많이 사용한다.
// 13:24~14:25

class MyDobulyLinkedList {
    private var head: Node? // 리스트의 시작 변수
    private var tail: Node? // 리스트의 끝 변수
    private var size: Int // 리스트의 사이

    init {
        this.head = null
        this.tail = null
        this.size = 0
    }

    private inner class Node internal constructor(data: Any) {
        // 단일 연결 리스트와의 차이점은
        // 이전 노드를 기록할 수 있는 변수를 가지고 있다.
        internal var nextNode: Node?
        internal var prevNode: Node?
        internal var data: Any

        // 변수 초기 값 세팅
        init {
            this.nextNode = null
            this.prevNode = null
            this.data = data
        }
    }


    fun addFirst(data: Any) {
        var newNode = Node(data)

        if (head != null) {
            // 기존노드가 있음
            newNode.nextNode = head
            head!!.prevNode = newNode
        }

        head = newNode
        if (head!!.nextNode == null) {
            tail = head
        }
        size++
    }

    fun addLast(data: Any){
        if(size == 0){
            addFirst(data)
        } else {
            var newNode = Node(data)
            tail!!.nextNode = newNode
            newNode.prevNode = tail
            tail = newNode
            size++
        }
    }

    fun add(index: Int, data: Any){
        if(index == 0){
            addFirst(data)
        } else if( index == size -1){
            addLast(data)
        } else {
            var newNode = Node(data)
            var prevNode = getNode(index -1)
            var nextNode = prevNode!!.nextNode

            // 추가된 노드의 전후 설정
            newNode.prevNode = prevNode
            newNode.nextNode = nextNode

            // 이전 노드의 전후 설정
            prevNode!!.nextNode = newNode
            // 다음 노드의 전후 설정
            nextNode!!.prevNode = newNode

            size++
        }
    }

    private fun getNode(index : Int): Node?{
        if(index < size / 2){
            var node = head
            for(i in 0 until index){
                node = node!!.nextNode
            }
            return node
        } else {
            var node = tail
            for(i in size-1 downTo 0){
                node = node!!.prevNode
            }
            return node
        }
    }

    fun removeFirst(): Any?{
        if(size == 0){
            return null
        }
        var removeNode = head
        head = null
        head = removeNode!!.nextNode
        head!!.prevNode = null
        size--

        return removeNode!!.data
    }

    fun removeLast(): Any? {
        if(size == 0){
            return null
        }

        var removeNode = tail
        tail = null
        tail = removeNode!!.prevNode
        tail!!.nextNode = null
        size--

        return removeNode!!.data
    }

    override fun toString(): String {
        var result = StringBuffer("[")
        if(size != 0){
            var node = head
            result.append(node!!.data)
            while(node!!.nextNode != null){
                node = node.nextNode
                result.append(", ")
                result.append(node!!.data)
            }
        }
        result.append("]")
        return result.toString()
    }


    // 멤버변수로 인덱스를 받아 인덱스의 데이터를 삭제
    fun remove(index: Int): Any?{
        if(size == 0){
            return null
        }

        if(index == 0){
            return removeFirst()
        }else if(index == size-1){
            return removeLast()
        } else {
            var removeNode = getNode(index)
            var prevNode = removeNode!!.prevNode
            var nextNode = removeNode!!.nextNode

            // 이전 노드 전후 설정
            prevNode!!.nextNode = nextNode

            // 다음 노드 전후 설
            nextNode!!.prevNode = prevNode

            size--

            return removeNode!!.data
        }
    }
}

fun main(args: Array<String>) {
    var list = MyDobulyLinkedList()
    list.addFirst(40) // 비어있는 리스트에 삽입
    list.addFirst(30) // 리스트의 앞에 삽입
    list.addFirst(20) // 리스트의 앞에 삽입
    list.addFirst(10) // 리스트의 앞에 삽입

    // 리스트 배열을 불러온다.
    println(list.toString()) // 10, 20, 30, 40

    // 2번째 인덱스에 25를 삽입한다.
    list.add(2, 25)
    println(list.toString()) // 10, 20, 25, 30, 40

    // 맨 끝에 데이터를 삽입한다.
    list.addLast(50)
    println(list.toString()) // 10, 20, 25, 30, 40, 50

    // 첫번째 데이터를 삭제한다.
    list.removeFirst()
    println(list.toString()) // 20, 25, 30, 40, 50

    // 마지막 데이터를 삭제한다.
    list.removeLast()
    println(list.toString()) // 20, 25, 30, 40

    // 1번째 인덱스의 데이터를 삭제한다.
    list.remove(1)
    println(list.toString()) // 20, 30, 40


}