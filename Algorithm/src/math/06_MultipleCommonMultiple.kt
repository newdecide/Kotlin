package math

// 06.배수와 공배수
fun main(args: Array<String>) {
    var a = arrayOf(21, 17, 4, 51, 24, 75, 40, 27, 48, 72) // 10개의 정수 데이터
    var cnt = 0 // 공배수 발견시 카운트 확인용
    var i = 0 // 배열 첨자 0~9까지

    do {
        var n3 = a[i] % 3 // 3의 배수
        var n4 = a[i] % 4 // 4의 배수
        var n = n3 + n4 // 2값을 더해도 0이면 3의 배수이면서 4의배수가 된다.
        if (n == 0) {
            cnt++ //3과 4의 공배수 카운트
        }
        if (a[i] % 3 == 0 && a[i] % 4 == 0) {
            println("3과 4의 공배수: ${a[i]}")
        }
        i++ // i가 10이 될 때까지
    } while (i < 10)
    println(cnt)
}