package com.ie2.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.media.metrics.EditingSession;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    private EditText emailReg;
    private EditText passReg;
    private Button btnReg;
    private Button btnLogin;
    //Firebase Authentication

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        Registration();
    }
    private void Registration(){
        emailReg = findViewById(R.id.email_registration);
        passReg = findViewById((R.id.registration_password));

        btnReg = findViewById(R.id.btn_registration);
        btnLogin = findViewById((R.id.btn_login));

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailReg.getText().toString().trim();
                String pass = passReg.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    emailReg.setError("Required Field");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    passReg.setError("Required Field");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"User Registeration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }
                    }
                });
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}