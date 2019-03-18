package sequence

fun main(args: Array<String>) {
    // 6.제곱의 합
    // (100 * 1)^2 = 100
    // 1씩 감소하고 1씩 증가하여 합이 101이 나오는 수의 제곱 값

    var A = 0 // 1~100까지 증가하는 항
    var B = 101 // 100~1까지 감소하는 항
    var S = 0 // S(합)에 C를 누적한다.
    var C = 0 // 변수 A와 B를 곱하여 C에 저장한다.

    do {
        A++
//        B = 101 - A (B--와 동일한 값이 나옴.)
        B--
        C = A * B
        println("(${B} * ${A})^2 = ${C}")
        S += C
    } while (A < 100)
    println("제곱의 합 누적 값"+ S)
}