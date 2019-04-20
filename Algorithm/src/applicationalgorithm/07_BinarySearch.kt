package applicationalgorithm

import java.util.*

// 이분검색
// 5:24~6:24
// 이분검색을 하기위해선 배열이 정렬이 되어 있어야 한다.
fun BS_Seart(Array :MutableList<Int>, L: Int, H:Int, K:Int): Any {
    var L2 = L // 첫번째 배열
    var H2 = H // 마지막째 배열

    for(i in 0..99){
        if(L2 > H2){ // H2가 L2보다 작으면 안된다.
            return "배열에 존재하지 않습니다."
        }
        var M = (L2+H2) / 2 // 중간값: 원소들의 합의 절반 값
        if(Array[M] > K){ // 중간값이 키값보다 크면 중간값보다 아래만 검색
            H2 = M - 1 // 중간값 -1 배열로 변경
            continue
        } else if ( Array[M] < K){ // 중간값이 키값보다 작으면 중간값 위만 검색
            L2 = M + 1 // 중간값 +1 배열로 변경
            continue
        } else
            return M
    }
    return Array[H2]
}

fun main(args: Array<String>) {

    var K = Scanner(System.`in`) // 검색할 위치
    var Array = mutableListOf<Int>(14, 17, 20, 22, 26, 48, 50, 90, 95, 100) // 배열

    print("배열: ")
    println("14, 17, 20, 22, 26, 48, 50, 90, 95, 100")
    print("어떤 값을 찾고 있나요? ")
    print("(0~9까지의 배열): ${BS_Seart(Array, 0, 9, K.nextInt())}번째에 위치함.")

}