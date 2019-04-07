package arrangement

// 삼각형 모양으로 배열 채우기
fun main(args: Array<String>) {
    var arr = Array(5, {IntArray(5)})
    var v = 0 // 배열 원소
    var r = 0 // 행
    var c = 0 // 열

    // 0~4
    // 1~4
    // 2~4
    // 3~4
    // 4~4
    // 열고정 행변화 배열
    for(r in 0..4){
        for(c in r..4){
            v++
            arr[r][c]=v
        }
    }

    for(r in 0..4){
        for(c in 0..4){
            print("${arr[r][c]}\t")
            if(c == 4){
                println()
            }
        }
    }

    println()

    for(r in 0..4){
        for(c in 0..4){
            print("${arr[c][r]}\t")
            if(c == 4){
                println()
            }
        }
    }
}