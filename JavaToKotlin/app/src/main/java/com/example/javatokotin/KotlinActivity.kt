package com.example.javatokotin

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_java.*

class KotlinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        first_findViewByID()
        two_setOnClickListner()
    }

    // 1. findViewByID 비교
    private fun first_findViewByID() {
        // 0. 변수선언(X) -> XML에 지정된 id가 변수명으로 존재한다.
        // 1. findViewById 필요없다.

        // 주의할 것은 import 할 때, XML의 위치이다.
        // 복사붙여넣기를 하다보면 가끔 다른 Activity로 연결될 경우가 있다.
        // 이 소스의 예: import kotlinx.android.synthetic.main.activity_kotlin.*

        // 변수가 이미 존재하기에 btnOk만 적어도  에러없음.
        btnOk

    }

    // 2. 람다식에 의한 코딩량 감소(아래 자바코드를 람다식으로 축약가능)
//    private void two_setOnClickListner() {
//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // 자바에서 불편한 것 중에 하나가
//                // 익명 클래스 만들다보면 코딩량이 우측으로 많아진다는 것이다.
//
//            }
//        });
//    }
    private fun two_setOnClickListner() {
        btnOk.setOnClickListener {
            // 람다식은 코딩량을 현격하게 줄여준다.
        }
    }
}