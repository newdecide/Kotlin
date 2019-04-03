package math

// 10진수를 16진수로 변환
fun main(args: Array<String>) {
    var hexexpression = arrayOf('0','1','2','3','4','5','6','7','8','9',
        'A','B','C','D','E','F') // 16진수로 표현할 수 있는 배열
    var hexadecimal = arrayOfNulls<Char>(20) // 16진수 저장하는 변
    var decimal = 1017 // 10진수
    var i = 0 // 16진수의 원소
    var m = 0 // 16진수 표현 배열의 원소
    var n = 0

    println("16진수로 변환할 10진 정수 : "+decimal)
    do {
        m = decimal / 16 // 10진수를 16으로 나눈 몫
        n = decimal % 16 // 10진수를 16으로 나눈 나머지
        hexadecimal[i] = hexexpression[n] // 나머지를 16진수 배열에 저장한다.
        i++// 16진수 배열 원소 증가
        decimal = m // 나눌 10진수는 몫으로 대체한다.
    } while (m >= 16) // 16으로 나눈 m값이 작으면 탈출

    print("16진수: ")
    hexadecimal[i] = hexexpression[m] //16진수 배열에 16진수 표현법으로 입력
    var k = i // 16진수 끝자리수로 값 변환 : 나머지를 16진수 표현으로 표현
    do{
        print(hexadecimal[k]) // 16으로 나눈 나머지 거꾸로 읽기때문에 1씩 감소하는 형태로 출력한다.
        k-- // 16진수 배열 원소 감소
    } while (k >= 0)

    // 16진수는 10진수를 16으로 나누어 구한다.
    // 몫은 다시 16으로 나눌수 있을 때까지 나눈다.
    // 나머지는 거꾸로 읽으면 16진수가 된다.
}