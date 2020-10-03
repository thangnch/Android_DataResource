package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences myShared = getSharedPreferences("SPDemo",MODE_PRIVATE);
                SharedPreferences.Editor myEditor = myShared.edit();

                myEditor.remove("username");
                myEditor.apply();

                finish();

            }
        });
    }
}