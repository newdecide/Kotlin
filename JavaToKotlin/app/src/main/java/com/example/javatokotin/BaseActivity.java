package com.example.javatokotin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    int nLineNumber = 0;
    public void WriteLn( String s){
        TextView txt = (TextView) findViewById(R.id.txtMessage);
        String sTotal =txt.getText().toString();
        txt.setText(sTotal + "\n" + new Integer(nLineNumber).toString() + ":" +s);
        nLineNumber++;
    }

}
