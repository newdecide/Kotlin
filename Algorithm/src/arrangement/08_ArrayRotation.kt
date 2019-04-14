package arrangement

// 08.배열 회전
fun main(args: Array<String>) {
    var a = Array(5, { CharArray(5) })

    var b = Array(5, { CharArray(5) })

    var c = Array(5, { CharArray(5) })

    var n2 = 'a'

    for (r in 0 until 5) { // a~y까지 배열에 입력
        for (c in 0 until 5) {
            a[r][c] = n2
            n2++
        }
    }
    for (r in 0 until 5) { // a배열 입력
        for (c in 0 until 5) {
            print("${a[r][c]}\t")
            if(c == 4){println()}
        }
    }
/*
변형 안 한 배열
    a	b	c	d	e
    f	g	h	i	j
    k	l	m	n	o
    p	q	r	s	t
    u	v	w	x	y
 */

    for ( r in 0 until 5){ // a배열을 b배열에 입력
        for( c in 0 until 5) {
            var n = 4 - r
            b[c][n] = a[r][c] // c = 0, 1, 2, 3, 4 n = 4, 3, 2, 1, 0
            // 열고정 행증가 = 행고정 열증가
            // b[0][4] = a[0][0]
            // b[1][4] = a[0][1]
            // b[2][4] = a[0][2]
            // b[3][4] = a[0][3]
            // b[4][4] = a[0][4]
        }
    }

    println()
    for (r in 0 until 5) {
        for (c in 0 until 5) {
            print("${b[r][c]}\t")
            if(c == 4){println()}
        }
    }
/*
90도 회전 1차
    u	p	k	f	a
    v	q	l	g	b
    w	r	m	h	c
    x	s	n	i	d
    y	t	o	j	e
 */

    for ( r in 0 until 5){ // a배열을 b배열에 입력
        for( a in 0 until 5) {
            var n = 4 - r
            c[a][n] = b[r][a] // a = 0, 1, 2, 3, 4 n = 4, 3, 2, 1, 0
            // 열고정 행증가 = 행고정 열증가
            // c[0][4] = b[0][0]
            // c[1][4] = b[0][1]
            // c[2][4] = b[0][2]
            // c[3][4] = b[0][3]
            // c[4][4] = b[0][4]
        }
    }

    println()
    for (r in 0 until 5) {
        for (a in 0 until 5) {
            print("${c[r][a]}\t")
            if(a == 4){println()}
        }
    }

/*
90도 회전 2차
    y	x	w	v	u
    t	s	r	q	p
    o	n	m	l	k
    j	i	h	g	f
    e	d	c	b	a
 */
}