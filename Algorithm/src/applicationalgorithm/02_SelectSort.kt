package applicationalgorithm

// 선택정렬
fun main(args: Array<String>) {
    var arr = arrayOf(95, 75, 85, 100, 50)
    var temp = 0

    print("정렬 전 : ")
    for(i in 0..4){
        print("${arr[i]} " )
    }
    println()

    for(i in 0 until arr.size-1){
        var big = i
        for(j in i+1 until arr.size){
            if( arr[big] < arr[j]){ // big값은 고정, big값보다 크면 교체
                big = j
            }
        }
        if(big != i){
            temp = arr[big]
            arr[big] = arr[i]
            arr[i] = temp
        }
    }
    print("선택정렬 내림차순 결과 : ")
    for(i in 0..4){
        print("${arr[i]} \t" )
    }
    // 선택정렬 내림차순 결과 : 100 	95 	85 	75 	50

    println()

    for(i in 0 until arr.size-1){
        var small = i
        for(j in i+1 until arr.size){
            if( arr[small] > arr[j]){ // small값은 고정, small값보다 작으면 교체
                small = j
            }
        }
        if(small != i){
            temp = arr[small]
            arr[small] = arr[i]
            arr[i] = temp
        }
    }
    print("선택정렬 오름차순 결과 : ")
    for(i in 0..4){
        print("${arr[i]} \t" )
    }
    // 선택정렬 오름차순 결과 : 50 	75 	85 	95 	100
}