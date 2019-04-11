package math

// 09.근사값
fun main(args: Array<String>) {
    // 500이하의 절대값의 근사값 구하는 알고리즘
    // 초대차이는 500 + 찾고자 하는 근사값
    var a = arrayOf(131, 450, -100, 150, 50, -10, 0, 40, 32, 1) // 배열은 0~9까지
    var input = 39 // 찾고자 하는 근사값
    var MinCha = 500 + input // 근사값을 저장할 변수
    var n = 0 // 배열의 첨자 변수(0~9)
    var Ans = n // 근사값 위치 변수
    var Cha = 0 // 배열의 요소와 입력값의 차이를 담는 변수

    do {
        if (a[n] >= input) { // 배열의 값이 찾는 값보다 크거나 같으면
            Cha = a[n] - input // 배열에서 찾는 값을 뺀다.
        } else {
            Cha = input - a[n] // 찾는 값이 크므로 배열의 값을 뺀다.
        }
        if (Cha < MinCha) { // 입력한 수의 차이값이 근사값보다 작으면 교환
            MinCha = Cha // 근사값 변경
            Ans = n // 근사값 항 첨자 변경
        }
        n++
    } while (n < 10)
    println("근사값의 항은? " + Ans + "번째 항")
    println("근사값은? " + a[Ans])
}