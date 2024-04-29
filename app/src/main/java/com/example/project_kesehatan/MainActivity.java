package com.example.project_kesehatan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;
    private Button login;
    private TextView reg;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.bt_signIn);
        reg=findViewById(R.id.tvReg);
        mAuth = FirebaseAuth.getInstance();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    signIn();
                }
                catch (Throwable t){
                    handle(t);
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    regis();
                }
                catch (Throwable t){
                    handle(t);
                }
            }
        });


    }

    private void handle(Throwable t) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Exception!")
                .setMessage(t.toString())
                .setPositiveButton("Ok",null)
                .show();

    }

    private void regis() {
        Intent regis = new Intent(getApplicationContext(),registration.class);
        startActivity(regis);

    }


    private void signIn() {
        mAuth.signInWithEmailAndPassword(
                username.getText().toString(),
                password.getText().toString()).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), home.class);
                startActivity(i);


            }
        });
        mAuth.signInWithEmailAndPassword(
                username.getText().toString(),
                password.getText().toString()).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Maaf, Anda Gagal Login", Toast.LENGTH_LONG).show();
            }
        });

    }
}