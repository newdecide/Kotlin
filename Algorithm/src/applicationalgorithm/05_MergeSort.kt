package applicationalgorithm

// 병합정렬
fun main(args: Array<String>) {
    var arr1 = arrayOf(2, 5, 10, 17, 20)
    var arr2 = arrayOf(11, 9, 8, 7)
    var arrMerge = arrayOfNulls<Int>(9 )
    var M = arr1.size // arr1의 마지막 원소
    var N = arr2.size // arr2의 마지막 원소
    var a1 = 0
    var b1 = N-1
    var c1 = 0

    print("병합정렬 전 A배열 ")
    for (i in 0..4) {
        if(i in 0..3) { // 마지막 쉼표를 빼기 위함
            print("${arr1[i]}, ")
        } else
            print("${arr1[i]}")
    }

    println()

    print("병합정렬 전 B배열 ")
    for (i in 0..3) {
        if(i in 0..2) {
            print("${arr2[i]}, ")
        } else
            print("${arr2[i]}")
    }

    println()

    do {
        if (arr1[a1] <= arr2[b1]) {
            arrMerge[c1] = arr1[a1]
            a1++
            c1++
        }

        if(arr1[a1] >= arr2[b1]) {
            arrMerge[c1] = arr2[b1]
            b1--
            c1++

            if(b1 < 0 ){
                for(i in a1..arr1.size-1) {
                    arrMerge[c1] = arr1[a1]
                    a1++
                    c1++
                }
                break
            }
        }

    } while (c1 <= 8 )

    print("병합정렬 결과: ")
    for (i in 0..8) {
        print("${arrMerge[i]}\t")
    }
}