package com.example.basicstep3.using_kotlin

import android.content.Intent
import com.example.basicstep3.MainActivity
import com.example.basicstep3.javainterlop.javaActivity
import kotlinx.android.synthetic.main.activity_main.*

// 확장함수로 이벤트 핸들러를 등록
fun MainActivity.setClickHandler(){
    btnTest.setOnClickListener {
        var I = Intent(this, javaActivity::class.java)
        startActivity(I)
    }
}