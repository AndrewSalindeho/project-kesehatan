package com.example.project_kesehatan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
    private EditText username, password;
    private Button regis;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username=findViewById(R.id.et_new_email);
        password=findViewById(R.id.et_new_password);
        mAuth=FirebaseAuth.getInstance();
        regis=findViewById(R.id.bt_addUser);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    regis();
                }
                catch (Throwable r){
                    handle(r);
                }
            }
        });
    }

    private void handle(Throwable r) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Warning, Complete All Field!");
        builder.setMessage("Email or password can not be empty, please complete all field!");
        builder.setPositiveButton("Ok", null).show();
    }


    private void regis() {
        mAuth.createUserWithEmailAndPassword(
                username.getText().toString(),
                password.getText().toString()).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(registration.this, "Berhasil di tambahkan", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else{

                            Toast.makeText(registration.this, "Tambah User Gagal!", Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }
}