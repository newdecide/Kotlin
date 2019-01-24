package com.example.sortproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 정렬 할 숫자
        val names = mutableListOf(45, 153, 523, 234, 842, 486, 7, 62, 59, 91, 3, 31, 6, 50)
        val names2 = mutableListOf(35, 123, 423, 254, 742, 586, 4, 42, 79, 99, 2, 63, 6, 52)
        val names3 = mutableListOf(25, 135, 473, 264, 760, 505, 1, 47, 85, 92, 6, 64, 8, 37)
        val names4 = mutableListOf(38, 255, 27, 324, 43, 286, 3, 9, 512, 10, 82, 1024, 91 ,2048)
        println("정렬 전 : " + names)

        Log.e("정렬 전 : ", names.toString())
        var ordered = insertion_sort(names)
        Log.e("삽입 정렬 후 : ", ordered.toString())

        Log.e("정렬 전 : ", names2.toString())
        var ordered2 = selection_sort(names2)
        Log.e("선택 정렬 후 : ", ordered2.toString())

        Log.e("정렬 전 : ", names2.toString())
        var ordered3 = bubble_sort(names3)
        Log.e("버블 정렬 후 : ", ordered3.toString())

        Log.e("정렬 전 : ", names2.toString())
        var ordered4 = merge_sort(names4)
        Log.e("병합 정렬 후 : ", ordered4.toString())
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
    fun merge_sort(list: List<Int> ): List<Int>{
        if(list.size <= 1){
            return list
        }

        val middle = list.size / 2
        var left = list.subList(0, middle)
        var right = list.subList(middle, list.size)

        return merge(merge_sort(left), merge_sort(right))
    }

    fun merge(left: List<Int>, right: List<Int>): List<Int>{
        var indexLeft = 0
        var indexRight = 0
        var newList : MutableList<Int> = mutableListOf()

        while(indexLeft < left.count() && indexRight < right.count()){
            if (left[indexLeft] <= right[indexRight]){
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.size){
            newList.add(left[indexLeft])
            indexLeft++
        }
        while (indexRight < right.size){
            newList.add(right[indexRight])
            indexRight++
        }
        return newList
    }
}
