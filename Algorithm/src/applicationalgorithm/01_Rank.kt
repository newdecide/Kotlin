package applicationalgorithm

// 매출액 석차 구하기
fun main(args: Array<String>) {
    var A = mutableListOf<Int>(1000, 900, 1200, 800, 1500, 2000) // 매출액을 저장하는 배열
    var R = mutableListOf<Int>(1,1,1,1,1,1) // 석차를 저장하는 배열

    for (i in 0..5) {
        for (j in 0..5) {
            if (A[i] < A[j]) { // 매출액이 큰 대리점이 존재하면
                R[i]++ // 석차를 1만큼 증가시킴
            }
        }
    }
    println("대리점 매출 순위")
    for (i in 0..5) {
        println("${A[i]} : ${R[i]}위") // 결과 출력
    }
}