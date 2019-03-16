package sequence

fun main(args: Array<String>) {
    // 결과물 : 2, 6, 18, 54, 162, 486 ...

    // 3.등비수열(각항의 곱 차이)
    var A :Long= 2 // 수열의 초항
    var R :Long = 3 // 수열의 공비
    var S :Long = A // 1수열의 합보관 변수
    var N :Long = 2 // 등비수열의 항순서, 2부터 시작
    var i = 1 // 1씩 증가하는 변수
    var j = 10 // 10번째가 되면 줄바꿔주는 항
    print("${S} ") // 등비수열 첫항
    while (true) {
            i++
            A *= R // A = A * R
            print("${A} ") // 등비수열 둘째항부터
            S += A // S = S * A
            if(i == j){
                println("")
                j += 10
            }
        N++
        if (N > 40) break
        if (N == 40L) {
            println("")
            print("1~40 등비수열의 합: " + S)
        }
    }
}