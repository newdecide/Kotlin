package sequence

fun main(args: Array<String>) {
    // 5.팩토리얼(Factorial)
    var N : Long = 1 // 1씩 증가하는 변수
    var F : Long = 1 // 팩토리얼을 저장할 변수
    var S : Long = 1 // 팩토리얼을 누적하는 변수
    /*
    * N = 1 -> 1!(팩토리얼) = 1
    * */
    println("${N}! = ${N}")

    /*
    * N = 2
    * F = 1 * 2 = 2
    * S = 1 + 2 = 3
    * */
    while (true){
        N++ // N = N + 1
        F *= N // F = F * N
        S += F // S = S + F
        println("${N}! = ${N-1}! * ${N}")
        if(N == 100L){
            break
        }
    }
    println("팩토리얼 누적값: " + S)
}