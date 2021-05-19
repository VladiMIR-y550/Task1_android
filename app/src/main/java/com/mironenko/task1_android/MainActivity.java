package com.mironenko.task1_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvResultReverse;
    EditText etInputString;
    Button btnReverseString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultReverse = (TextView) findViewById(R.id.tvResultReverse);
        etInputString = (EditText) findViewById(R.id.etInputString);
        btnReverseString = (Button) findViewById(R.id.btnReverseString);

        btnReverseString.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tvResultReverse.setText(Reverse.reverseInput(etInputString.getText()));
    }
}