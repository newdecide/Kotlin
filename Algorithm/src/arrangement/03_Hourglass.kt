package arrangement

// 모래시계 모양으로 배열 채우
fun main(args: Array<String>) {
    var arr = Array(5, { IntArray(5) })
    var v = 1 // 배열 원소
    var m = 3 // 중간값
    var r = 0 // 행
    var c = 0 // 열

    for (r in 0..m) {
        for (c in r..5 - (r + 1)) {
            arr[r][c] = v
            v++
        }
    }
/*
    1	2	3	4	5
    0	6	7	8	0
    0	0	9	0	0
*/


    for (r in m..4) {
        for (c in 4 - r..r) {
            arr[r][c] = v
            v++
        }
    }
/*
    0	10	11	12	0
    13	14	15	16	17
 */

    // 출력
    for (r in 0..4) {
        for (c in 0..4) {
            print("${arr[r][c]}\t")
            if (c == 4) {
                println()
            }
        }
    }
/*
    1	2	3	4	5
    0	6	7	8	0
    0	0	9	0	0
    0	10	11	12	0
    13	14	15	16	17
 */
    println()

    for (r in 0..4) {
        for (c in 0..4) {
            print("${arr[c][r]}\t")
            if (c == 4) {
                println()
            }
        }
    }
/*
    1	0	0	0	13
    2	6	0	10	14
    3	7	9	11	15
    4	8	0	12	16
    5	0	0	0	17
 */
}