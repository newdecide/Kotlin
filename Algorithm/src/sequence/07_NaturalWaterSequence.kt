package sequence

fun main(args: Array<String>) {
    // 7. +, - 교행 자연수 수열
    // ex) 1-2+3-4+5...+99-100
    var n = 0 // 1씩 증가 변수
    var s = 0 // n을 교행으로 입력
    var i = 20 // 줄바꿈 변수
   do {
           n++
           s += n
       if(s % 2 == 0){ // 1 % 2 != 0
           print("${-s}")
       }
           n++
           s -= n
       if(s % 2 != 0){ // 2 % 2 == 0
           print("+${-s}")
       }

       if(n == i){
           i+=20
           println("")
       }
    }  while (n != 200)

}