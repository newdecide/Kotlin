package practicalapplicationalgorithm

// 12:00~12:47
// 은행이자 알고리즘
fun main(args: Array<String>) {
    // 이자율
    val R = 0.05 // 이자율 5%
    // 원금
    val M = 100000
    // 총 거치기간
    val Y = 5

    var K : Double = 1.0 // 연간 이자
    var i = 1 // 연단위
    var T : Double // 이자 합한 금액
    var I = 0 // 이자금액 변수
    do {
        K *= (1+R)
        T = M*K // 원금 * 연간이자율
        I = T.toInt()-100000 // 원금을 뺀 이자금액
        println("${i}년 => ${T.toInt()}원, 이자금액 => ${I}")
        i++ // 연도 증가
    }while (i <= Y) // 5년까지의 이자를 합한 금액
}