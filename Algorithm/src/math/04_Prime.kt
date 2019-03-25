package math

// 04.소수판별
fun main(args: Array<String>) {
    var p = 2 // 초기값은 소수 2로 설정, 가장 큰 소수 보관 변수
    var n = 3 // 자연수 3부터 100까지 소수 판별

    while (true) {
        var tmp: Double = Math.sqrt(n.toDouble()) // n의 제곱근을 tmp에 저장한다.
        var m = tmp.toInt()

        for (i in 2..m) {
            var r = n % i // n을 2부터 m까지 나누어 소수인지 점검
            if (r == 0) { // 나누어 떨어지면 소수가 아니다.
                break
            }
            if (i == m) { // 새로운 소수 발견 p에 n을 갱신한다.
                p = n
                println("> " + p)
            }
        }
        n++
        if (n > 100) break // 자연수 3~100까지 판별후 종료
    }

    println("100이하의 소수 중 가장 큰 소수는? :" + p)
}