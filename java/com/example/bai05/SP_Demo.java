package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SP_Demo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_p__demo);

        final EditText txtUsername = findViewById(R.id.txtUsername);

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                SharedPreferences myShared = getSharedPreferences("SPDemo",MODE_PRIVATE);
                SharedPreferences.Editor myEditor = myShared.edit();

                myEditor.putString("username", txtUsername.getText().toString());
                myEditor.apply();

                Intent move_to_main = new Intent(SP_Demo.this, MainActivity.class);
                startActivity(move_to_main);
            }
        });

        SharedPreferences myShared = getSharedPreferences("SPDemo",MODE_PRIVATE);
        String username = myShared.getString("username","");
        if (username!="")
        {
            Intent move_to_main = new Intent(SP_Demo.this, MainActivity.class);
            startActivity(move_to_main);
        }

    }
}