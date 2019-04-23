package practicalapplicationalgorithm

// 5:54~ 6:44

// 통계산출 알고리즘
fun main(args: Array<String>) {
    var Test = MutableList<Int>(30, {i -> i})  // 반 학생 숫자 30명 Test 배열
    var i = 0 // 성적 배열 변수
    var S = 0 // 성적 합계 변수

    for(j in 0..Test.size-1){ // 성적 랜덤으로 입력
        Test[j]= ((Math.random()*(120 - 60 + 1)) + 60).toInt() // 60~120 사이의 랜덤함수
        println("Test[${j+1}]: ${Test[j]}\t")
    }//

    do{
        S += Test[i] // 학생들의 점수 누적
        i++
    } while (i < Test.size) // i가 30보다 적을 동안
    println("학생들의 총점: ${S}")

    var M = S / Test.size // 퍙군잠스 총점 / 30명
    var CNT = 0 // 평균점수 보다 높은 사람 숫자 0으로 초기화
    i = 0 // 0으로 초기화

    do{
        if(Test[i] > M) // 점숙 평균점수 보다 높으면 카운트 증가
            CNT++
        i++
    } while (i < Test.size)
    println("토플 평균: ${M}점\n평균 점수 ${M}점보다 높은 학생 수: ${CNT}")
}