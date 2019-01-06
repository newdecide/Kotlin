package com.example.odongju.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 전달 받은 키와 몸무게
        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        // BMI 계산
        val bmi = weight / Math.pow(height/100.0, 2.0)

        // 결과표시
        when{
            bmi  >= 35 -> resultText.text = "고도 비만"
            bmi  >= 30 -> resultText.text = "2단계 비만"
            bmi  >= 25 -> resultText.text = "1단계 비만"
            bmi  >= 23 -> resultText.text = "과체중"
            bmi  >= 18.5 -> resultText.text = "정상"
            else -> resultText.text = "저체중"
        }

        // 이미지 표시
        when {
            bmi >= 23 ->
                imageView.setImageResource(
                    R.drawable.ic_sentiment_very_dissatisfied_black_24dp
                )
            bmi >= 18.5 ->
                imageView.setImageResource(
                    R.drawable.ic_sentiment_satisfied_black_24dp
                )
            else ->
                imageView.setImageResource(
                    R.drawable.ic_sentiment_dissatisfied_black_24dp
                )
        }

        // 토스트 메시지로 BMI 값 표시
//        Toast.makeText(this, "$bmi", Toast.LENGTH_SHORT).show()
        toast("$bmi")
    }
}
