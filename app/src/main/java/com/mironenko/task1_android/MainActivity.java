package com.mironenko.task1_android;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        TextView.OnEditorActionListener {

    private EditText et_InputString;
    private TextView tv_ResultReverse;
    private Button btn_ReverseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_InputString = (EditText) findViewById(R.id.et_InputString);
        tv_ResultReverse = (TextView) findViewById(R.id.tv_ResultReverse);
        btn_ReverseString = (Button) findViewById(R.id.btn_ReverseString);

        if (savedInstanceState != null) {
            tv_ResultReverse.setText(savedInstanceState.getString("inputText"));
        }

        btn_ReverseString.setOnClickListener(this);
        et_InputString.setOnEditorActionListener(this);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        stringProcessing(et_InputString.getText().toString());
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceSave) {
        super.onSaveInstanceState(savedInstanceSave);
        savedInstanceSave.putCharSequence("inputText", tv_ResultReverse.getText().toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        stringProcessing(et_InputString.getText().toString());
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void stringProcessing (String inputString) {
        String res = Reverse.reverseInput(inputString);
        tv_ResultReverse.setText(res);
    }
}