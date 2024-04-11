package com.ie2.jobportal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button btnLogin;
    private Button btnRegistration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFunction();
    }

    private void LoginFunction(){
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.login_password);

        btnLogin = findViewById(R.id.btn_login);
        btnRegistration = findViewById((R.id.btn_reg));

        btnLogin.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"User Logged in Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        });
        btnRegistration.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), RegistrationActivity.class)));
    }
}