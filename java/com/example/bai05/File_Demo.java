package com.example.bai05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class File_Demo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file__demo);

        final EditText txtContent = findViewById(R.id.txtContent);

        Button btnWriteFile = findViewById(R.id.btnWriteFile);
        btnWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write
                FileOutputStream fOut = null;
                try {
                    fOut = openFileOutput("textfile.txt", MODE_PRIVATE);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);
                    //---write the string to the file---
                    osw.write(txtContent.getText().toString());
                    osw.flush();
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnReadFile = findViewById(R.id.btnReadFile);
        btnReadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write
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

        Button btnDeleteFile = findViewById(R.id.btnDeleteFile);
        btnDeleteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write
               getApplicationContext().deleteFile("textfile.txt");
            }
        });
    }
}