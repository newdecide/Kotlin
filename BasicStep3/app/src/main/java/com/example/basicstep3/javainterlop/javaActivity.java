package com.example.basicstep3.javainterlop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.example.basicstep3.R;

// static하게 import한다.
import static com.example.basicstep3.javainterlop.KotlinActivityKt.kotlinEventHandler;

public class javaActivity extends AppCompatActivity {
    /*  kotlin에서 java를 사용하는 것은 너무 자연스럽다.
        java에서 Kotlin을 사용하면
        파일명(첫번째대문자)Kt 형식으로 class가 생성된다.
        파일 안에 정의된 일반 변수(클래스포함)는 get/set 형식의 메소드로 사용가능하다.
        java에서 메소드형식으로 변환없이 사용하려면 @JvmField
        어노테이션을 사용한다.
        java에서 스태틱메소드를 사용하려면 @JvmStatic 어노테이션을 사용한다.
        확장함수를 사용하면 java 소스 내용을 공유하여 부분적으로 코틀린으로 코딩할 수 있다.
    */

    String sMessage = "Hi, Java";

    // kotlin에서 사용가능
    public void T(Context ctx, String sMessage) {
        Toast.makeText(ctx, sMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        // 코틀린으로 만든 확장함수 사용
        kotlinEventHandler(this);

        // kotlin File에서
        usingKotlin();
    }

    private void usingKotlin() {
        // Kotlin 가져오기
        // class가 아닌 변수와 함수는 자동으로 변환한다.
        // 파일명을 대소문자 변경 후, 뒤에 Kt를 붙인다.
        // 그리고 . 연산자 이후에 사용가능
        KotlinActivityKt.getName();
        KotlinActivityKt.MyTest();

        // 클래스명은 그대로 사용가능
        // 어노테이션으로 자바에서 사용할 것을 지정해주어야 함.
        Log.d("TEST", KotlinExport.name);

        KotlinExport.age = 30;
        KotlinExport.test();

        KotlinExport ke = new KotlinExport();
        ke.test2();
    }
}
