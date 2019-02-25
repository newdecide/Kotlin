package com.example.basicstep2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.basicstep2.step2.ClassTest
import com.example.basicstep2.step2.DataClassTest
import com.example.basicstep2.step2.IasTest
import com.example.basicstep2.step2.PolymorphTest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doTest(ClassTest(::WriteLn))
        doTest(PolymorphTest(::WriteLn))
        doTest(IasTest(::WriteLn))
        doTest(DataClassTest(::WriteLn))
//        doTest(ObjectTest(::WriteLn))
    }

    fun doTest(o: TestClass){
        o.doTest()
    }

    fun WriteLn( any: Any){
        txtMessage.text = "${txtMessage.text}${any.toString()}\n"
    }
}
