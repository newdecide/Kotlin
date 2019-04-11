package arrangement
// 01.열고정 배열
fun main(args: Array<String>) {
    var arr = Array(5, {IntArray(5)})
    var v = 0 // 배열 원소에 저장되는 값
    var c = 0 // 1열
    var r = 0 // 1행

    for(c in 0..4){ // 입력 반복문
        for(r in 0..4){
            v++
            arr[r][c] = v
        }
    }
    for(c in 0..4){ // 배열 출력 반복문
        for(r in 0..4){
            print("${arr[c][r]}\t")
            if(r == 4){
                println()
            }
        }

    }
}