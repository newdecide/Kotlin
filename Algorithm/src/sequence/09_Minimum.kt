package sequence

// 최솟값 구하는 알고리즘
fun main(args: Array<String>) {
    var a = arrayOf(60, 50, 70, 40, 80, 20, 90, 10) // 8가지 최솟값 확인할 배열
    var n = 0 // 인덱스 변수
    var MIN = 9999 // 최솟값 변수

    for( n in 0..7){
        if (MIN > a[n]) { // MIN이 a[n] 보다 크면 MIN에 a[n]의 값을 넣는다.
            MIN = a[n] // 최솟값 변경 소스
            println("최솟값 변경(${n+1}): " + MIN) // n이 0이므로 1을 더해서 몇번 변경되는지 알려준다.
        }
    }
    println("(for문) 최솟값은? "+  MIN)

    while(true){
        if (MIN > a[n]) {
            MIN = a[n]
        }
        n++
        if(n > 7) break
    }
    println("(while문) 최솟값은? "+  MIN)
}