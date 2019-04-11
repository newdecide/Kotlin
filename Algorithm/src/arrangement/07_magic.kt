package arrangement

// 07.마방진
fun main(args: Array<String>) {
    var m = Array(5, { IntArray(5) }) // 5*5 2차원 배열 생성
    var r = 0 // 시작값
    var c = 2 // 중앙값

    for (n in 1..25) {
        m[r][c] = n // m[1][3]= 1 첫번째 값 입력
        var nr = r - 1 // 행 감소
        var nc = c + 1 // 열 증가
        if (nr == -1) { // nr이 -1과 같으면 nr은 5행으로 이동
            nr = 4
        }
        if (nc == 5) { // nc가 5와 같으면 nc는 1열로 이동
            nc = 0
        }

        if (m[nr][nc] == 0) { // m[nr][nc]가 0이면 할당이 안 된 것이므로 r에 nr값과 c에 nc값을 배열에 넣는다. 다음행으로 이동
            r = nr
            c = nc
        } else {
            r++
        }
    }

    for (nr in 0 until 5) {
        for (nc in 0 until 5) {
            print("${m[nr][nc]}\t")
            if (nc == 4) {
                println()
            }
        }
    }

/*
    17	24	1	8	15
    23	5	7	14	16
    4	6	13	20	22
    10	12	19	21	3
    11	18	0	2	9
*/

    println()

    for (nr in 0 until 5) {
        for (nc in 0 until 5) {
            print("${m[nc][nr]}\t")
            if (nc == 4) {
                println()
            }
        }
    }
/*
    17	23	4	10	11
    24	5	6	12	18
    1	7	13	19	0
    8	14	20	21	2
    15	16	22	3	9
 */



}