package com.example.sortproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 정렬 할 숫자
        val names = mutableListOf(45, 153, 523, 234, 842, 486, 7, 62, 59, 91, 3, 31, 6, 50)
        val names2 = mutableListOf(35, 123, 423, 254, 742, 586, 4, 42, 79, 99, 2, 63, 6, 52)
        println("정렬 전 : " + names)
        var ordered = insertionsort(names)
        println("삽입 정렬 후 : " + ordered)

        println("정렬 전 : " + names2)
        var ordered2 = selection_sort(names2)
        println("선택 정렬 후 : " + ordered2)

    }

    // 삽입정렬
    fun insertionsort(items: MutableList<Int>): List<Int> {
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

}
