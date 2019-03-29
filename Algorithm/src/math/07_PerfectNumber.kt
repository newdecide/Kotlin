package math

// 7.완전수
fun main(args: Array<String>) {
    var pn = 0 // 완전수 개수

    for(n in 4..500){ // 4부터 500까지의 변수
        var sum = 0 //
        var k = n / 2 // 완전수의 절반값

        for(j in 1..k){
            var r = n % j // 약수를 판별하는 변수
            if( r == 0) { // 0으로 떨어지면 약수입니다.
                sum += j // 약수의 합이 n과 같으면 n은 완전수다.
            }
        }

        if(n == sum){ // 완전수 인가?
            pn++
            println("${pn} 번째 완전수는 : "+n)

        }
    }
    println("완전수의 개수는: "+pn)
}