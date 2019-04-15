package applicationalgorithm

// 버블정렬
fun main(args: Array<String>) {
    var arr = arrayOf(95, 75, 85, 100, 50)
    var temp = 0

    for (i in 0..4) {
        for (j in 0..4 - 1) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }


    print("버블정렬 오름차순 : ")
    for (i in 0..4) {
        print("${arr[i]} \t")
    }

// 버블정렬 오름차순 : 50 	75 	85 	95 	100

    println()

    var i = 0

    do {
        var j = 0
        do {
            if (arr[j] < arr[j + 1]) {
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
            j++ // 증감문
        } while (j < 4 - i)
        i++ // 증감문
    } while (i < 4)

    print("버블정렬 내림차순 : ")
    for (i in 0..4) {
        print("${arr[i]} \t")
    }

    // 버블정렬 내림차순 : 100 	95 	85 	75 	50
}