package sequence

import java.util.*

// 1.기본수열(Base sequence)
fun main(args: Array<String>) {
    var sum = 0
    var n = 1

    while (true) {
        sum += n // sum = sum + n
        n++ // n = n + 1
        if (n > 100) break
    }
    println("1~100까지의 합: " + sum)

    var m = 1
    var sum2 = 0

    while (true) {
        sum2 += m * m // sum = sum + m * m
        m++ // m = m + 1
        if (m > 100) break
    }
    println("1~100까지의 제곱의 합: " + sum2)

    var sca: Scanner = Scanner(System.`in`)
    var n1 = sca.nextInt() // 시작값
    var n2 = sca.nextInt() // 종료값

    var s1 = 0 // 입력한 값의 누적값
    var s2 = 0 // 입력한 값의 3배수 제곱의 합

    while (true) {
        s1 = s1 + n1
        if (n1 % 3 == 0) { // 나머지 / 몫
            s2 = s2 + n1 * n1
        }
        n1++
        if (n1 > n2) break
    }

    println("누적값: ${s1}, 3의 배수 제곱의 합 ${s2}")
}