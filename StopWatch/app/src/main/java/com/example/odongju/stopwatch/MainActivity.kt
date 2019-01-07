package com.example.odongju.stopwatch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private var time = 0
    private var isRunning = false
    private var timerTask: Timer? = null
    private var lap = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener {
            isRunning = !isRunning

            if (isRunning) {
                start()
            } else {
                pause()
            }
        }
        resetFab.setOnClickListener {
            reset()
        }
        lapButton.setOnClickListener {
            recordLapTime()
        }
    }

    // 초기화
    private fun reset() {
        timerTask?.cancel()

        // 모든 변수 초기화
        time = 0
        isRunning = false
        fab.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        secTextview.text = "0"
        milliTextview.text = "00"

        // 모든 랩타임을 제거
        lapLayout.removeAllViews()
        lap = 1
    }

    // 스톱워치 시작
    private fun start() {
        // 시작버튼 누르면 일시정지 버튼으로 이미지 변경
        fab.setImageResource(R.drawable.ic_pause_black_24dp)


        timerTask = timer(period = 10) {
            time++ // 1씩 증가
            val sec = time / 100
            val milli = time % 100
            runOnUiThread {
                secTextview.text = "$sec"
                milliTextview.text = "$milli"
            }
        }
    }

    // 일시 정지
    private fun pause() {
        fab.setImageResource(R.drawable.ic_play_arrow_black_24dp)
        timerTask?.cancel()
    }

    // 랩타임 함수
    private fun recordLapTime() {
        val lapTime = this.time
        val textView = TextView(this)
        textView.text = "$lap LAB : ${lapTime / 100}.${lapTime % 100}"

        // 맨 위에 랩타임 추가
        lapLayout.addView(textView, 0)
        lap++
    }
}
