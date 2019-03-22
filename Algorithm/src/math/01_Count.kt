package math

fun main(args: Array<String>) {
    var a = arrayOf(100, 90, 80, 60, 85, 50, 95, 100, 75, 80) // 점수를 담은 배열
    var c = 0 // 카운트 변수
    var i = 0 // 배열의 위치 변

    while (true) {
        if (a[i] >= 80) {
            c++
        }
        i++
        if (i > 9) break
    }
    println("검사한 숫자 :"+ i + "개, 80점 이상이 넘는 사람 : " + c+"명")

    c = 0
    for(i in 0..9){
        if(a[i] >= 70){
            c++
        }
    }
    println("70점 이상인 사람 : " + c +"명")
}