package sequence

fun main(args: Array<String>) {
    // 4.피보나치 수열 (fivonacci sequeance)
    // N = 보관하는 변수
    // F = 자연수 N에 대한 누승(Factorial) 보관하는 변수
    // S = 자연수 누승의 합 보관.
    // 1, 1은 규칙에서 제외 된다.
    // 1, 1은 제외하고 다음부터 2개의 항을 더한다.
    // A = B항을 치환, B = C(피보나치 항)으로 치환 된다.

    var A : Long = 1 // 첫째 항
    var B : Long = 1 // 둘째 항
    var S : Long = A+B // 누적변수: 첫째 항 + 둘째 항 초기값으로 담아둔다.
    var N = 2 // 92까지 1씩 증가
    var C : Long = 0 // 셋째항 변수 선언
    var i = 0 // 10이 되면 줄바꾸는 변수
    var j = 10 // 10씩 증가하는 변수

    print("> ${A} ${B} ")

    while (true) {
        C = A+B
        S += C // 누적
        A = B // 치환
        B = C // 치환
        N ++
        i ++

            print("${C} ")
        if(i == j) {
            j += 10
            println("")
            print("> ")
        }
        if (N == 92) {
            break
        }
    }
    println("")
    println("피보나치 수열 누적값: "+S)
}