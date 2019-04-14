package applicationalgorithm


// 선택정렬
fun main(args: Array<String>) {
    var arr = arrayOf(95, 75, 85, 100, 50)
    var temp = 0

    for(i in 0..4){
        for(j in 0..4){
            if( arr[i] > arr[j]){ // 1번째 원소가 2번째 원소보다 크면 그대로 둔다. 작으면 교체
                // swap 알고리즘
                temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
    print("선택정렬 내림차순 결과 : ")
    for(i in 0..4){
        print("${arr[i]} \t" )
    }
    // 선택정렬 내림차순 결과 : 100 	95 	85 	75 	50

    println()

    for(i in 0..4){
        for(j in 0..4){
            if( arr[i] < arr[j]){ // 1번째 원소가 2번째 원소보다 작으면 그대로 둔다. 크면 교체
                // swap 알고리즘
                temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
    print("선택정렬 오름차순 결과 : ")
    for(i in 0..4){
        print("${arr[i]} \t" )
    }
    // 선택정렬 오름차순 결과 : 50 	75 	85 	95 	100
}