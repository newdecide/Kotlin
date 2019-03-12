package com.example.javatokotin;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    // 3. 변수의 형변환
    private void three_VariableTypeCasting() {
        // 변수의 형에맞게 반드시 알려주어야 한다.
        TextView txt = (TextView)findViewById(R.id.txtMessage);
    }

    // 4. 프로퍼티 (Set / Get 구별하여 함수구분)
    private void four_properties() {
        Person p = new Person();
        p.setname(" Test ");
        WriteLn(p.getname());
    }

    class Person{
        private String name;

        public String getname(){
            return name + " 입니다";
        }

        public void setname(String s ){
            this.name = getClass().getName() + ":" + s;
        }
    }

    // 5. 자바에서 이벤트핸들러를 사용할 경우,
    // 함수를 정의하지않고 코딩을 하려고 한다면
    // Interface를 이름없는 객체를 만들어 사용하는 것이 일반적이다.
    // 무척 코드가 길어진다.
    private void five_highfunction(String s, onMyListner onMyListner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("확인");
        builder.setMessage(s);

        final onMyListner ol =onMyListner;
        builder.setPositiveButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ol.onClick();
            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener (){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    // Java에서 Interface는 C/C++의 함수포인터의 역할을 한다.
    // 적당한 이벤트핸들링을 하기위해서는 Interface 선언이 필수다.
    interface onMyListner{
        public void onClick();
    }
}
