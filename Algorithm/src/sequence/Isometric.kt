package sequence

fun main(args: Array<String>) {
    // Isometric sequence
    // 2.등차 수열
    var A = 2 // 수열의 초항(첫항)
    var D = 6 // 수열의 공차 = 6
    var S = A // 200번째항까지의 합 처음 값은 2가 담겨 있다.
    var N = 2 // 등차 수열의 항 순서
    var An = 0
    var i = 1 // 10개씩 카운트 세는 변수
    var j = 10 // 10개씩 프린트하고 줄바꾸는 변수
    print("${S} ")

    while (true) {
        // A2 = A1 + D, A3 = A2 + D
        // An = An-1 + D
        An = A + ((N - 1) * D) // 2 - 1 = 1*6 = 2 + 6 =8
        print("${An} ")

        i++
        if(i == j) {
            println(" ")
            j += 10
        }
        S = S + An
        N = N + 1
        if (N > 200) break
    }
    println(" ")
    println("공차가 6인 등차수열 1~200까지의 합은? " + S)

}