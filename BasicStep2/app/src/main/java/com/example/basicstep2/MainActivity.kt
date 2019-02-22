package com.example.basicstep2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.basicstep2.step2.ClassTest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doTest(ClassTest(::WriteLn))
    }

    fun doTest(o: TestClass){
        o.doTest()
    }

    fun WriteLn( any: Any){
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}
