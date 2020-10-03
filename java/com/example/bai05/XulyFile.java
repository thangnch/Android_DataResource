package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class XulyFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuly_file);

        final EditText txtContent = findViewById(R.id.txtContent);


        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Ghi vào file
                FileOutputStream fOut = null;
                try {
                    fOut = openFileOutput("textfile.txt", MODE_PRIVATE);

                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    osw.write(txtContent.getText().toString());
                    osw.flush();
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load dữ liệu từ file và hiển thị vào textedit
                FileInputStream fIn = null;
                try {
                    fIn = openFileInput("textfile.txt");

                    InputStreamReader isr = new InputStreamReader(fIn);
                    char[] inputBuffer = new char[128];
                    String s = "";
                    int charRead;
                    while ((charRead = isr.read(inputBuffer)) > 0) {
                        String readString = String.copyValueOf(inputBuffer, 0, charRead);
                        s += readString;
                        inputBuffer = new char[128];
                    }
                    txtContent.setText(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnDetele = findViewById(R.id.btnDelete);
        btnDetele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Xoá file
                getApplicationContext().deleteFile("textfile.txt");

            }
        });
    }
}