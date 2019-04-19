package applicationalgorithm

// 퀵소트 : 평균속도 O(nlogn) 최악 n^2
// 03:30~ 17:13 1시간 43분

fun QSORT( E: MutableList<Int>, L: Int, R: Int){ // 멤버변수는 배열, 왼쪽 값과 오른쪽 값
    var Temp = 0
    if( L >= R) return
    var Pivot = E[L] // pivot값 맨 왼쪽 값
    var i = L+1 // 맨 왼쪽 값은 고정값이므로 다음 숫자부터 정렬
    var j = R // 오른쪽 값부터 왼쪽으로 이동

    // 1단계 정렬
    do{
        while(Pivot > E[i] && i < R) i++ // pivot보다 작은 경우는 건너가고 큰 경우 멈춘다.
        while(Pivot < E[j] && j > L) j-- // pivot보다 큰 경우는 건너나고 작거나 같은 경우 멈춘다.
        if( i >= j) break // 왼쪽 값이 오른쪽값보다 크거나 같으면 종룟
        // 1차적으로 피벗값 기준 작은 값은 왼쪽으로 이동 큰 값은 오른쪽으로 정렬
        Temp = E[i]
        E[i] = E[j]
        E[j] = Temp
    } while(i <= j) // i가 j보다 작거나 같을 때까지 반복

    // 2단계 정렬
    Temp = E[j]
    E[j] = E[L]
    E[L] = Temp

    // 재귀호출
    QSORT(E, L, j-1) // 피벗값 왼쪽 정렬 : 왼쪽 값부터 R이 j-1까지 퀵정렬 실행
    QSORT(E, j+1 , R) // 피벗값 오른쪽 정렬 : 오른쪽 값부터 j+1부터 R까지 퀵정렬 실행
}

fun main(args: Array<String>) {
    var E = mutableListOf(26, 14, 100, 95, 22, 17, 48, 20, 50, 90) // 정렬할 배열

    println("퀵소트 정렬 전 출력")
    for(i in 0..9) {
        print("${E[i]}\t")
    }
    println()

    QSORT(E, 0 , 9)
    println("퀵소트 정렬 후 출력")
    for(i in 0..9){
        print("${E[i]}\t")
    }

}