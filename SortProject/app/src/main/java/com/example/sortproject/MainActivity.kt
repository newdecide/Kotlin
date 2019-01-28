package com.example.sortproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 정렬 숫자
        val names = mutableListOf(45, 153, 523, 234, 842, 486, 7, 62, 59, 91, 3, 31, 6, 50)
        val names2 = mutableListOf(35, 123, 423, 254, 742, 586, 4, 42, 79, 99, 2, 63, 6, 52)
        val names3 = mutableListOf(25, 135, 473, 264, 760, 505, 1, 47, 85, 92, 6, 64, 8, 37)
        val names4 = mutableListOf(38, 255, 27, 324, 43, 286, 3, 9, 512, 10, 82, 1024, 91, 2048)
        val names5 = mutableListOf(2, 4, 7, 3, 6, 9, 5, 1, 0, 10)
        val names6 = mutableListOf(61, 109, 149, 111, 34, 2, 24, 119, 122, 125, 27, 145)
        val names7 = mutableListOf(6, 0, 7, 4, 8, 5, 2, 2, 1, 0, 2)
        val names8 = mutableListOf(4, 65, 2, -31, 0, 99, 2, 83, 782, 1)

//        println("정렬 전 : " + names)
//        Log.e("정렬 전 : ", names.toString())
//        var ordered = insertion_sort(names)
//        Log.e("삽입 정렬 후 : ", ordered.toString())

//        Log.e("정렬 전 : ", names2.toString())
//        var ordered2 = selection_sort(names2)
//        Log.e("선택 정렬 후 : ", ordered2.toString())

//        Log.e("정렬 전 : ", names2.toString())
//        var ordered3 = bubble_sort(names3)
//        Log.e("버블 정렬 후 : ", ordered3.toString())

//        Log.e("정렬 전 : ", names2.toString())
//        var ordered4 = merge_sort(names4)
//        Log.e("병합 정렬 후 : ", ordered4.toString())

//        Log.e("정렬 전 : ", names5.toString())
//        var ordered5 = quick_sort(names5)
//        Log.e("퀵 정렬 후 : ",ordered5.toString())

//        Log.e("정렬 전 : ", names6.toString())
//        var ordered6 = shell_sort(names6)
//        Log.e("쉘 정렬 후 : ",ordered6.toString())

