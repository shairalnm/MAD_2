package com.example.inclass03;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SelectAvatarActivity extends AppCompatActivity {

    ImageView f1, f2, f3, m1, m2, m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar2);
        setTitle("Select Avatar");

        f1 = findViewById(R.id.imageViewF_1);
        f2 = findViewById(R.id.imageViewF_2);
        f3 = findViewById(R.id.imageViewF_3);
        m1 = findViewById(R.id.imageViewM_1);
        m2 = findViewById(R.id.imageViewM_2);
        m3 = findViewById(R.id.imageViewM_3);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.value, "f1");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.value, "f2");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.value, "f3");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.value, "m1");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.value, "m2");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.value, "m3");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
