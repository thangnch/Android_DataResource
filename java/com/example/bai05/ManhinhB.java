package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManhinhB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_b);

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xoá key username ở trong SharePreferences
                SharedPreferences myShared = getSharedPreferences("myShared",0);
                SharedPreferences.Editor myEditor = myShared.edit();
                myEditor.remove("username");
                myEditor.apply();
                // Thực hiện move to A
                Intent move_to_a = new Intent(ManhinhB.this, ManhinhA.class);
                startActivity(move_to_a);
            }
        });
    }
}