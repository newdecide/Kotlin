package com.example.basicstep1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FirstTest 클래스
        // :: 메서드 불러올 때 사용
        doTest(FirstTest(::WriteLn))
    }

    private fun doTest(o : TestClass){
        o.doTest()
    }

    fun WriteLn( any : Any){
        // 코틀린은 findviewById 없이 바로 사용할 수 있다.
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }

}
