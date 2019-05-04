package Linear

import java.lang.Integer.parseInt

// 09:50~11:15
fun main(args: Array<String>) {

    // 객체 생성
    var staccalc = StackCalc()
    staccalc.array()
}

class StackCalc {
    // 입력배열
    var input = arrayOf('(', '6', '+', '5', ')', '*', '(', '2', '-', '8', ')', '/', '2')
    // 연산자 담은 배열
    var oper = arrayOfNulls<Char>(input.size)

    // 숫자 담는 배열
    var num = arrayOfNulls<Int>(input.size)

    // 결과 값 담는 변수
    var result = 0

    // 스택의 탑 변수
    var top = -1

    // 스택의 크기
    var stacksize = 0

    // 입력데이터

    // 데이터 입력
    fun array() {
        for (i in input.indices) {
            if ((rank(input[i]) != -1)) {
                oper[i] = input[i]
                print(oper[i])
            } else {
                num[i] = parseInt(input[i].toString())
                print(num[i])
            }
        }
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