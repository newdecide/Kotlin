package applicationalgorithm

// 삽입정렬
fun main(args: Array<String>) {
    var arrs = arrayOf(95, 75, 85, 100, 50)

    for(i in 1..4){
        var arr = arrs[i]
        var j = i

        while (j > 0 && arr < arrs[i-1] ){
            arrs[j] = arrs[j - 1]
            j--
        }
        arrs[j] = arr
    }

    // 삽입정렬 오름차순
    print("삽입정렬 오름차순 : ")
    for(i in 0..4){
        print("${arrs[i]} \t")
    }

    println()

    for(i in 1..4){
        var arr = arrs[i]
        var j = i

        while (j > 0 && arr > arrs[i-1] ){
            arrs[j] = arrs[j - 1]
            j--
        }
        arrs[j] = arr
    }

    // 삽입정렬 내림차순
    print("삽입정렬 내림차순 : ")
    for(i in 0..4){
        print("${arrs[i]} \t")
    }
}