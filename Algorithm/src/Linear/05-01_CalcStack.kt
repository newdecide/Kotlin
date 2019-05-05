package Linear

import java.lang.StringBuilder
import java.util.Stack

// 09:50~11:15
// 18:25~10:30
fun main(args: Array<String>) {
    var staccal = StackCal()

    staccal.calc()

}

class StackCal {

    fun calc() {
        // 입력배열 아래처럼 입력할 수 있고 string 데이터를 변환하는 것이 좋다.
        //        var input = arrayOf('(', '6', '+', '5', ')', '*', '(', '2', '-', '8', ')', '/', '2')
        var text = "(6+5)*(2-8)/2" // String 데이터
        println("중위표기법: "+text)
        var input = text.toCharArray() // CharArray 변환
        var stack = Stack<Char>() // 스택 배열 추가
        var sb = StringBuilder()
        // 후위표기법 변환
        for (i in input.indices) {
            var p = rank(input[i]) // i번째 배열의 우선순위
            when (input[i]) {
                '+', '-', '*', '/' -> { // 연산자가 있으면
                    while (!stack.isEmpty() && rank(stack.peek()) >= p) { // i번째 데이터가 우선순위가 같거나 높으면
                        sb.append(stack.pop()) // 데이터를 꺼낸다.
                    }
                    stack.push(input[i]) // push로 스택에 넣는다.
                }
                '(' -> { // '('을 만나면 푸시를 진행.
                    stack.push(input[i]) // push로 스택에 넣는다.
                }
                ')' -> {
                    while (!stack.isEmpty() && stack.peek() != '(') { // 스택에서 '('를 만나기 전까지 pop()진행한다.
                        sb.append(stack.pop())
                    }
                    stack.pop()
                }
                else -> sb.append(input[i]) // 스택에서 추가한다.
            }

        }

        while (!stack.isEmpty()) { //스택이 비어있지 않으면 꺼내라
            sb.append(stack.pop())
        }
        println("후위표기법: "+sb.toString())

        var postfix = sb.toString()

        // char 배열로 변환
        var char = postfix.toCharArray()
        var stackInt = Stack<Int>()

        var cal1 = 0
        var cal2 = 0
        var cal3 = 0
        var cal4 = 0
        for (i in char.indices) {
            if (char[i] == '+') {
                stackInt.push(char[i - 2].toString().toInt() + char[i - 1].toString().toInt())
                cal1 = stackInt.pop()
            } else if (char[i] == '-') {
                stackInt.push(char[i - 2].toString().toInt() - char[i - 1].toString().toInt())
                cal2 = stackInt.pop()
            } else if (char[i] == '*') {
                stackInt.push(cal1 * cal2)
                cal3 = stackInt.pop()
            } else if (char[i] == '/') {
                stackInt.push(cal3 / char[i - 1].toString().toInt())
                cal4 = stackInt.pop()
            }
        }

        print("ㄴ스택 연산 결과: "+cal4)
    }

    // 우선순위 구분 코드
    fun rank(ch: Char): Int {
        when (ch) {
            '*', '/' -> return 2
            '+', '-' -> return 1
            '(', ')' -> return 0
            else -> return -1
        }
    }
}