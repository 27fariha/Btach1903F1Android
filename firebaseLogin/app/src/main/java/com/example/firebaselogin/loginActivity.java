package com.example.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    private EditText email,password;
    private Button login;
    private FirebaseAuth auth;
    TextView reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.editTextTextEmail);
        password=findViewById(R.id.editTextTextPassword);
        login=findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();
        reset=findViewById(R.id.textView3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_pass=password.getText().toString();
                UserLogin(txt_email,txt_pass);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(loginActivity.this,forgetPassActivity.class);
                startActivity(i);
            }
        });
    }

    private void UserLogin(String txt_email, String txt_pass) {
        auth.signInWithEmailAndPassword(txt_email, txt_pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(loginActivity.this,"Login Succeessfull",Toast.LENGTH_LONG).show();
                startActivity(new Intent(loginActivity.this,Dashboard.class));
                finish();
            }
        });
    }
}