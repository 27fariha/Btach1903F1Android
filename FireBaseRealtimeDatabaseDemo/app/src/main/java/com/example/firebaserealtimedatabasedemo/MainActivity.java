package com.example.firebaserealtimedatabasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
FirebaseDatabase db;
FirebaseAuth auth;
EditText editname,editemail,editusername,editpass,editrepass;
Button btncreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=FirebaseDatabase.getInstance();
        editname=findViewById(R.id.editTextTextPersonName);
        editemail=findViewById(R.id.editTextEmail);
        editusername=findViewById(R.id.editTextUsername);
        editpass=findViewById(R.id.editTextPassword);
        editrepass=findViewById(R.id.editTextConfirmPass);
        btncreate=findViewById(R.id.button);

        auth=FirebaseAuth.getInstance();

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editname.getText().toString();
                String email=editemail.getText().toString();
                String username=editusername.getText().toString();
                String pass=editpass.getText().toString();
                String repass=editrepass.getText().toString();

                if( name.isEmpty() || email.isEmpty() || username.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this,"Empty Credentials",Toast.LENGTH_LONG).show();
                }
                else if(pass.length() < 8){
                    Toast.makeText(MainActivity.this,"Password must be greater than 8 characters",Toast.LENGTH_LONG).show();
                }
                else  if(!pass.equals(repass)){
                    Toast.makeText(MainActivity.this,"Password Did not Match",Toast.LENGTH_LONG).show();
                } // pass != repass
                else {
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                HashMap<String,Object> users=new HashMap<>();
                                users.put("Name",name);
                                users.put("Email",email);
                                users.put("Username",username);

                                FirebaseUser user = auth.getCurrentUser();
                                FirebaseDatabase.getInstance().getReference().child("Account").child(user.getUid()).updateChildren(users);
                                String useremail=user.getEmail();
//                                Intent i = new Intent();
//                                i.putExtra("email",useremail);
                            Toast.makeText(MainActivity.this,"Account Created",Toast.LENGTH_LONG).show();}
                            else {
                                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });







//        //1st method
//       FirebaseDatabase.getInstance().getReference().child("Languages1").child("PHP").setValue("This is some text");
//
//       //2nd method
//        HashMap<String,Object> mapp=new HashMap<>();
//        mapp.put("Name","Hammad");
//        mapp.put("Age",20);
//        mapp.put("Email","hammad123@abc.com");
//
//        FirebaseDatabase.getInstance().getReference().child("Register").child("user2").updateChildren(mapp);



    }
}