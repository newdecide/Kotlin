package practicalapplicationalgorithm

// 7:15 ~ 7:42
// 화폐계수 알고리즘
fun main(args: Array<String>) {
    var cnt = MutableList (9, {i -> i}) // 단위 화폐의 매수
    var total = MutableList(9, {i -> i}) // 단위 화폐의 합계
    var C = 532263 // 화폐 금액
    var R = C // 남은 돈 변수
    var M = 10000 // 초기 시작 변수
    var SW = 1 // 초기값

    for(k in 0..8){
        cnt[k] = R/M // 화폐금액 나눈 몫
        total[k] += cnt[k] // 단위별 화폐 카운트 추가
        R = R-(cnt[k]*M) // 화폐금액에서 몫과 화폐단위 곱한 값을 뺀다.

        if( SW == 1) { // 1이면 10000원, 1000원, 100원, 10원, 1원
            M = M / 2 // 5000원 -> 500원 -> 50원 -> 5원
            SW = 0
        } else { // 0이면 5000원, 500원, 50원, 5원
            M = M / 5 // 1000원 -> 100원 -> 10원 -> 1원
            SW = 1
        }
    }

    println("화폐계수")
    println("금액: ${C}원")
    var i = 0
    for(i in 0..8) {
        when (i) {
            0 -> println("10000원: ${cnt[i]}")
            1 -> println("5000원: ${cnt[i]}")
            2 -> println("1000원: ${cnt[i]}")
            3 -> println("500원: ${cnt[i]}")
            4 -> println("100원: ${cnt[i]}")
            5 -> println("50원: ${cnt[i]}")
            6 -> println("10원: ${cnt[i]}")
            7 -> println("5원: ${cnt[i]}")
            8 -> println("1원: ${cnt[i]}")
        }
    }
}