package com.example.flashlight

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        var torch = Torch(this)

        flashswitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //  On일 때의 동작
//                torch.flashOn()
                startService(intentFor<TorchService>().setAction("on"))
            } else {
                // Off일 때의 동작
//                torch.flashOff()
                startService(intentFor<TorchService>().setAction("off"))
            }
        }

    }
}
