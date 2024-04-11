package com.ie2.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

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
//        btnLogin = findViewById((R.id.btn_Login));

        btnReg.setOnClickListener(v -> {
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
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"User Registeration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            });
        });
//        btnLogin.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
    }
}