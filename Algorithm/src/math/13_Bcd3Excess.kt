package math

// BCD 코드와 3초과 코드의 변
fun main(args: Array<String>) {
    var binary = arrayOf(0, 1, 1, 1) // 2진수 배열
    var excess = arrayOfNulls<Int>(4) // 3초과 코드 담는 배열
    var threeplus = arrayOf(0, 0, 1, 1) // 3 더하는 배열
    var carry = 0 // 올림 변수

    for(k in 3 downTo 0){ // 2^0 위치부터 더해서 계산한다.
        var s = binary[k] + threeplus[k] + carry // 2진수 덧셈 3더하는 배
        if(s > 1) { // s값이 2가나오면 올림수 발생
            excess[k] = s % 2 // 2는 0으로 바꾸고 carry 올림수 저장
            carry = 1 // 올림수 1저장
        } else {
            excess[k] = s // 1이거나 0이면 올림수 발생하지 않으므로 carry 올림수 없음
            carry = 0 // 올림수 없다.
        }
    }
    print("3초과 코드 결과: ")
    for (k in 0..3)
        print(excess[k]) // 순서대로 출력
    println()
    println("이진수: 0111(3초과 코드) -> 십진수: 10(1010)")
}