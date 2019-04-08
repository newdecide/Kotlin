package arrangement

// 삼각형 모양으로 배열 채우기
fun main(args: Array<String>) {
    var arr = Array(5, {IntArray(5)})
    var v = 0 // 배열 원소
    var r = 0 // 행
    var c = 0 // 열

    // 열고정 행변화 배열
    for(r in 0..4){
        for(c in r..4){
            v++
            arr[r][c]=v
        }
    }

/*
    1	2	3	4	5
    0	6	7	8	9
    0	0	10	11	12
    0	0	0	13	14
    0	0	0	0	15
*/
    for(r in 0..4){
        for(c in 0..4){
            print("${arr[r][c]}\t")
            if(c == 4){
                println()
            }
        }
    }

    println()

/*
    1	0	0	0	0
    2	6	0	0	0
    3	7	10	0	0
    4	8	11	13	0
    5	9	12	14	15
*/
    for(r in 0..4){
        for(c in 0..4){
            print("${arr[c][r]}\t")
            if(c == 4){
                println()
            }
        }
    }

    println()
/*
    5	4	3	2	1
    9	8	7	6	0
    12	11	10	0	0
    14	13	0	0	0
    15	0	0	0	0
 */

    for(r in 0..4){
        for(c in 0..4){
            print("${arr[r][4-c]}\t")
            if(c == 4){
                println()
            }
        }
    }

    println()
/*
    0	0	0	0	1
    0	0	0	6	2
    0	0	10	7	3
    0	13	11	8	4
    15	14	12	9	5
 */
    for(r in 0..4){
        for(c in 0..4){
            print("${arr[4-c][r]}\t")
            if(c == 4){
                println()
            }
        }
    }
}