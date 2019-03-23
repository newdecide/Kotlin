package math
// 02.최솟값, 최대값
fun main(args: Array<String>) {
    var m = 0
    var i = 0

    var eng = arrayOf(100, 90, 80, 100, 85, 100, 95, 75, 100, 88)
    var math = arrayOf(80, 75, 80, 100, 95, 90, 80, 95, 97, 92)

    // 영어점수가 100점인 사람 중에 수학 점수가 높은 사람 찾는 알고리즘

    while (true) {
        if(eng[i] == 100) {
            if(math[i] > m){ // m은 0으로 m보다 크면 최대값을 담게 된다.
                m = math[i]
            }
        }
        i++

        if(i > 9) break // 배열의 마지막 첨자 도착하면 반복 종료

    }
    println("영어가 100점인 사람 중에 수학 최고점 학생의 점수는? " + m)

    for( i in 0..eng.size-1) { // size는 10이므로 -1해서 9까지 하고 종료
        if (eng[i] == 100) {
            if (math[i] < m) { // 처음 m은 100으로 m보다 작으면 최솟값을 담게 된다.
                m = math[i]
            }
        }
    }
    println("영어가 100점인 사람 중에 수학 점수가 낮은 학생의 점수는? " + m)
}