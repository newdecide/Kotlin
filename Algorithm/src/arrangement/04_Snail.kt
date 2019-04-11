package arrangement

// 04.달팽이 배열
fun main(args: Array<String>) {
    var arr = Array(5,{IntArray(5)})
    var n = 0 // 1~25까지 증가변수
    var s = 1 // 짝짝, 홀홀 스위치 변수
    var i = 0 // 행
    var j = -1 // 열
    var k = 5 // 5~1까지 1씩 감소

    while(true) {
        for (p in 1..k) {
            n++
            j += s
            arr[i][j] = n
        }
        k--
        if (k <= 0) break
        for (p in 1..k) {
            n++
            i += s
            arr[i][j] = n
        }

        s = -s
    }

    for(i in 0..4){
        for(j in 0..4){
            print("${arr[i][j]}\t")
            if(j == 4)
                println()
        }
    }
/*
    ---------------->
  /\1	2	3	4	5 |
  | 16	17	18	19	6 |
  | 15	24	25	20	7 |
  | 14	23	22	21	8 |
  | 13	12	11	10	9 \/
    <----------------
 */
    println()

    for(i in 0..4){
        for(j in 0..4){
            print("${arr[j][i]}\t")
            if(j == 4)
                println()
        }
    }

/*
    1	16	15	14	13
    2	17	24	23	12
    3	18	25	22	11
    4	19	20	21	10
    5	6	7	8	9
 */

    println()

    for(i in 0..4){
        for(j in 0..4){
            print("${arr[4-i][4-j]}\t")
            if(j == 4)
                println()
        }
    }

/*
    9	10	11	12	13
    8	21	22	23	14
    7	20	25	24	15
    6	19	18	17	16
    5	4	3	2	1
 */

    println()

    for(i in 0..4){
        for(j in 0..4){
            print("${arr[4-j][4-i]}\t")
            if(j == 4)
                println()
        }
    }
/*
    9	8	7	6	5
    10	21	20	19	4
    11	22	25	18	3
    12	23	24	17	2
    13	14	15	16	1
 */
}