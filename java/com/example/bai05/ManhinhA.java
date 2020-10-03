package com.example.bai05;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManhinhA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh);

        final EditText txtUsername = findViewById(R.id.txtUsername);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lưu vào Shared Preferences
                SharedPreferences myShared = getSharedPreferences("myShared",MODE_PRIVATE);
                SharedPreferences.Editor myEditor = myShared.edit();

                // Lưu giá trị username
                myEditor.putString("username",txtUsername.getText().toString());
                myEditor.apply();

                // Chuyển sang màn hình B
                Intent move_to_b = new Intent(ManhinhA.this, ManhinhB.class);
                startActivity(move_to_b);
            }
        });

        // Kiểm tra nếu đã login thì chuyển sang màn hình B luôn
        SharedPreferences myShared = getSharedPreferences("myShared",MODE_PRIVATE);
        String username = myShared.getString("username","");

        if (username.length()!=0)
        {
            // Chuyển sang màn hình B
            Intent move_to_b = new Intent(ManhinhA.this, ManhinhB.class);
            startActivity(move_to_b);
        }
    }
}