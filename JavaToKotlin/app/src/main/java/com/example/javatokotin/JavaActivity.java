package com.example.javatokotin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JavaActivity extends BaseActivity {
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        first_findViewByID();
        two_setOnClickListner();
    }
    // 1. findViewByID 비교
    private void first_findViewByID() {
        // java를 사용한다면 XML로 디자인한 위젯을 사용하려고 한다면
        // 0. 변수를 선언해야 한다.
        // 1. setContentView() 이후
        //    findViewByID()에 ID값을 넘겨 위젯을 가져온 후,
        // 3. 변수에 값을 대입

        btnOk = (Button)findViewById(R.id.btnOk);

    }

    // 2. 과저의 자바는 람다식을 사용하지 않으므로 코딩량이 많다.
    private void two_setOnClickListner() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 자바에서 불편한 것 중에 하나가
                // 익명 클래스 만들다보면 코딩량이 우측으로 많아진다는 것이다.

            }
        });
    }
}
