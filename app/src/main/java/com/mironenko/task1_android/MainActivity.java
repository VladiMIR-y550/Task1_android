package com.mironenko.task1_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_ReverseString;
    private EditText et_InputString;
    private TextView tv_ResultReverse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ReverseString = (Button) findViewById(R.id.btn_ReverseString);
        et_InputString = (EditText) findViewById(R.id.et_InputString);
        tv_ResultReverse = (TextView) findViewById(R.id.tv_ResultReverse);

        if (savedInstanceState != null) {
            tv_ResultReverse.setText(savedInstanceState.getString("inputText"));
        }

        btn_ReverseString.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Editable ed_Text;
                Editable ed_TextReverse;
                ed_Text = et_InputString.getEditableText();
                et_InputString.setText(ed_Text);
                ed_TextReverse = Reverse.reverseInput(ed_Text);
                tv_ResultReverse.setText(ed_TextReverse);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceSave) {
        super.onSaveInstanceState(savedInstanceSave);
        savedInstanceSave.putCharSequence("inputText", tv_ResultReverse.getText().toString());
    }
}