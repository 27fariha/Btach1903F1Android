package com.example.firebaselogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private EditText email,password;
    private Button reg;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.editTextTextEmail);
        password=findViewById(R.id.editTextTextPassword);
        reg=findViewById(R.id.button);
        auth = FirebaseAuth.getInstance();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtxt=email.getText().toString();
                String passtxt=password.getText().toString();
                if(TextUtils.isEmpty(emailtxt )|| TextUtils.isEmpty(passtxt)){
                    Toast.makeText(RegisterActivity.this,"Empty Credential",Toast.LENGTH_LONG).show();
                }
                else if(passtxt.length() <6){
                    Toast.makeText(RegisterActivity.this,"Password to short",Toast.LENGTH_LONG).show();
                }
                else{
                    UserRegisttation(emailtxt,passtxt);
                }
            }
        });
    }

    private void UserRegisttation(String emailtxt, String passtxt) {
        auth.createUserWithEmailAndPassword(emailtxt,passtxt).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Register",Toast.LENGTH_LONG).show();
                    FirebaseUser user = auth.getCurrentUser();
                    startActivity(new Intent(RegisterActivity.this,Dashboard.class));
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Register Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}