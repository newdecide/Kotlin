package practicalapplicationalgorithm

// 7:44~
// 요일계산 알고리즘
fun main(args: Array<String>) {
    val MD = arrayListOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) // 1월 ~ 12월 일수
    val WD = arrayListOf("월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일") // 월요일 ~ 일요일
    val M = 3 // 3월로 가정
    val D = 8 // 8일로 가정

    if (D == 0) return

    var NAL = 0 // 입력한 날짜와 기준일인 1월 1일 사이의 차이를 날로 나타낸 수
    var DAL = M - 1 // 입력한 날짜의 달과 기준일인 1월 사이의 개월 수 3월이 2번째 배열에 있어서 M-1
    if (DAL != 0) {
        var i = 0
        do {
            NAL += MD[i]
            i++
        } while (i <= (DAL-1))
    }
    NAL += (D - 1) // 전체의 날 수를 1주일 단위로 정산
    var V = NAL / 7
    V *= 7
    var W = NAL - V // 날을 일주일 단위로 정산하였을 때 남는 날 수
    var X = W + 3 // 1월 1일이 수요일이라는 사실을 W에 보정하여 계산한 요일
    if( X > 7){ // X가 7을 넘으면 요일 0으로 환산
        X -= 7
    }
    println("${M}월 ${D}일 => ${WD[X-2]}")

}