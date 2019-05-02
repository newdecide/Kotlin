package Linear

interface Stack<T> {
    val isEmpty: Boolean
    fun push(item: Char)
    fun pop(): Char
    fun delete()
    fun peek(): Char

}

class ArrayStack(stackSize: Int) : Stack<Any?> {
    private var top: Int = 0 // top 변수
    private var stackSize: Int = 0 // 스택의 크기
    private val itemArray: CharArray // 스택 담을 배열

    override val isEmpty: Boolean get(){ // 스택이 비어있음
        return (top == -1)
    }

    val isFull: Boolean get() {
        return (top == stackSize - 1) // 스택이 가득 참
    }

    init { // 초기
        this.top = -1
        this.stackSize = stackSize
        this.itemArray = CharArray(this.stackSize)
    }

    override fun push(item: Char) {
        if (isFull) { // 아이템을 넣을 공간이 없으면
            println("스택이 가득 찼습니다.")
        } else {
            itemArray[++top] = item // 스택에 아이템 추가
        }
    }

    override fun pop(): Char {
        if (isEmpty) { // 더이상 꺼낼 아이템이 없으면
            println("스택이 비어 있습니다.")
            return 0.toChar()
        } else {
            return itemArray[top--] // top아이템을 꺼낸다.
        }
    }

    override fun delete() {
        if (isEmpty) { // 더이상 삭제할 아이템이 없으면
            println("삭제할 요소가 존재하지 않음")
        } else {
            top--
        }
    }

    override fun peek(): Char {
        if (isEmpty) {
            println("스택이 비어 있습니다.")
        } else {
            return itemArray[top]
        }
        return 0.toChar()
    }

    fun printStack() {
        if (isEmpty) {
            println("<<Stack>>")
        } else {
            println("<<Stack>>")
            for (i in top downTo -1 + 1) {
                println(itemArray[i])
            }
            println()
        }
    }
}

fun main(args: Array<String>) {
    var stackSize = 5
    var deleteItem: Char
    var arraystack = ArrayStack(stackSize)

    arraystack.push('A')
    arraystack.printStack()

    arraystack.push('B')
    arraystack.printStack()

    arraystack.push('C')
    arraystack.printStack()

    deleteItem = arraystack.pop()
    if(!deleteItem.equals(0)){
        println("delete Item : ${deleteItem}")
    }
    arraystack.printStack()
}