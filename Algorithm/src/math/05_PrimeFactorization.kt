package math

// 05.소인수분해
fun main(args: Array<String>) {
    var A = arrayOfNulls<Int>(20)
    var N = 20
    var T = 0
    var K = 2
    do {
        if (N >= 2) {
            for (P in 2..N) {
                if(N == 5){
                    K = N
                    break
                }
                if (N % P == 0) {
                    break
                }
            }
            A[T]=K
            N = N/K
            T++
        }
        else
            return
    } while (N != 1)
    if (T == 1) {
        println("소수")
    } else {
        for (J in 0 until T-1) {
            print("${A[J]} * ")
        }
        println(A[T-1])
    }
}