//        Log.e("정렬 전 : ", names7.toString())
//        var ordered7 = cycle_sort(names7)
//        Log.e("사이클 정렬 후 : ", ordered7.toString())

        Log.e("정렬 전 : ", names8.toString())
        var ordered8 = cycle_sort(names8)
        Log.e("칵테일 정렬 후 : ", ordered8.toString())
    }

    // 삽입정렬
    fun insertion_sort(items: MutableList<Int>): List<Int> {
        if (items.isEmpty() || items.size < 2) {
            return items
        }
        // 이전요소와 비교하기 위해 두번째 요소부터 반복문 시작
        for (count in 1..items.count() - 1) {

            val item = items[count]
            var i = count
            while (i > 0 && item < items[i - 1]) {
                items[i] = items[i - 1]
                i -= 1
            }
            items[i] = item
        }
        return items
    }

    // 선택 정렬
    fun selection_sort(items: MutableList<Int>): MutableList<Int> {
        if (items.isEmpty() || items.size < 2) {
            return items
        }
        for (idx in 0..items.count()) {
            val array = items.subList(0, items.count() - idx)
            val minItem = array.min()
            val indexOfMinItem = array.indexOf(minItem)

            if (minItem != null) {
                items.removeAt(indexOfMinItem)
                items.add(minItem)
            }
        }
        return items
    }

    // 버블 정렬
    fun bubble_sort(items: MutableList<Int>): List<Int> {
        if (items.isEmpty() || items.size < 2) {
            return items
        }
        // swap이 false가 될 때까지 반
        var swap = true
        while (swap) {
            swap = false
            for (i in 0 until items.size - 1) {
                if (items[i] > items[i + 1]) {
                    val temp = items[i]
                    items[i] = items[i + 1]
                    items[i + 1] = temp
                    // 정렬이 되지 않으면 true로 변환 끝나면 들어오지 않음.
                    swap = true
                }
            }
        }
        return items
    }

    // 병합 정렬
    fun merge_sort(list: List<Int>): List<Int> {
        if (list.size <= 1) {
            return list
        }

        val middle = list.size / 2
        var left = list.subList(0, middle)
        var right = list.subList(middle, list.size)

        return merge(merge_sort(left), merge_sort(right))
    }

    // 병합
    fun merge(left: List<Int>, right: List<Int>): List<Int> {
        var indexLeft = 0
        var indexRight = 0
        var newList: MutableList<Int> = mutableListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size) {
            newList.add(left[indexLeft])
            indexLeft++
        }
        while (indexRight < right.size) {
            newList.add(right[indexRight])
            indexRight++
        }
        return newList
    }

    // 퀵 정렬
    fun quick_sort(items: List<Int>): List<Int> {
        if (items.count() < 2) {
            return items
        }
        // 배열의 중간 값
        val pivot = items[items.count() / 2]
        val equal = items.filter { it == pivot }
        Log.e("pivot values : ", equal.toString())
        // 피벗보다 적은 값들
        val less = items.filter { it < pivot }
        Log.e("less values : ", less.toString())
        // 피벗 중 가장 큰 값
        val greater = items.filter { it > pivot }
        Log.e("greater values : ", greater.toString())

        return quick_sort(less) + equal + quick_sort(greater)
    }

    // 쉘 정렬
    fun shell_sort(items: MutableList<Int>): List<Int> {
        if (items.isEmpty() || items.size < 2) {
            return items
        }

        val n = items.size
        // 첫번째 반복 이후 이전갭을 2로 나눈다.
        var gap = n / 2
        // 열간격이 0보다 클때까지 반복
        while (gap > 0) {
            var i = gap
            while (i < n) {
                // 제로 요소와 갭에 있는 요소를 비교
                val temp = items[i]
                var j = i
                while (j >= gap && items[j - gap] > temp) {
                    items[j] = items[j - gap]
                    j -= gap
                }
                items[j] = temp
                i += 1
            }
            gap /= 2
        }
        return items
    }

    // 사이클 정렬
    fun cycle_sort(items: MutableList<Int>): List<Int> {
        if (items.isEmpty() || items.size < 2) {
            return items
        }

        var writes = 0

        for (cycleStart in 0 until items.size - 1) {
            var item = items[cycleStart]

            var pos = cycleStart
            for (i in cycleStart + 1 until items.size) {
                if (items[i] < item) {
                    pos++
                }
            }

            if (pos == cycleStart) continue

            while (item == items[pos]) {
                pos++
            }
            val temp = items[pos]
            items[pos] = item
            item = temp
            writes++

            while (pos != cycleStart) {
                pos = cycleStart
                for (i in cycleStart + 1 until items.size) {
                    if (items[i] < item) pos++
                }

                while (item == items[pos]) {
                    pos++
                }
                val temp2 = items[pos]
                items[pos] = item
                item = temp2
                writes++
            }
        }

        return items
    }

    // 칵테일 정렬
    fun cacktai_sort(items: MutableList<Int>): List<Int> {
        if(items.isEmpty() || items.size < 2) {
            return items
        }
        fun swap(i: Int, j: Int){
            val temp = items[i]
            items[i] = items[j]
            items[j]=temp
        }
        do{
            var swapped = false
            for (i in 0 until items.size -1)
                if(items[i] > items[i+1]){
                    swap(i, i+1)
                    swapped = true
                }
            if(!swapped) break
            swapped = false
            for(i in items.size -2 downTo 0)
                if(items[i] > items[i+1]){
                    swap(i, i+1)
                    swapped = true
                }
        } while(swapped)
        return items
    }
}
