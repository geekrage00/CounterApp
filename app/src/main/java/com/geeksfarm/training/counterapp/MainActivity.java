package com.geeksfarm.training.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String STATE_COUNT = "state_count"; // konstanta untuk state count

    //pembuatan object component
    TextView tvCount;
    Button btnCount, btnReset;
    int count = 0; //tipe data primitif
    //Integer count = 0; //tipe data reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //bind activity ke layout yang akan ditampilkan

        //binding component ke view
        tvCount = findViewById(R.id.tv_count);
        btnCount = findViewById(R.id.btn_count);
        btnReset = findViewById(R.id.btn_reset);


        if(savedInstanceState != null){ //cek apakah ada state yang tersimpan ?
            count = savedInstanceState.getInt(STATE_COUNT);
            tvCount.setText(String.valueOf(count));
        }

        //cara 1 untuk set OnClick pada Component
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something here
                count++;
                if(count == 1000) {
                        tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelSize(R.dimen.smaller_text_tv_count));

                }
                tvCount.setText(String.valueOf(count));

                //tvCount.setText(count.toString());
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tvCount.setTextSize(TypedValue.COMPLEX_UNIT_PX,getResources().getDimensionPixelSize(R.dimen.default_text_tv_count));

                tvCount.setText(String.valueOf(count));
            }
        });



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //save state
        outState.putInt(STATE_COUNT,count);
    }
}
