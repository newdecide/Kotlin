package math

// 8.최대공약수와 최소공배수
fun main(args: Array<String>) {
    var big = 532 // 큰값
    var small = 462 // 작은값
    var temp = 0 // 치환 변수

    // big에 큰값이와야 나머지 계산을 수행할 수 있다. big값이 작으면 small값과 교체해준다.
    if (big < small) {
        temp = big
        big = small
        small = temp
        println("big값 보다 small값이 커서 교체")
    }

    // 최대 공약수를 구하는 반복문
    while (true) {
        var m = big % small // 나머지 계산
        if (m == 0) // 나머지가 0이면 나간다. 0이 될땨까지 계속 수행 나누었을때 0이된 수가 최대 공약수이다.
            break
        big = small // 나눈 수를 큰 값에 넣는다.
        small = m // 나머지를 작은 값에 넣는다.
    }

    println("최대 공약수는?" + small)
    var lcm = (big * small) / small // 최소공배수 변수
    println("최소 공배수는?" + lcm)
}