package math

// 1의보수와 2의보수
fun main(args: Array<String>) {
    var b = arrayListOf<Int>(0, 1, 0, 1, 0) // 2진수 배열
    // arrayOfNulls<Ibt>눈 배열의 크기만 선언한다.
    var o = arrayOfNulls<Int>(5) // 1의보수 저장하는 배열
    var t = arrayOfNulls<Int>(5) // 2의보수 저장하는 배열
    var i = 0 // 0~4까지 배열의 위치 변수

    do {
        o[i] = 1 - b[i] // 1의 보수 처리: b[0]~b[4] 2진수를 1에서 뺀다.
        i++
    } while (i < 5) // i가 5가되면 종료
    print("01010의 1의 보수는 = ")
    for(i in 0..4){ //  1의 보수 배열 반복문.
        print(o[i])
    }
    println()

    i = 4 // 배열의 끝부터 시작하도록 세팅
    var c = 1 // 올림수 2의보수 작업
    do {
        t[i] = 1
        // o[i]와 c가
        if (o[i] == c) // o[4] == c (1 == 1 true)
            t[i] = 0 // t[4] = 0이 들어간다.

        c *= o[i]!! // 결과 값이 1,0이 나온다.
        i--
    } while (i >= 0) // i가 0이되면 종료

    print("01010의 2의 보수는 = ")
    for (i in 0..4) {
        print(t[i])
    }
    println("")
    println("1의 보수 10101 + 1을 더하면 2의보수가 된다.")
}