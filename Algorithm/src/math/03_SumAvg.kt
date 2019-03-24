package math

// 통화시간 200초 이상 사용한 사람 들의 시간 합계
// 03.합계와평균
fun main(args: Array<String>) {
    var t = arrayOf( // 통화시간 배열
        100, 90, 80, 100, 85, 100, 95, 75, 100, 88,
        184, 240, 9, 235, 333, 295, 329, 34, 350, 58,
        313, 36, 187, 327, 234, 47, 324, 145, 55, 95,
        282, 148, 88, 213, 91, 182, 283, 227, 156, 217
    )
    var sum = 0
    var n = 0
    var i = 0

    while (true) {
        if (t[i] >= 200) {
            sum += t[i]
            n++
        }
        i++

        if (i >= t.size) break

    }
    var avg = sum / n
    println(t.size)
    println("통화시간 200초 이상 사용한 사람 들의 시간 합계: " + sum)
    println("계수된 사람의 수: " + n)
    println("평균: " + avg)
}