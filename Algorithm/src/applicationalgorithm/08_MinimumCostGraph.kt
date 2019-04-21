package applicationalgorithm

// 17:20  ~ 17:51
// 최소비용그래프
fun main(args: Array<String>) {
    val C = arrayListOf(4, 2, 10, 7, 12, 15, 18, 20, 9, 13, 1) // 간선의 가중치
    val Cycle = arrayListOf(0, 0, 0, 0, 0, 1, 0) // 6번째 사이클 발생
    val N = 7 // 노드의 수
    val E = 11 // 배열의 최대값
    var Temp = 0 // 스왑시 담아둘 변수

    println("최소비용그래프 간선 값을 담아둔 배열")
    for(i in 0..10) print("${C[i]}\t") // 정렬 안된 간선 가중치 출력
    for(i in 0..E-2) { // 0~9까지
        for(j in i+1..E-1) { // 1~10까지
            if (C[i] > C[j]) { // 간선 값들의 오름차순 정렬 스왑
                Temp = C[i]
                C[i] = C[j]
                C[j] = Temp
            }
        }
    }
    println()
    println("간선의 가중치 오름차순 정렬")
    for(i in 0..10) print("${C[i]}\t")

    var L = 1 // 최소비용 그래프에 참여한 간선의 개수
    var K = 0 // 반복용 변수
    var T = 0 // 최소비용 그래프에 참여한 간선들의 가중치 총합

    println("\n최소비용")
    while (L <= (N-1)){ // L이 6보다 작을 때까지
        if(Cycle[K] == 0) { // 사일클 확인: 사이클이 0이면
            T += C[K] // 간선 가중치 값을 더해라
            L++ // while문 나가기 위한 조건문
            print("${C[K]}\t") // 최소비용 원소 출력
        }
        K++ // K는 계속 1씩 증가해야된다. 6번째 사이클이 1인 경우 다음 값으로 넘어간다.
    }

    print("\n최소비용 가중치 총합 : " + T)
}