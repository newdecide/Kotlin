package Linear

class StackNode{
    internal var item: Char = ' '
    internal var next: StackNode? = null
}

class LinkedStack: Stack<Any?> {
    internal var top: StackNode?
    override var isEmpty:Boolean = false
        get() {
            return (top == null)
        }
    init{
        this.top = null
    }
    override fun push(item: Char){
        val node = StackNode()
        node.item = item
        node.next = top
        top = node
    }

    override fun pop(): Char {
        if(!isEmpty){
            val node = top
            top = node!!.next
            return node!!.item
        } else {
            println("스택이 비어있습니다.")
            return 0.toChar()
        }
    }

    override fun delete() {
        if(isEmpty){
            println("스택이 비어있습니다.")
        } else {
            top = top!!.next
        }
    }
    override fun peek():Char {
        if (isEmpty)
        {
            println("스택이 비어있습니다.")
            return 0.toChar()
        }
        else
        {
            return top!!.item
        }
    }
    fun printStack() {
        if (isEmpty) {
            println("스택이 비어있습니다.")
        } else {
            var node = top
            println("<<Stack>>")
            while (node!!.next != null)
            {
                println(node.item)
                node = node.next
            }
            println(node.item)
            println()
        }
    }
}

fun main(args: Array<String>) {
    var deletedItem: Char
    var linkedstack = LinkedStack()
    linkedstack.push('A')
    linkedstack.printStack()

    linkedstack.push('B')
    linkedstack.printStack()

    linkedstack.push('C')
    linkedstack.printStack()

    deletedItem = linkedstack.pop()
    if(!deletedItem.equals(0)){
        println("deleted Ited : ${deletedItem}")
    }
    linkedstack.printStack()
}