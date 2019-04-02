package math

import java.lang.Math.abs

// 2진수를 10진수로 변환
fun main(args: Array<String>) {
    var binary = arrayOf(1, 1, 1, 1, 0, 1, 1, 0) // 2진수 배열
    var oneComplement = arrayOfNulls<Int>(8) // 1의보수 배열
    var decimal = 0 // 10진수 누적 값
    var SIGN = 1 // 부호 변수

    print("음수인 2진수: ")
    for(k in 1..7){
        print("${binary[k]} ") // 음수 2진수 출력
    }
    println()
    if (binary[0] != 0) { // binary[0]가 0이 아닐때 만 진행 음수구하는 조건문
        SIGN = -1 // 부호 음수로 설정
        var b = 1
        for (k in 7 downTo 1) {
            oneComplement[k] = binary[k] - b // 0은 부호라 제외 1~7 2진수에서 1을 다 뺀다.
            if (binary[k] != 0 || b != 1) { // binary[k]가 0이 아니거나 b가 1이 아니면 b는 0이 된다.
                b = 0
            }
            oneComplement[k] = abs(oneComplement[k]!!) // 음수를 양수로 변함 절대값 적용
            binary[k] = 1 - oneComplement[k]!! // 1-1의보수로 2진수로 변환
        }
        print("1의보수 - 1: ")
        for(k in 1..7){
            print("${oneComplement[k]} ") // 1의보수 출력
        }
        println()
        print("2진수 변환  : ")
        for(k in 1..7){
            print("${binary[k]} ")
        }
        println()
        for (k in 1..7) {
            var t1: Int = Math.pow(2.0, 7.0 - k.toDouble()).toInt() // 2^6 ~ 2^0
            var t2 = binary[k] * t1 // 2진수 1인 것만 제대로 값 계산
            decimal += t2 // t2값 누적
        }
        decimal *= SIGN // 부호 음수로 변형
        println("11110110 -> 십진수로 변환: " + decimal)
    }
}