package sequence

fun main(args: Array<String>) {
    /*
    *  8. 교행 분수 수열
    *  ex) 1 / 2 * 3 - 2 / 3 * 4 + 3 / 4 * 5 ... - 48 / 49 * 50 + 49 / 50 * 51
    * */

    var K: Int = 0 // 1씩 커지는 변수 초기화
    var S: Double = 0.0 // 더블형 소수점 결과값 최기화
    var SW = 0
    var L: Double = 0.0
    var j = 5
    // + ,- 교차되면서 진행 된다.
    print("+")
    do {
        K++
        L = K.toDouble() / ((K + 1) * (K + 2))
        print("${K} / (${K + 1} * ${K + 2}) ")
        if (SW == 0) {
            S += L
            SW = 1
            if (K == j) {
                println("")
                j += 5
            }
            if(K !=49 ) print("-") // if문은 마지막에 - 빼기 위한 장치
        } else {
            S -= L
            SW = 0
            if (K == j) {
                println("")
                j += 5
            }
            print("+")
        }
    } while (K != 49)
    println("")
    println("교행 분수 의 누적 값: " + S)
}