package com.example.project_kesehatan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.widget.EditText;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {

    private Button Homes, Save;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Homes = (Button) findViewById(R.id.Homes);

        Homes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), home.class);
                startActivity(home);

            }
        });
    }
}