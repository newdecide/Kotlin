package arrangement

// 'ㄹ'자 모양으로 배열 채우기
fun main(args: Array<String>) {
    var i = 0
    var a = Array(5, { IntArray(5) })
    var s = 1 // +, - 스위치 변수
    var c1 = 0
    var c2 = 4
    var temp = 0
    // 스위치 변수로 바꾸기 위한 조건문 사용함
    // c1 < c2 c1부터 c2까지 1씩 증가
    // c1 > c2 c1부터 c2까지 1씩 감소
    for (r in 0..4) {
        for (c in if(c1 < c2){c1..c2} else {c1 downTo c2}) {
            i++ // 1~25까지 배열에 입력
            a[r][c] = i
            // c1 < c2
            // c1, c2는 고정값으로 temp를 통해 값이 바뀜
            // true c1이 1부터 4까지 1씩 증가
            // false c1이 4부터 1까지 1씩 감소
        }
        temp = c1
        c1 = c2
        c2 = temp
        s = -s
    }
    // 'ㄹ'자 배열 불러오기
    for (r in 0..4) {
        for (c in 0..4) {
            print("${a[r][c]}\t")
            if (c == 4) {
                println()
            }
        }
    }
}