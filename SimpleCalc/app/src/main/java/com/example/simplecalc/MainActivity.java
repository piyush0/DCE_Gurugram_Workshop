package com.example.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etA, etB;
    TextView tvResult;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        etA = findViewById(R.id.et1);
        etB = findViewById(R.id.et2);
        btnAdd = findViewById(R.id.btnAdd);
        tvResult = findViewById(R.id.tvRes);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int one = Integer.valueOf(etA.getText().toString());
                int two = Integer.valueOf(etB.getText().toString());

                int sum = one + two;

                tvResult.setText(String.valueOf(sum));

//                (-11,0);
//                (11,255);
            }
        });

    }
}
