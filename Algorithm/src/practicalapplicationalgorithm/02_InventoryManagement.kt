package practicalapplicationalgorithm

// 6:47~7:15
// 재고관리 알고리즘
fun main(args: Array<String>) {
    var sizeArray = MutableList(301, {i->i}) // 301사이즈 빈 배열 생성
    var size = arrayListOf(300, 170, 250, 230, 280, 285, 300, 300, 200, 230,
        230, 170, 300, 190, 240, 250, 240, 300, 275, 265) // 신발 사이즈 배열

    for(i in 0..19){ // 0~19까지 신발 사이즈 출력
        if(i < 9) { // 9까지 사이즈 출력
            print("${size[i]}\t")
        } else if(i == 10) { // 10이되면 줄바꿈하고 한개 출력
            println()
            print("${size[i]}\t")
        } else { // 나머지 사이즈 출력
            print("${size[i]}\t")
        }
    }
    println()

    var F = 0
    for(F in 170..300 step 5){ // 배열 원소 0으로 다 초기화
        sizeArray[F] = 0
    }
    for(i in 0..19){
        F = size[i] // 신밠사이즈 배열 F에 담는다.
        sizeArray[F]++ // 사이즈 배열 170부터
    }

    println("신발 사이즈 재고")
    // 신발 사이즈 재고 반복문
    for(F in 170..300 step 5){ // 170부터 300까지 5씩 증가
        if(sizeArray[F] != 0) // 사이즈 배열이 0이 아닌 것만 출력
            println("${F}cm : ${sizeArray[F]}켤레")
    }
}