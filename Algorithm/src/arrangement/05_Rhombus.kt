package arrangement

// 05.마름모 알고리(홀수 수열)
fun main(args: Array<String>) {
    var v = 1 // 배열에 입력 변수
    var m = 2 // 중간 값
    var cl = m // 시작값 2 -> 1 -> 0 -> 1 -> 2
    var cr = m // 끝값 2 -> 3 -> 4 ->3 -> 2
    var a = Array(5, {IntArray(5)})

    for(r in 0..4){
        for( c in cl..cr){ // 1.시작값부터 끝값까지 반복
            a[r][c] = v
            v+=2
        }
        if( r < m ){ // 행이 중간값보다 작으면
            cl-- // 시작값은 1감소
            cr++ // 끝값은 1증가
        } else {
            cl++ // 시작값 1증가
            cr-- // 시작값 1감소
        }
    }

    for(r in 0..4){
        for(c in 0..4){
            print("${a[r][c]}\t")
            if(c == 4){
                println()
            }
        }
    }

/*
    0	0	1	0	0
    0	3	5	7	0
    9	11	13	15	17
    0	19	21	23	0
    0	0	25	0	0
*/
    println()

    for(r in 0..4){
        for(c in 0..4){
            print("${a[c][r]}\t")
            if(c == 4){
                println()
            }
        }
    }
/*
    0	0	9	0	0
    0	3	11	19	0
    1	5	13	21	25
    0	7	15	23	0
    0	0	17	0	0
 */

}