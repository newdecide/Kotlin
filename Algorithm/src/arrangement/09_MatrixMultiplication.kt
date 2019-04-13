package arrangement

// 09.행렬 곱셈
fun main(args: Array<String>) {
    var A = arrayOf(arrayOf(5, 7, -3, 4), arrayOf(2,-5, 3, 6))
    var B = arrayOf(arrayOf(3,0,8), arrayOf(-5,1,-1), arrayOf(7,4,4), arrayOf(2,4,3))
    var S = Array(2 , {IntArray(3)})

    println("A 행렬")
    for(r in 0..1){
        for(c in 0..3){
            print("${A[r][c]}\t\t")

            if(c == 3){
                println()
            }
        }
    }
/*
    A 행렬
    5		7		-3		4
    2		-5		3		6
 */
    println()

    println("B 행렬")
    for(r in 0..3){
        for(c in 0..2){
            print("${B[r][c]}\t\t")

            if(c == 2){
                println()
            }
        }
    }
/*
    B 행렬
    3		0		8
    -5		1		-1
    7		4		4
    2		4		3
 */
    println()

    for(r in 0..1){
        for(c in 0..2){
            S[r][c] = 0
            for(k in 0..3){
                S[r][c]  = S[r][c] + A[r][k] * B[k][c]
            }
        }
    }

    println("A행렬 B행렬 곱셉 결과")
    for(r in 0..1){
        for(c in 0..2){
            print("${S[r][c]}\t\t")

            if(c == 2){
                println()
            }
        }
    }
/*
행렬 곱셈 결과
    -33		11		33
    64		31		51
 */
}